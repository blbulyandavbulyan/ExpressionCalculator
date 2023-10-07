package org.blbulyandavbulyan.exprcalc.exceptions.variable

import org.blbulyandavbulyan.exprcalc.exceptions.ExpressionCalculatorException

class VariableNotInitializedException(variableName: String): ExpressionCalculatorException("Variable $variableName is not initialized!") {
}