package Lesson_7_junit_5;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class FactorialTest {
    private final Factorial factorial = new Factorial();

    @Test
    @DisplayName("Факториал 5 = 120")
    public void factorialTest_3() {
        assertEquals(120, factorial.calculate(5), "Факториал 5 должен быть 120");
    }

    @Test
    @DisplayName("Факториал отрицательного числа")
    public void factorialException() {
        assertThrows(IllegalArgumentException.class,
                () -> factorial.calculate(-1));
    }

    @ParameterizedTest
    @CsvSource({
            "0, 1",
            "1, 1",
            "2, 2",
            "3, 6",
            "4, 24",
            "5, 120"
    })
    public void factorialParameterized(int a, int result) {
        assertEquals(result, factorial.calculate(a));
    }
}
