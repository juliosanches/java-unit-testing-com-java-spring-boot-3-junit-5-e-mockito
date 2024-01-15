package br.com.erudio;

import br.com.erudio.math.SimpleMath;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class DemoRepeatedTest {

    SimpleMath math;

    @BeforeEach
    void beforeEachMethod() {
        math = new SimpleMath();
    }

    @RepeatedTest(value = 3, name = "{displayName}. Repetition {currentRepetition} of {totalRepetitions}")
    @DisplayName("Test Division by Zero")
    void testSum_WhenFirstNumberIsDividedByZero_ShouldThrowArithmeticException(
            RepetitionInfo repetitionInfo,
            TestInfo testInfo
    ) {
        System.out.println("Repetition Nº " + repetitionInfo.getCurrentRepetition() + " of " + repetitionInfo.getTotalRepetitions());
        System.out.println("Running " + testInfo.getTestMethod().get().getName());
        double firstNumber = 8.4D;
        double secondNumber = 0D;
        var expectedMessage = "Impossible to divide by zero!";
        ArithmeticException actual = assertThrows(ArithmeticException.class,
                () -> math.division(firstNumber, secondNumber),
                () -> "Division by zero should throw ArithmeticException");
        assertEquals(expectedMessage, actual.getMessage(),
                () -> "Unexpected exception message!");
    }
}
