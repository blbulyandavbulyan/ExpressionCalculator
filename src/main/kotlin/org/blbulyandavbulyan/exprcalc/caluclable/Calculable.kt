package org.blbulyandavbulyan.exprcalc.caluclable

/**
 * Базовый интерфейс, предоставляющий корень объектной иерархии для построения выражений
 */
interface Calculable {
    /**
     * Рассчитывает значение
     * @return посчитанное значение
     */
    fun calc(): Double
}