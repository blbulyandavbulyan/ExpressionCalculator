package org.blbulyandavbulyan.exprcalc.caluclable.operation.functions

import org.blbulyandavbulyan.exprcalc.annotations.Name
import org.blbulyandavbulyan.exprcalc.caluclable.Calculable
import org.blbulyandavbulyan.exprcalc.caluclable.operation.Operation
import kotlin.math.sqrt

/**
 * Предоставляет квадратный корень
 * @param a число, из которого будет извлечён корень
 */
@Name("sqrt")
class Sqrt(private val a: Calculable): Operation.AbstractFunction() {
    override fun calc(): Double = sqrt(a.calc())
}