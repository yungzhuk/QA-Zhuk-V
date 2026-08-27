package Lesson_7_junit_5;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class NumberComparatorTest {
    private final NumberComparator numberComparator = new NumberComparator();

    @Test
    @DisplayName("5 > 3 → 1")
    public void numberComparatorTest_5_3() {
        assertEquals(1, numberComparator.compare(5, 3));
    }

    @Test
    @DisplayName("3 < 5 → -1")
    void testCompare_3_5() {
        assertEquals(-1, numberComparator.compare(3, 5));
    }

    @Test
    @DisplayName("5 = 5 → 0")
    void testCompare_5_5() {
        assertEquals(0, numberComparator.compare(5, 5));
    }

    @ParameterizedTest
    @CsvSource({
            "5, 3, 1",
            "3, 5, -1",
            "5, 5, 0"
    })
    @DisplayName("Параметризованный тест сравнения")
    void testCompareParameterized(int a, int b, int result) {
        assertEquals(result, numberComparator.compare(a, b));
    }

}
