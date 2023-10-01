package org.blbulyandavbulyan.exprcalc.caluclable.operation.unary

import org.blbulyandavbulyan.exprcalc.caluclable.Calculable

class UnaryMinus(private val a: Calculable) : UnaryOperation(a) {
    override fun calc(): Double = -(a.calc())
}