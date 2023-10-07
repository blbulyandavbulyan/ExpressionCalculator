package org.blbulyandavbulyan.exprcalc.exceptions.variable

import org.blbulyandavbulyan.exprcalc.exceptions.ExpressionCalculatorException

class UndefinedVariableException(variableName: String) : ExpressionCalculatorException("Variable '$variableName' is undefined!")