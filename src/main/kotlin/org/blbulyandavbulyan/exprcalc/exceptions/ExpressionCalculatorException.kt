package org.blbulyandavbulyan.exprcalc.exceptions

/**
 * Корневой класс иерархии исключений
 * @param msg сообщение для исключения
 */
open class ExpressionCalculatorException(msg: String) : RuntimeException(msg)