package org.blbulyandavbulyan.exprcalc.annotations

@Target(AnnotationTarget.CLASS)
@Retention(AnnotationRetention.RUNTIME)
annotation class OperationInfo(val associativity: Associativity, val priority: Priority){
}
