package org.blbulyandavbulyan.exprcalc.caluclable.value

import org.blbulyandavbulyan.exprcalc.caluclable.Calculable

class Variable(var v: Double?) : Calculable {
    constructor() : this(null)
    override fun calc(): Double = v ?: throw RuntimeException()
    fun isInitialized(): Boolean = v !== null
}