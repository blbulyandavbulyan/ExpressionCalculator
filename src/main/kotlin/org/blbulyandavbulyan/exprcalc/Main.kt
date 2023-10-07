package org.blbulyandavbulyan.exprcalc

import org.blbulyandavbulyan.exprcalc.exceptions.ExpressionCalculatorException
import org.blbulyandavbulyan.exprcalc.rpn.ExpressionFactory
import org.blbulyandavbulyan.exprcalc.rpn.OperationFactory

fun main() {
    val expressionFactory = ExpressionFactory(OperationFactory())
    var command: String;
    while (true){
        command = readln()
        if(command == "exit")break;
        try {
            val expression = expressionFactory.parseExpression(command);
            val variableNames = expression.variableNames
            if(variableNames.isNotEmpty()){
                //здесь должен быть цикл запроса значений переменных
                for (variableName in variableNames) {
                    print("Введите значение переменной $variableName: ")
                    expression[variableName] = readln().toDouble()
                }
            }
            println(expression.calc())
        }
        catch (e: ExpressionCalculatorException){
            println(e.message)
        }
    }
}