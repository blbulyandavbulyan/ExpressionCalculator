package org.blbulyandavbulyan.exprcalc.caluclable.operation

import org.blbulyandavbulyan.exprcalc.annotations.Operator
import org.blbulyandavbulyan.exprcalc.caluclable.Calculable
import kotlin.math.pow
@Operator("^")
class Power(a: Calculable, b: Calculable) : BinaryOperation(a, b) {
    override fun calc(): Double = a.calc().pow(b.calc())
}