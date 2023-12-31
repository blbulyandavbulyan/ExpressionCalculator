package org.blbulyandavbulyan.exprcalc

import org.blbulyandavbulyan.exprcalc.exceptions.ExpressionCalculatorException
import org.blbulyandavbulyan.exprcalc.rpn.ExpressionParserBuilder

fun main() {
    val expressionParser = ExpressionParserBuilder().withDefaultFunctions().build()
    var command: String;
    while (true){
        print("Введите выражение: ")
        command = readln()
        if(command == "exit")break;
        try {
            val expression = expressionParser(command);
            val variableNames = expression.variableNames
            if(variableNames.isNotEmpty()){
                //здесь должен быть цикл запроса значений переменных
                for (variableName in variableNames) {
                    print("$variableName = ")
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