package org.blbulyandavbulyan.exprcalc.annotations

@Target(AnnotationTarget.CLASS)
@Retention(AnnotationRetention.RUNTIME)
annotation class OperatorInfo(val associativity: Associativity, val priority: Int){
}
