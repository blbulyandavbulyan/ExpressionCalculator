package org.blbulyandavbulyan.exprcalc

import org.blbulyandavbulyan.exprcalc.rpn.OperationFactory
import org.blbulyandavbulyan.exprcalc.rpn.RPNConverter
import org.blbulyandavbulyan.exprcalc.rpn.ExpressionFactory

fun main() {
    val expressionFactory = ExpressionFactory(OperationFactory())
    fun evaluate(expr: String): Double{
        return expressionFactory.parseExpression(expr).calc()
    }
    var command: String = readln()
    while (command != "exit"){
        println(evaluate(command))
        command = readln()
    }
}