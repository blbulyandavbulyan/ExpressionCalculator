package org.blbulyandavbulyan.exprcalc.caluclable.operation.binary

import org.blbulyandavbulyan.exprcalc.annotations.Associativity
import org.blbulyandavbulyan.exprcalc.annotations.Name
import org.blbulyandavbulyan.exprcalc.annotations.OperationInfo
import org.blbulyandavbulyan.exprcalc.annotations.Priority
import org.blbulyandavbulyan.exprcalc.caluclable.Calculable
import kotlin.math.pow
@Name("^")
@OperationInfo(Associativity.RIGHT, Priority.POWER)
class Power(a: Calculable, b: Calculable) : BinaryOperator(a, b) {
    override fun calc(): Double = a.calc().pow(b.calc())
}