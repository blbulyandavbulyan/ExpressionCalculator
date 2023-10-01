package org.blbulyandavbulyan.exprcalc.exceptions

import java.lang.RuntimeException

class VariableNotInitializedException(variableName: String): RuntimeException("Variable $variableName is not initialized!") {
}