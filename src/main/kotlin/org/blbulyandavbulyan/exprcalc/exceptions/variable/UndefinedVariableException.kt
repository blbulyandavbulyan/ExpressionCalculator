package org.blbulyandavbulyan.exprcalc.exceptions.variable

import java.lang.RuntimeException

class UndefinedVariableException(variableName: String) : RuntimeException("Variable '$variableName' is undefined!")