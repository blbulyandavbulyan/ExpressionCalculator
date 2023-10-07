package org.blbulyandavbulyan.exprcalc.caluclable.operation.functions

import org.blbulyandavbulyan.exprcalc.annotations.Name
import org.blbulyandavbulyan.exprcalc.caluclable.Calculable
import org.blbulyandavbulyan.exprcalc.caluclable.operation.Operation
import kotlin.math.cos

/**
 * Предоставляет тригонометрическую функцию cos(a)
 * @param a аргумент функции
 */
@Name("cos")
class Cosinus(private val a: Calculable): Operation.AbstractFunction() {
    override fun calc(): Double = cos(a.calc())
}