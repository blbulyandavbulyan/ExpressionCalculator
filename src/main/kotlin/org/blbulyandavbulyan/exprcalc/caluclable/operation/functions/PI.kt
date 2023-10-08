package org.blbulyandavbulyan.exprcalc.caluclable.operation.functions

import org.blbulyandavbulyan.exprcalc.annotations.Name
import org.blbulyandavbulyan.exprcalc.caluclable.operation.Operation
import kotlin.math.PI
@Name("PI")
class PI: Operation.AbstractFunction() {
    override fun calc(): Double = PI
}