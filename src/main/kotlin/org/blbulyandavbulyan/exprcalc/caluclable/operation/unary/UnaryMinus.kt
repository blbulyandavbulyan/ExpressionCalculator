package org.blbulyandavbulyan.exprcalc.caluclable.operation.unary

import org.blbulyandavbulyan.exprcalc.annotations.Operator
import org.blbulyandavbulyan.exprcalc.caluclable.Calculable
@Operator("#")
class UnaryMinus(a: Calculable) : UnaryOperation(a) {
    override fun calc(): Double = -(a.calc())
}