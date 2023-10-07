package org.blbulyandavbulyan.exprcalc.caluclable.operation.unary

import org.blbulyandavbulyan.exprcalc.caluclable.Calculable
import org.blbulyandavbulyan.exprcalc.caluclable.operation.Operation

/**
 * Абстрактный класс для унарных операторов
 * @param a параметр, к которому будет применена унарная операция
 */
abstract class UnaryOperator(protected val a: Calculable): Operation.Operator()