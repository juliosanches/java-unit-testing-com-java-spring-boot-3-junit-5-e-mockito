package br.com.erudio.math;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Test Math Operations in SimpleMath Class")
class SimpleMathS4Test {

    SimpleMath math;

    @BeforeEach
    void beforeEachMethod() {
        math = new SimpleMath();
    }

    @DisplayName("Test double division")
    @ParameterizedTest
    //@MethodSource("testDivisionInputParameter")
    //@MethodSource()
/*    @CsvSource({
        "6.2, 2, 3.1",
        "71, 14, 5.07",
        "18.3, 3.1, 5.9"
    })*/
    @CsvFileSource(resources = "/testDivision.csv")
    void testDivision(double firstNumber, double secondNumber, double expected) {
        System.out.printf("Test %s / %s  = %s !%n", firstNumber, secondNumber, expected);

        Double actual = math.division(firstNumber, secondNumber);

        assertEquals(expected, actual, 2D, () -> "%s ÷ %s did not produce %s!".formatted(firstNumber, secondNumber, expected));
    }

//    public static Stream<Arguments> testDivisionInputParameter(){
/*    public static Stream<Arguments> testDivision(){
        return Stream.of(
                Arguments.of(6.2D, 2D, 3.1D),
                Arguments.of(71D, 14D, 5.07D),
                Arguments.of(18.3, 3.1D, 5.9D)
        );
    }*/

}