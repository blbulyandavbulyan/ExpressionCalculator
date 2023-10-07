package org.blbulyandavbulyan.exprcalc

import org.blbulyandavbulyan.exprcalc.rpn.OperationFactory
import org.blbulyandavbulyan.exprcalc.rpn.RPNConverter
import org.blbulyandavbulyan.exprcalc.rpn.ExpressionFactory

fun main() {
    val expressionFactory = ExpressionFactory(OperationFactory())
    var command: String = readln()
    while (command != "exit"){
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
        command = readln()
    }
}