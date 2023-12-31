package org.blbulyandavbulyan.exprcalc.rpn

import org.blbulyandavbulyan.exprcalc.caluclable.Calculable
import org.blbulyandavbulyan.exprcalc.caluclable.value.Variable
import org.blbulyandavbulyan.exprcalc.exceptions.variable.UndefinedVariableException
import org.blbulyandavbulyan.exprcalc.exceptions.variable.VariableNotInitializedException

class Expression(private val calculable: Calculable, private val variables: Map<String, List<Variable>>, val variableNames: Set<String> = variables.keys) : Calculable {
    operator fun set(variableName: String, value: Double) =
        (variables[variableName] ?: throw UndefinedVariableException(variableName)).forEach { it.v = value }

    override fun calc(): Double {
        //проверяем что все переменные инициализированные
        variables.entries.forEach { entry ->
            entry.value.forEach { if (!it.isInitialized()) throw VariableNotInitializedException(entry.key) }
        }
        return calculable.calc()
    }

}