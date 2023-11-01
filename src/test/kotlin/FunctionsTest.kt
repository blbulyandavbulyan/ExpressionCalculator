import org.blbulyandavbulyan.exprcalc.rpn.ExpressionParserBuilder
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

private class FunctionsTest {
    private val expressionParser = ExpressionParserBuilder().withDefaultFunctions().build()
    @Test
    fun sin() {
        assertEquals(2 * kotlin.math.sin(20.0) + 2, expressionParser("2*sin(20)+2").calc())
    }

    @Test
    fun cos() {
        assertEquals(2 * kotlin.math.cos(20.0) + 2, expressionParser("2*cos(20)+2").calc())
    }

    @Test
    fun sqrt() {
        assertEquals(2* kotlin.math.sqrt(2.0), expressionParser("2*sqrt(2)").calc())
    }

    @Test
    fun pi() {
        assertEquals(2*kotlin.math.PI, expressionParser("2*PI").calc())
    }
    @Test
    fun distance2D(){
        assertEquals(10.0*kotlin.math.sqrt(2.0), expressionParser("dist(15, 20, 25, 30)").calc())
    }
}