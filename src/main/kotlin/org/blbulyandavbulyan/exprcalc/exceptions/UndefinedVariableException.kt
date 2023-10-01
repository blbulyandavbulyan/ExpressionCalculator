package org.blbulyandavbulyan.exprcalc.exceptions

import java.lang.RuntimeException

class UndefinedVariableException(variableName: String) : RuntimeException("Variable '$variableName' is undefined!")