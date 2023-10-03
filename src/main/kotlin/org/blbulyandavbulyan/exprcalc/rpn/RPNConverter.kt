package org.blbulyandavbulyan.exprcalc.rpn

import org.blbulyandavbulyan.exprcalc.annotations.Priority
import java.util.*
import java.util.regex.MatchResult
import java.util.regex.Pattern

class RPNConverter(private val operatorInfos: Map<String, OperatorInfo>, private val functionsNames: Collection<String>) {
    private var splitToOperatorPattern: Pattern
    private var unaryMinusPattern: Pattern
    init {
        val names = operatorInfos.keys + functionsNames
        splitToOperatorPattern = Pattern.compile("(\\(|\\)|,|${names.joinToString("|") { Regex.escape(it) }})")
        unaryMinusPattern = Pattern.compile("(^|,|\\(|${names.filter {it != "#"}.joinToString ("|"){ Regex.escape(it) }})(-)")
    }
    /**
     * Функция преобразовывает переданное выражение в последовательность токенов в обратной польской записи
     * @param expr исходное выражение
     * @return массив токенов, если оператор или переменная, то объект - строка, если значение то целое число
     */
    fun convert(expr: String): Array<Any> {
        val tokens = splitOnOperations(expr)
        val result = Stack<Any>()
        val operatorStack = Stack<String>()
        for (token in tokens) {
            if (token == "(") operatorStack.push(token)
            else {
                val operatorInfo = operatorInfos[token]
                if (operatorInfo != null) {
                    var otherPriority: Priority
                    while (!operatorStack.isEmpty() && operatorStack.peek() != "(" && (operatorInfos[operatorStack.peek()]!!.priority.also {
                            otherPriority = it
                        } > operatorInfo.priority || otherPriority == operatorInfo.priority && operatorInfo.isLeftAssociative)) {
                        result.push(operatorStack.pop())
                    }
                    operatorStack.push(token)
                } else if (token == ")") {
                    //если встретилась закрывающая скобка, опустошаем стек
                    while (!operatorStack.isEmpty() && operatorStack.peek() != "(")
                        result.push(operatorStack.pop()) //вытаскиваем все операторы из операторного стека и запихиваем в результат
                    if (!operatorStack.isEmpty() && operatorStack.peek() == "(")
                        operatorStack.pop() //убираем открывающую скобку из стэка
                    else throw RuntimeException() //пропущена открывающая скобка
                }
                else if(token == ","){
                    while (operatorStack.isNotEmpty() && operatorStack.peek() != "("){
                        result.push(operatorStack.pop())
                    }
                }
                else if (token in functionsNames)
                    operatorStack.push(token)
                else {
                    var toResult: Any = token
                    try {
                        toResult = token.toDouble()
                    } catch (ignored: NumberFormatException) { // никак не обрабатываем, т.к. в данном случае видимо у нас не число, а значит имя переменной
                    }
                    result.push(toResult)
                }
            }
        }
        while (!operatorStack.isEmpty()) {
            val operator = operatorStack.pop()
            if(operator == "(")
                throw RuntimeException()//пропущена закрывающая скобка в выражении
            result.push(operator)
        }
        return result.toTypedArray()
    }

    /**
     * Метод разбивает выражение по операторам, сохраняя их
     * @param expr выражение, которое нужно разбить
     * @return массив, содержащий переменные/значения и операторы в отдельных ячейках, в порядке записи в строке
     */
    private fun splitOnOperations(expr: String): Array<String> {
        val exprWithoutUnaryMinus = unaryMinusPattern.matcher(expr)
            .replaceAll { matchResult: MatchResult -> matchResult.group(1) + "#" }
        val matcher = splitToOperatorPattern.matcher(exprWithoutUnaryMinus)
        val resultExpression = matcher.replaceAll { matchResult: MatchResult -> " " + matchResult.group() + " " }
            .trim { it <= ' ' }
        return resultExpression.split(" ".toRegex()).map { it.trim() }.filter { it.isNotEmpty() }.toTypedArray()
    }
}
