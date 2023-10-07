package org.blbulyandavbulyan.exprcalc.caluclable.operation

import org.blbulyandavbulyan.exprcalc.caluclable.Calculable

/**
 * Предоставляет класс операции
 */
sealed class Operation: Calculable {
    /**
     * Данный класс предоставляет абстрактную функцию
     */
    abstract class AbstractFunction: Operation()

    /**
     * Данный класс предоставляет абстракцию для оператора
     */
    abstract class Operator: Operation()
}