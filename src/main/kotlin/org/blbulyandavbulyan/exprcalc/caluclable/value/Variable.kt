package org.blbulyandavbulyan.exprcalc.caluclable.value

import org.blbulyandavbulyan.exprcalc.caluclable.Calculable

class Variable(var v: Double) : Calculable {
    override fun calc(): Double = v
}