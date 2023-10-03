package org.blbulyandavbulyan.exprcalc.exceptions.variable

import java.lang.RuntimeException

class VariableNotInitializedException(variableName: String): RuntimeException("Variable $variableName is not initialized!") {
}