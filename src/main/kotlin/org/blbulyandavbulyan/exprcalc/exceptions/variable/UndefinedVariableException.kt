package org.blbulyandavbulyan.exprcalc.exceptions.variable

import org.blbulyandavbulyan.exprcalc.exceptions.ExpressionCalculatorException

/**
 * Данное исключение выбрасывается при попытке присвоить значения неопределённой переменной
 * @param variableName имя переменной, которую пытались присвоить
 */
class UndefinedVariableException(variableName: String) : ExpressionCalculatorException("Variable '$variableName' is undefined!")