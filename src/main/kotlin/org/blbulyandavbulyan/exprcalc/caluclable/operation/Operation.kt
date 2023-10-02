package org.blbulyandavbulyan.exprcalc.caluclable.operation

import org.blbulyandavbulyan.exprcalc.caluclable.Calculable

sealed class Operation: Calculable {
    abstract class AbstractFunction: Operation()
    abstract class Operator: Operation()
}