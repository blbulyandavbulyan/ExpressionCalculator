package org.blbulyandavbulyan.exprcalc.rpn

import org.blbulyandavbulyan.exprcalc.caluclable.Calculable
import org.blbulyandavbulyan.exprcalc.caluclable.value.Constant
import org.blbulyandavbulyan.exprcalc.caluclable.value.Variable
import java.util.*

class ExpressionFactory(private val operationFactory: OperationFactory) {
    private val rpnConverter: RPNConverter = RPNConverter(operationFactory.getOperatorsInfos(), operationFactory.getFunctionNames())
    /**
     * Метод парсит выражение записанное в инфиксной форме
     * @param expr выражение, записанное в инфиксной форме
     * @return объект Expression
     */
    fun parseExpression(expr: String): Expression {
        val variables: MutableMap<String, MutableList<Variable>> =
            HashMap() //имя переменной -> список объектов переменных
        val tokens = rpnConverter.convert(expr)
        val deque: Deque<Calculable> = ArrayDeque()
        for (o in tokens) {
            when (o) {
                is String -> {
                    if(o in operationFactory)
                        deque.push(operationFactory.create(o, deque::pop))
                    else {
                        //если мы сюда попали, значит у нас переменная
                        val variable = Variable()
                        deque.push(variable)
                        variables.computeIfAbsent(o) { ArrayList() }
                            .add(variable)
                    }
                }  //в данном случае у нас константа типа Double
                is Double -> deque.push(Constant(o))
                else -> throw RuntimeException()
            }
        }
        return Expression(deque.pop(), variables)
    }
}
