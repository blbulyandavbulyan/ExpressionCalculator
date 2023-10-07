package org.blbulyandavbulyan.exprcalc.caluclable.operation.function

import org.blbulyandavbulyan.exprcalc.annotations.Name
import org.blbulyandavbulyan.exprcalc.caluclable.Calculable
import org.blbulyandavbulyan.exprcalc.caluclable.operation.Operation
import kotlin.math.sin

/**
 * Предоставляет тригонометрическую функцию sin(a)
 * @param a аргумент функции
 */
@Name("sin")
class Sinus(private val a: Calculable): Operation.AbstractFunction() {
    override fun calc(): Double = sin(a.calc())
}