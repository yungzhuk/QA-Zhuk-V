package Lesson_7_junit_5;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


public class AreaTest {
    private final Area area = new Area();

    @Test
    @DisplayName("Площадь: 4 * 3 / 2 = 6")
    public void areaTest_4_3() {
        double result = area.calculate(4, 3);
        assertEquals(6.0, result, "Площадь: 4 * 3 / 2 должно быть 6");
    }

    @Test
    @DisplayName("Площадь: 5 * 4 / 2 = 10")
    public void areaTest_5_4() {
        double result1 = area.calculate(5, 4);
        assertEquals(10, result1, "Площадь: 5 * 4 / 2 должно быть 10");
    }

    @Test
    @DisplayName("Отрицательное основание")
    public void areaTestException() {
        assertThrows(IllegalArgumentException.class,
                () -> area.calculate(-4, 3));
    }

    @Test
    @DisplayName("Нулевая высота")
    public void areaTestException2() {
        assertThrows(IllegalArgumentException.class,
                () -> area.calculate(5, 0));
    }

    @ParameterizedTest
    @CsvSource({
            "4, 3, 6.0",
            "5, 4, 10.0",
            "10, 5, 25.0",
            "2.5, 4.8, 6.0"
    })
    public void areaTestParameterized(double a, double b, double result2) {
        assertEquals(result2, area.calculate(a, b));
    }

}
