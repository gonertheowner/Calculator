package Calculator.Tests;

import Calculator.Classes.Calc;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

class CalcTest {
    @Mock
    Calc calculator = new Calc();

    @Test
    void getInstance() {
        Calc calculator = Calc.getInstance();
        Assertions.assertEquals(Calc.getInstance(), calculator);
    }

    @Test
    void sum() {
        double a = 3.2;
        double b = 4.6;

        double expected = a + b;
        double actual = calculator.sum(a, b);

        Assertions.assertEquals(expected, actual, 0.001);
    }

    @Test
    void subtract() {
        double a = 3.5;
        double b = 4;

        double expected = a - b;
        double actual = calculator.subtract(a, b);

        Assertions.assertEquals(expected, actual, 0.001);
    }

    @Test
    void multiply() {
        double a = 3.7;
        double b = 4.84;

        double expected = a * b;
        double actual = calculator.multiply(a, b);

        Assertions.assertEquals(expected, actual, 0.001);
    }

    @Test
    void correctDivide() {
        double a = 1.29;
        double b = 0.64;

        double expected = a / b;
        double actual = calculator.divide(a, b);

        Assertions.assertEquals(expected, actual, 0.001);
    }

    @Test
    void divideByZero() {
        Exception exception = Assertions.assertThrows(ArithmeticException.class, () -> {
            double a = 1.29;
            double b = 0;
            calculator.divide(a, b);
        });
        Assertions.assertEquals(ArithmeticException.class, exception.getClass());
    }

    @Test
    void doOperatorWithIllegalArgument() {
        // Argument could be not parsable to Double or null
        Exception exception = Assertions.assertThrows(NullPointerException.class, () -> {
            String a = "23.11";
            String operator = "+";
            calculator.doOperator(operator, a, "str");
        });
        Assertions.assertEquals(NullPointerException.class, exception.getClass());
    }

    @Test
    void doOperatorWithIllegalOperator() {
        Exception exception = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            calculator.doOperator("str", "12.3", "10.0");
        });
        Assertions.assertEquals(IllegalArgumentException.class, exception.getClass());
    }
}