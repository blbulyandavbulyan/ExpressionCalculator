package org.blbulyandavbulyan.exprcalc.annotations

@Target(AnnotationTarget.CLASS)
@Retention(AnnotationRetention.RUNTIME)
annotation class Operator(val name: String, val associativity: Associativity, val priority: Int){
    enum class Associativity { LEFT, RIGHT }
}
