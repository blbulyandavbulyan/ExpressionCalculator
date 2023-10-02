package org.blbulyandavbulyan.exprcalc.caluclable.operation.binary

import org.blbulyandavbulyan.exprcalc.annotations.Associativity
import org.blbulyandavbulyan.exprcalc.annotations.Name
import org.blbulyandavbulyan.exprcalc.annotations.OperatorInfo
import org.blbulyandavbulyan.exprcalc.caluclable.Calculable
@Name("*")
@OperatorInfo(Associativity.LEFT, 2)
class Multiplication(a: Calculable, b: Calculable) : BinaryOperator(a, b){
    override fun calc(): Double = a.calc() * b.calc()
}