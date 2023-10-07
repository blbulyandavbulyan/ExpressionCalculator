package org.blbulyandavbulyan.exprcalc.caluclable.value

import org.blbulyandavbulyan.exprcalc.caluclable.Calculable

/**
 * Предоставляет константу
 * @param v значение константы
 */
class Constant(private val v: Double): Calculable {
    override fun calc(): Double = v
}