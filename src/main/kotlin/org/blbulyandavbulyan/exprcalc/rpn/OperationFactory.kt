package org.blbulyandavbulyan.exprcalc.rpn

import org.blbulyandavbulyan.exprcalc.annotations.Operator
import org.blbulyandavbulyan.exprcalc.caluclable.Calculable
import org.blbulyandavbulyan.exprcalc.caluclable.operation.Operation
import org.reflections.Reflections
import java.lang.reflect.Constructor
import java.lang.reflect.Modifier

class OperationFactory {
    private val operators: MutableMap<String, Constructor<out Operation>> = HashMap()
    init {
        getAllOperationSubClasses()
            .filter { !Modifier.isAbstract(it.modifiers) && it.isAnnotationPresent(Operator::class.java)}
            .map { Pair(it.getAnnotation(Operator::class.java).name, it.constructors[0] as Constructor<out Operation>) }
            .map { it }.toMap(operators)
    }
    fun create(operatorName: String, getParameter: ()->Calculable): Operation{
        val operationProducer = operators[operatorName] ?: throw UnsupportedOperationException("Operator $operatorName is not supported!")
        val size = operationProducer.parameters.size
        val args: MutableList<Calculable> = ArrayList(size)
        repeat(size){
            args.add(0, getParameter())
        }
        return operationProducer.newInstance(*args.toTypedArray())
    }
    private fun getAllOperationSubClasses() : Collection<Class<out Operation>>{
        val reflections = Reflections("org.blbulyandavbulyan.exprcalc.caluclable.operation");
        return reflections.getSubTypesOf(Operation::class.java)
    }
    operator fun contains(operatorName: String): Boolean = operatorName in operators
}