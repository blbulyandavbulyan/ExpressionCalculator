package org.blbulyandavbulyan.exprcalc.exceptions.parsing

import org.blbulyandavbulyan.exprcalc.exceptions.ExpressionCalculatorException

/**
 * Данное исключение выбрасывается парсером, который преобразует выражение из инфиксной формы в RPN
 * @param message сообщение об ошибке
 */
open class ParsingException(message: String) : ExpressionCalculatorException(message)