package org.blbulyandavbulyan.exprcalc.caluclable.operation.operators.binary

import org.blbulyandavbulyan.exprcalc.annotations.Associativity
import org.blbulyandavbulyan.exprcalc.annotations.Name
import org.blbulyandavbulyan.exprcalc.annotations.OperationInfo
import org.blbulyandavbulyan.exprcalc.annotations.Priority
import org.blbulyandavbulyan.exprcalc.caluclable.Calculable

/**
 * Предоставляет сумму двух чисел
 * @param a первое слагаемое
 * @param b второе слагаемое
 */
@Name("+")
@OperationInfo(Associativity.LEFT, Priority.SUMMA_DIFFERENCE)
class Summa(a: Calculable, b: Calculable): BinaryOperator(a, b) {
    override fun calc(): Double = a.calc() + b.calc()
}