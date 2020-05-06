import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    @Test
    void testEvaluate1() {
        Calculator calculator = new Calculator();
        assertEquals(14.666666666666666, calculator.evaluate("3+5*7/3"),"It should " +
                "evaluate the infix expression 3+5*7/3");
    }

    @Test
    void testEvaluate2() {
        Calculator calculator = new Calculator();
        assertEquals(30.0, calculator.evaluate("5*6*1"),"It should " +
                "evaluate the infix expression 5*6*1");
    }

    @Test
    void testEvaluate3() {
        Calculator calculator = new Calculator();
        assertEquals(14.666666666666666, calculator.evaluate("3+(5*7)/3"),"It should " +
                "evaluate the infix expression 3+(5*7)/3");
    }

    @Test
    void testEvaluate4() {
        Calculator calculator = new Calculator();
        assertEquals(26.333333333333336, calculator.evaluate("3+7/3+21"),"It should " +
                "evaluate the infix expression 3+7/3+21");
    }
}