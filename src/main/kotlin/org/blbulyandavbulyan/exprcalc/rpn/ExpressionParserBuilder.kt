package org.blbulyandavbulyan.exprcalc.rpn

import org.blbulyandavbulyan.exprcalc.annotations.Associativity
import org.blbulyandavbulyan.exprcalc.annotations.Name
import org.blbulyandavbulyan.exprcalc.annotations.OperationInfo
import org.blbulyandavbulyan.exprcalc.annotations.Priority
import org.blbulyandavbulyan.exprcalc.caluclable.operation.Operation
import org.reflections.Reflections
import java.lang.reflect.Constructor
import java.lang.reflect.Modifier

class ExpressionParserBuilder {
    private val functionPackages: MutableSet<String> = mutableSetOf()
    private val operations: MutableMap<String, Constructor<out Operation>> = mutableMapOf()
    private val defaultFunctionsPackage = "org.blbulyandavbulyan.exprcalc.caluclable.operation"

    fun addPackage(packageName: String): ExpressionParserBuilder {
        if(packageName !in functionPackages) {
            functionPackages.add(packageName)
            getAllOperationSubClasses(packageName)
                .filter { !Modifier.isAbstract(it.modifiers) && it.isAnnotationPresent(Name::class.java) }
                .associateTo(operations) {
                    Pair(
                        it.getAnnotation(Name::class.java).name,
                        it.constructors[0] as Constructor<out Operation>
                    )
                }
            return this
        }
        else throw IllegalStateException("Package $packageName is already added!")
    }

    fun withDefault(): ExpressionParserBuilder{
        if(defaultFunctionsPackage !in functionPackages) {
            return addPackage(defaultFunctionsPackage)
        }
        else throw IllegalStateException("Default functions already added!")
    }

    fun build(): ExpressionParser{
        return ExpressionParser(OperationFactory(operations), RPNConverter(getOperatorsInfos()))
    }
    private fun getOperatorsInfos(): Map<String, OperatorInfo> {
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
    private fun getAllOperationSubClasses(packageName: String) : Collection<Class<out Operation>> {
        return Reflections(packageName).getSubTypesOf(Operation::class.java)
    }
}