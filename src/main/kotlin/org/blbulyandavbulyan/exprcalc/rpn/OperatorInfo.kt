package org.blbulyandavbulyan.exprcalc.rpn

import org.blbulyandavbulyan.exprcalc.annotations.Associativity

/**
 * @param priority приоритет операции
 * @param associativity ассоциативность оператора
 */
class OperatorInfo(val priority: Int, private val associativity: Associativity){
    val isLeftAssociative = associativity == Associativity.LEFT
}