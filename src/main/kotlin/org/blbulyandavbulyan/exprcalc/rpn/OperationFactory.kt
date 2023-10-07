package org.blbulyandavbulyan.exprcalc.rpn

import org.blbulyandavbulyan.exprcalc.caluclable.Calculable
import org.blbulyandavbulyan.exprcalc.caluclable.operation.Operation
import java.lang.reflect.Constructor

class OperationFactory(private val operations: MutableMap<String, Constructor<out Operation>>) {
    fun create(operatorName: String, getParameter: ()->Calculable): Operation{
        val operationProducer = operations[operatorName] ?: throw UnsupportedOperationException("Operator $operatorName is not supported!")
        val size = operationProducer.parameters.size
        val args: MutableList<Calculable> = ArrayList(size)
        repeat(size){
            args.add(0, getParameter())
        }
        return operationProducer.newInstance(*args.toTypedArray())
    }
    operator fun contains(operatorName: String): Boolean = operatorName in operations
}