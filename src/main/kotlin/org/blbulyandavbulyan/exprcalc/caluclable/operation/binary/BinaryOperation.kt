package org.blbulyandavbulyan.exprcalc.caluclable.operation.binary

import org.blbulyandavbulyan.exprcalc.caluclable.Calculable
import org.blbulyandavbulyan.exprcalc.caluclable.operation.Operation

abstract class BinaryOperation(protected val a: Calculable, protected val b: Calculable) : Operation()