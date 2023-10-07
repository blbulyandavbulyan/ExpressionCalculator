package org.blbulyandavbulyan.exprcalc.exceptions.variable

import org.blbulyandavbulyan.exprcalc.exceptions.ExpressionCalculatorException

/**
 * Данное исключение выбрасывается, если при вычислении выражения одна из переменных оказалась неинициализированной
 * @param variableName имя переменной, которая была не инициализирована
 */
class VariableNotInitializedException(variableName: String): ExpressionCalculatorException("Variable $variableName is not initialized!")