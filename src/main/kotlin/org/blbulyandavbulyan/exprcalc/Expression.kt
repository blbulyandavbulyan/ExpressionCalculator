package org.blbulyandavbulyan.exprcalc

import org.blbulyandavbulyan.exprcalc.caluclable.Calculable
import org.blbulyandavbulyan.exprcalc.caluclable.value.Variable
import org.blbulyandavbulyan.exprcalc.exceptions.UndefinedVariableException

class Expression(calculable: Calculable, private val variables: Map<String, List<Variable>>): Calculable by calculable{
    operator fun set(variableName: String, value: Double) =
        (variables[variableName] ?: throw UndefinedVariableException(variableName)).forEach { it.v = value }
}