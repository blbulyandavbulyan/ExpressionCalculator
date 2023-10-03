package org.blbulyandavbulyan.exprcalc.caluclable.operation.function

import org.blbulyandavbulyan.exprcalc.annotations.Name
import org.blbulyandavbulyan.exprcalc.caluclable.Calculable
import org.blbulyandavbulyan.exprcalc.caluclable.operation.Operation
import kotlin.math.pow
import kotlin.math.sqrt

@Name("diff")
class Difference2D(private val x1: Calculable, private val y1: Calculable, private val x2: Calculable, private val y2: Calculable): Operation.AbstractFunction() {
    override fun calc(): Double = sqrt((x1.calc()-x2.calc()).pow(2) + (y1.calc() - y2.calc()).pow(2))
}