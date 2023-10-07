package org.blbulyandavbulyan.exprcalc.caluclable.value

import org.blbulyandavbulyan.exprcalc.caluclable.Calculable

/**
 * Предоставляет переменную
 * @param v значение переменной
 */
class Variable(var v: Double?) : Calculable {
    constructor() : this(null)
    override fun calc(): Double = v ?: throw RuntimeException()

    /**
     * Проверяет, инициализирована ли переменная
     * @return true, если переменная инициализирована
     */
    fun isInitialized(): Boolean = v !== null
}