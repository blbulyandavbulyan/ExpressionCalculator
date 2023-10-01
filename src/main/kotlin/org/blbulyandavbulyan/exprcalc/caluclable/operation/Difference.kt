package org.blbulyandavbulyan.exprcalc.caluclable.operation

import org.blbulyandavbulyan.exprcalc.caluclable.Calculable

class Difference(a: Calculable, b: Calculable): BinaryOperation(a, b) {
    override fun calc(): Double = a.calc() - b.calc()
}