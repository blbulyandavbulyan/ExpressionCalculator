package org.blbulyandavbulyan.exprcalc.rpn

import org.blbulyandavbulyan.exprcalc.annotations.Associativity
import org.blbulyandavbulyan.exprcalc.annotations.Priority

/**
 * @param priority приоритет операции
 * @param associativity ассоциативность оператора
 */
class OperatorInfo(val priority: Priority, private val associativity: Associativity){
    val isLeftAssociative = associativity == Associativity.LEFT
}