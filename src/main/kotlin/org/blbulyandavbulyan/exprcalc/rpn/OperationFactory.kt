package org.blbulyandavbulyan.exprcalc.rpn

import org.blbulyandavbulyan.exprcalc.annotations.Name
import org.blbulyandavbulyan.exprcalc.caluclable.Calculable
import org.blbulyandavbulyan.exprcalc.caluclable.operation.Operation
import org.reflections.Reflections
import java.lang.reflect.Constructor
import java.lang.reflect.Modifier
class OperationFactory {

    private val operations: MutableMap<String, Constructor<out Operation>> = HashMap()
    init {
        getAllOperationSubClasses()
            .filter { !Modifier.isAbstract(it.modifiers) && it.isAnnotationPresent(Name::class.java) }
            .associateTo(operations) {
                Pair(
                    it.getAnnotation(Name::class.java).name,
                    it.constructors[0] as Constructor<out Operation>
                )
            }
    }
    fun create(operatorName: String, getParameter: ()->Calculable): Operation{
        val operationProducer = operations[operatorName] ?: throw UnsupportedOperationException("Operator $operatorName is not supported!")
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
    operator fun contains(operatorName: String): Boolean = operatorName in operations
    fun getOperatorsInfos(): Map<String, OperatorInfo> = operations.entries
        .map { Pair(it.key, it.value.getAnnotation(org.blbulyandavbulyan.exprcalc.annotations.OperatorInfo::class.java)) }
        .filter { it.second != null }
        .associate { Pair(it.first, OperatorInfo(it.second.priority, it.second.associativity)) }
    fun getFunctionNames(): Collection<String> =
        operations.entries.filter { Operation.AbstractFunction::class.java.isAssignableFrom(it.value.declaringClass)}
            .map { it.key }
}