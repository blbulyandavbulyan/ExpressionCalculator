package org.blbulyandavbulyan.exprcalc.caluclable.operation.operators.binary

import org.blbulyandavbulyan.exprcalc.annotations.Associativity
import org.blbulyandavbulyan.exprcalc.annotations.Name
import org.blbulyandavbulyan.exprcalc.annotations.OperationInfo
import org.blbulyandavbulyan.exprcalc.annotations.Priority
import org.blbulyandavbulyan.exprcalc.caluclable.Calculable
import kotlin.math.pow

/**
 * Предоставляет возведение в степень
 * @param a основание
 * @param b степень
 */
@Name("^")
@OperationInfo(Associativity.RIGHT, Priority.POWER)
class Power(a: Calculable, b: Calculable) : BinaryOperator(a, b) {
    /**
     * @return результат возведение a в степень b
     */
    override fun calc(): Double = a.calc().pow(b.calc())
}