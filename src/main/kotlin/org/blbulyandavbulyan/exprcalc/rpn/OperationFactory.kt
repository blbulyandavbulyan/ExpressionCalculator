package org.blbulyandavbulyan.exprcalc.rpn

import org.blbulyandavbulyan.exprcalc.annotations.Associativity
import org.blbulyandavbulyan.exprcalc.annotations.Name
import org.blbulyandavbulyan.exprcalc.annotations.OperationInfo
import org.blbulyandavbulyan.exprcalc.annotations.Priority
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
    fun getOperatorsInfos(): Map<String, OperatorInfo> {
        return operations.entries.associate {
            val declaringClass = it.value.declaringClass
            val operationInfo = declaringClass.getAnnotation(OperationInfo::class.java)
            val operatorInfo: OperatorInfo = if (operationInfo != null) {
                OperatorInfo(operationInfo.priority, operationInfo.associativity)
            } else if (Operation.AbstractFunction::class.java.isAssignableFrom(declaringClass)) {
                OperatorInfo(Priority.FUNCTION, Associativity.LEFT)
            } else throw RuntimeException();
            Pair(it.key, operatorInfo)
        }
    }
}