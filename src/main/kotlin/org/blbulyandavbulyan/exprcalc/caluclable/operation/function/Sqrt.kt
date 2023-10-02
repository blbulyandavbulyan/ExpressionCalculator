package org.blbulyandavbulyan.exprcalc.caluclable.operation.function

import org.blbulyandavbulyan.exprcalc.annotations.Name
import org.blbulyandavbulyan.exprcalc.caluclable.Calculable
import org.blbulyandavbulyan.exprcalc.caluclable.operation.Operation
import kotlin.math.sqrt
@Name("sqrt")
class Sqrt(private val a: Calculable): Operation.AbstractFunction() {
    override fun calc(): Double = sqrt(a.calc())
}