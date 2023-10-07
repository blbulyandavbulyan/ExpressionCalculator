package org.blbulyandavbulyan.exprcalc.caluclable.operation.operators.binary

import org.blbulyandavbulyan.exprcalc.annotations.Associativity
import org.blbulyandavbulyan.exprcalc.annotations.Name
import org.blbulyandavbulyan.exprcalc.annotations.OperationInfo
import org.blbulyandavbulyan.exprcalc.annotations.Priority
import org.blbulyandavbulyan.exprcalc.caluclable.Calculable

/**
 * Предоставляет деление
 * @param a делимое
 * @param b делитель
 */
@Name("/")
@OperationInfo(Associativity.LEFT, Priority.DIVISION_MULTIPLICATION)
class Division(a: Calculable, b: Calculable) : BinaryOperator(a, b) {
    /**
     * @return частное a и b
     */
    override fun calc(): Double = a.calc() / b.calc()
}