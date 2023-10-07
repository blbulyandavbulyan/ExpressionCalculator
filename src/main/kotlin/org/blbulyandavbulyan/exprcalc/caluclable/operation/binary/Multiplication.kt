package org.blbulyandavbulyan.exprcalc.caluclable.operation.binary

import org.blbulyandavbulyan.exprcalc.annotations.Associativity
import org.blbulyandavbulyan.exprcalc.annotations.Name
import org.blbulyandavbulyan.exprcalc.annotations.OperationInfo
import org.blbulyandavbulyan.exprcalc.annotations.Priority
import org.blbulyandavbulyan.exprcalc.caluclable.Calculable

/**
 * Предоставляет умножение двух чисел
 * @param a первый множитель
 * @param b второй множитель
 */
@Name("*")
@OperationInfo(Associativity.LEFT, Priority.DIVISION_MULTIPLICATION)
class Multiplication(a: Calculable, b: Calculable) : BinaryOperator(a, b){
    /**
     * @return произведение a и b
     */
    override fun calc(): Double = a.calc() * b.calc()
}