
import org.blbulyandavbulyan.exprcalc.rpn.ExpressionParserBuilder
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import kotlin.math.pow


private class BasicOperationsTest {
    private val expressionParser = ExpressionParserBuilder().build()
    @Test
    fun test1() {
        val expression = expressionParser("(a+b)*(a-b)")
        val a = Math.random()*10
        val b = Math.random()*20
        expression["a"] = a
        expression["b"] = b
        assertEquals((a+b)*(a-b), expression.calc())
    }

    @Test
    fun test2() {
        val expression = expressionParser("a*b/c")
        val a = Math.random()*200
        val b = Math.random()*10
        val c = Math.random()*50
        expression["a"] = a
        expression["b"] = b
        expression["c"] = c
        assertEquals(a*b/c, expression.calc())
    }

    @Test
    fun testVariableExponentiation() {
        val expression = expressionParser("(a + 2) ^ b")
        expression["a"] = 3.0
        expression["b"] = 2.0
        assertEquals(25.0, expression.calc(), 0.0001)
    }

    @Test
    fun testComplexExpressionWithExponentiationAndVariables() {
        val expression = expressionParser("((a + b) * c) ^ d")
        expression["a"] = 1.0
        expression["b"] = 2.0
        expression["c"] = 3.0
        expression["d"] = 3.0
        assertEquals(729.0, expression.calc(), 0.0001)
    }
    @Test
    fun testComplexExpression1() {
        val expression = expressionParser("(a + b) * (c - d)")
        val a = 5.0
        val b = 3.0
        val c = 10.0
        val d = 2.0
        expression["a"] = a
        expression["b"] = b
        expression["c"] = c
        expression["d"] = d
        assertEquals((a + b) * (c - d), expression.calc(), 0.0001)
    }

    @Test
    fun testComplexExpression2() {
        val expression = expressionParser("(a * b) + ((c / d) - (e ^ f))")
        val a = 2.0
        val b = 3.0
        val c = 15.0
        val d = 5.0
        val e = 2.0
        val f = 3.0
        expression["a"] = a
        expression["b"] = b
        expression["c"] = c
        expression["d"] = d
        expression["e"] = e
        expression["f"] = f
        assertEquals((a * b) + ((c / d) - (e.pow(f))), expression.calc(), 0.0001)
    }

    @Test
    fun testComplexExpression3() {
        val expression = expressionParser("((a + b) * c) / (d ^ e)")
        val a = 1.0
        val b = 2.0
        val c = 6.0
        val d = 3.0
        val e = 2.0
        expression["a"] = a
        expression["b"] = b
        expression["c"] = c
        expression["d"] = d
        expression["e"] = e
        assertEquals(((a + b) * c) / (d.pow(e)), expression.calc(), 0.0001)
    }

    @Test
    fun testNestedParentheses() {
        val expression = expressionParser("((a + (b * c)) - (d ^ e))")
        expression["a"] = 1.0
        expression["b"] = 2.0
        expression["c"] = 3.0
        expression["d"] = 2.0
        expression["e"] = 3.0
        assertEquals(-1.0, expression.calc(), 0.0001)
    }
    @Test
    fun testComplexExpressionWithVariableAssignmentAndUsage() {
        assertEquals(6.0, expressionParser("2 * 3").calc(), 0.0001)
    }

    @Test
    fun testVariableReuseInExpression() {
        assertEquals(6.0, expressionParser("3 * 2").calc(), 0.0001)
    }
    @Test
    fun testAddition() {
        assertEquals(5.0, expressionParser("2 + 3").calc(), 0.0001)
    }

    @Test
    fun testSubtraction() {
        assertEquals(2.0, expressionParser("5 - 3").calc(), 0.0001)
    }

    @Test
    fun testMultiplication() {
        assertEquals(6.0, expressionParser("2 * 3").calc(), 0.0001)
    }

    @Test
    fun testDivision() {
        assertEquals(2.0, expressionParser("6 / 3").calc(), 0.0001)
    }

    @Test
    fun testComplexExpressionWithBrackets() {
        assertEquals(15.0, expressionParser("(2 + 3) * (4 - 1)").calc(), 0.0001)
    }

    @Test
    fun testExponentiation() {
        assertEquals(8.0, expressionParser("2 ^ 3").calc(), 0.0001)
    }

    @Test
    fun testMixedOperationsWithBrackets() {
        assertEquals(2.0 * (3.0 + 4.0) - 5.0 / 1.0, expressionParser("2 * (3 + 4) - 5 / 1").calc(), 0.0001)
    }

    @Test
    fun testNestedBrackets() {
        assertEquals(5.0, expressionParser("((2 + 3) * 4) / (6 - 2)").calc(), 0.0001)
    }

    @Test
    fun testNegativeNumbers() {
        assertEquals(-6.0, expressionParser("-2 * 3").calc(), 0.0001)
    }

    @Test
    fun testDecimalNumbers() {
        assertEquals(10.0, expressionParser("2.5 * 4").calc(), 0.0001)
    }

    @Test
    fun unaryMinusAfterOperator() {
        assertEquals(-4.0, expressionParser("2*-2").calc())
    }
    @Test
    fun unaryMinusInBeginningOfExpression(){
        assertEquals(-2.0*4.0+2.0,  expressionParser("-2*4+2").calc())
    }

    @Test
    fun unaryMinusBeforeBrackets() {
        assertEquals(-(9.0+2.0)*2.0, expressionParser("-(9+2)*2").calc())
    }
}