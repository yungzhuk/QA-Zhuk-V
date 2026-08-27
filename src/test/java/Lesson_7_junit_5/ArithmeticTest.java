package Lesson_7_junit_5;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ArithmeticTest {
    private final Arithmetic arithmetic = new Arithmetic();

    @Test
    @DisplayName("Сложение: 2 + 3 = 5")
    public void testAdd() {
        int result = arithmetic.add(2, 3);
        assertEquals(5, result, "2 + 3 должно быть 5");
    }

    @ParameterizedTest
    @CsvSource({
            "2, 3, 5",
            "-2, -3, -5",
            "5, -3, 2",
            "0, 5, 5"
    })
    public void testAddParameterized(int a, int b, int result) {
        assertEquals(result, arithmetic.add(a, b));
    }

    @Test
    @DisplayName("Вычитание 3 - 2 = 1")
    public void testSubtract () {
        int result2 = arithmetic.subtract(3, 2);
        assertEquals(1, result2, "3 - 2 должно быть 1");
    }

    @ParameterizedTest
    @CsvSource({
            "5, 3, 2",
            "10, 7, 3",
            "-5, -3, -2",
            "5, -3, 8"
    })
    public void testSubtractParameterized(int a, int b, int result2) {
        assertEquals(result2, arithmetic.subtract(a, b));
    }

    @Test
    @DisplayName("Умножение 2 * 3 = 6")
    public void testMultiply() {
        int result3 = arithmetic.multiply(2, 3);
        assertEquals(6, result3, "2 * 3 должно быть 6");
    }

    @ParameterizedTest
    @CsvSource({
            "2, 3, 6",
            "-2, 3, -6",
            "2, -3, -6",
            "-2, -3, 6",
            "0, 5, 0"
    })
    public void testMultiplyParameterized(int a, int b, int result3) {
        assertEquals(result3, arithmetic.multiply(a, b));
    }

    @Test
    @DisplayName("Деление: 6 / 2 = 3.0")
    public void testDivide() {
        double result4 = arithmetic.divide(6, 2);
        assertEquals(3, result4);
    }

    @Test
    @DisplayName("Деление: 5 / 2 = 2.5")
    public void testDivide_FiveByTwo() {
        double result5 = arithmetic.divide(5, 2);
        assertEquals(2.5, result5);
    }

    @Test
    @DisplayName("Деление на 0")
    public void testDivide_Zero() {
        assertThrows(ArithmeticException.class,
                () -> arithmetic.divide(5, 0));
    }

    @ParameterizedTest
    @CsvSource({
            "6, 2, 3.0",
            "5, 2, 2.5",
            "10, 4, 2.5",
            "-6, 2, -3.0",
            "6, -2, -3.0",
            "-6, -2, 3.0",
            "0, 5, 0.0"
    })
    public void testDivideParameterized(int a, int b, double result) {
        assertEquals(result, arithmetic.divide(a, b));
    }

}
