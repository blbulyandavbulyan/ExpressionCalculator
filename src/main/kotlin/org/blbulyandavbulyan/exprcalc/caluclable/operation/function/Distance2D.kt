package org.blbulyandavbulyan.exprcalc.caluclable.operation.function

import org.blbulyandavbulyan.exprcalc.annotations.Name
import org.blbulyandavbulyan.exprcalc.caluclable.Calculable
import org.blbulyandavbulyan.exprcalc.caluclable.operation.Operation
import kotlin.math.pow
import kotlin.math.sqrt

/**
 * Предоставляет расстояние между точками A(x1; y1) и B(x2; y2)
 * @param x1 абсцисса первой точки
 * @param y1 ордината первой точки
 * @param x2 абсцисса второй точки
 * @param y2 ордината второй точки
 */
@Name("dist")
class Distance2D(private val x1: Calculable, private val y1: Calculable, private val x2: Calculable, private val y2: Calculable): Operation.AbstractFunction() {
    /**
     * @return расстояние между точками A и B, координаты которых были заданы в конструкторе
     */
    override fun calc(): Double = sqrt((x1.calc()-x2.calc()).pow(2) + (y1.calc() - y2.calc()).pow(2))
}