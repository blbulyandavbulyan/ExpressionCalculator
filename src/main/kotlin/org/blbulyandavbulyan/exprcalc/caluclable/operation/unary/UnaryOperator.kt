package org.blbulyandavbulyan.exprcalc.caluclable.operation.unary

import org.blbulyandavbulyan.exprcalc.caluclable.Calculable
import org.blbulyandavbulyan.exprcalc.caluclable.operation.Operation

abstract class UnaryOperator(protected val a: Calculable): Operation.Operator()