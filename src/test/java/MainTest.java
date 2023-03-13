import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class MainTest {

    Main main;

    @BeforeEach
    public void before() {
        main = new Main();
    }

    @Test
    @Disabled
    public void shouldSumPositiveNumbers() {
        int res = main.sumNumbers(4);

        Assertions.assertEquals(15, res);
    }

    @Test
    @DisplayName("Happy path: sum negative numbers")
    @Tag("smoke")
    public void shouldSumNegativeNumbers() {
        int res = main.sumNumbers(-4);

        Assertions.assertEquals(7, res);
    }

    @Test
    public void shouldReturnStringWithNumber() {
        String res = main.returnStringWithNumber(6);

        Assertions.assertEquals("number 6", res);
    }

    @ParameterizedTest
    @MethodSource("numbers")
    public void shouldReturnStringWithNumberWithTwoNumbers(int number1, int number2, String answer) {
        String res = main.returnStringWithNumber(number1, number2);

        Assertions.assertEquals(answer, res);
    }

    private static Stream<Arguments> numbers() {
        return Stream.of(
                Arguments.of(1, 2, "number 12"),
                Arguments.of(-1, -2, "number -12"),
                Arguments.of(22, 44, "number 2244"),
                Arguments.of(234234234, 234234234, "number 234234234234234234")
        );
    }
}
