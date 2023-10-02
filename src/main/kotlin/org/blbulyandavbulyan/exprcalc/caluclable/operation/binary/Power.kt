package org.blbulyandavbulyan.exprcalc.caluclable.operation.binary

import org.blbulyandavbulyan.exprcalc.annotations.Operator
import org.blbulyandavbulyan.exprcalc.caluclable.Calculable
import kotlin.math.pow
@Operator(name = "^", Operator.Associativity.RIGHT, 3)
class Power(a: Calculable, b: Calculable) : BinaryOperation(a, b) {
    override fun calc(): Double = a.calc().pow(b.calc())
}