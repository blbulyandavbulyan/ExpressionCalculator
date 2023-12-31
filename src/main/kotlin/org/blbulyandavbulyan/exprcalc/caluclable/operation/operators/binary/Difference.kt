package org.blbulyandavbulyan.exprcalc.caluclable.operation.operators.binary

import org.blbulyandavbulyan.exprcalc.annotations.Associativity
import org.blbulyandavbulyan.exprcalc.annotations.Name
import org.blbulyandavbulyan.exprcalc.annotations.OperationInfo
import org.blbulyandavbulyan.exprcalc.annotations.Priority
import org.blbulyandavbulyan.exprcalc.caluclable.Calculable

/**
 * Предоставляет вычитание
 * @param a уменьшаемое
 * @param b вычитаемое
 */
@Name("-")
@OperationInfo(Associativity.LEFT, Priority.SUMMA_DIFFERENCE)
class Difference(a: Calculable, b: Calculable): BinaryOperator(a, b) {
    /**
     * @return разность a и b
     */
    override fun calc(): Double = a.calc() - b.calc()
}