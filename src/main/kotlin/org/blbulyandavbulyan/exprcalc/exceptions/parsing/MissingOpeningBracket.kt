package org.blbulyandavbulyan.exprcalc.exceptions.parsing

/**
 * Данное исключение выбрасывается, если была пропущена открывающая скобка
 */
class MissingOpeningBracket: ParsingException("Похоже, вы пропустили ( в выражении")