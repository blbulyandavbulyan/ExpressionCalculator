package org.blbulyandavbulyan.exprcalc.caluclable.operation.operators.unary

import org.blbulyandavbulyan.exprcalc.annotations.Associativity
import org.blbulyandavbulyan.exprcalc.annotations.Name
import org.blbulyandavbulyan.exprcalc.annotations.OperationInfo
import org.blbulyandavbulyan.exprcalc.annotations.Priority
import org.blbulyandavbulyan.exprcalc.caluclable.Calculable

/**
 * Данный класс предоставляет унарный минус
 * @param a параметр, к которому будет применён унарный минус
 */
@Name("#")
@OperationInfo(Associativity.LEFT, Priority.UNARY_MINUS)
class UnaryMinus(a: Calculable) : UnaryOperator(a) {
    override fun calc(): Double = -(a.calc())
}