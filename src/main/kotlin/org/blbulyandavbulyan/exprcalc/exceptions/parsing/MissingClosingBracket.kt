package org.blbulyandavbulyan.exprcalc.exceptions.parsing

/**
 * Данное исключение выбрасывается, если пропущена закрытая скобка
 */
class MissingClosingBracket: ParsingException("Похоже вы пропустили ) в выражении")