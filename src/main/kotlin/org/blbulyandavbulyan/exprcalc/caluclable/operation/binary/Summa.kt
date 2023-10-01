package org.blbulyandavbulyan.exprcalc.caluclable.operation.binary

import org.blbulyandavbulyan.exprcalc.annotations.Operator
import org.blbulyandavbulyan.exprcalc.caluclable.Calculable
@Operator("+")
class Summa(a: Calculable, b: Calculable): BinaryOperation(a, b) {
    override fun calc(): Double = a.calc() + b.calc()
}