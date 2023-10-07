package org.blbulyandavbulyan.exprcalc.caluclable.operation.operators.binary

import org.blbulyandavbulyan.exprcalc.caluclable.Calculable
import org.blbulyandavbulyan.exprcalc.caluclable.operation.Operation

/**
 * Предоставляет абстрактную бинарную операцию
 * @param a первый операнд
 * @param b второй операнд
 */
abstract class BinaryOperator(protected val a: Calculable, protected val b: Calculable) : Operation.Operator()