package org.blbulyandavbulyan.exprcalc.caluclable.operation.unary

import org.blbulyandavbulyan.exprcalc.annotations.Associativity
import org.blbulyandavbulyan.exprcalc.annotations.Name
import org.blbulyandavbulyan.exprcalc.annotations.OperatorInfo
import org.blbulyandavbulyan.exprcalc.caluclable.Calculable
@Name("#")
@OperatorInfo(Associativity.LEFT, 4)
class UnaryMinus(a: Calculable) : UnaryOperator(a) {
    override fun calc(): Double = -(a.calc())
}