package org.blbulyandavbulyan.exprcalc.caluclable.operation.binary

import org.blbulyandavbulyan.exprcalc.annotations.Associativity
import org.blbulyandavbulyan.exprcalc.annotations.Name
import org.blbulyandavbulyan.exprcalc.annotations.OperatorInfo
import org.blbulyandavbulyan.exprcalc.caluclable.Calculable
import kotlin.math.pow
@Name("^")
@OperatorInfo(Associativity.RIGHT, 3)
class Power(a: Calculable, b: Calculable) : BinaryOperator(a, b) {
    override fun calc(): Double = a.calc().pow(b.calc())
}