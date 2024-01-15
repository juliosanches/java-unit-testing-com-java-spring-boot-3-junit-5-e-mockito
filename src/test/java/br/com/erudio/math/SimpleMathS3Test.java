package br.com.erudio.math;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Test Math Operations in SimpleMath Class")
class SimpleMathS3Test {

    SimpleMath math;

    @BeforeAll
    static void setup(){
        System.out.println("Running @BeforeAll method!");
    }

    @AfterAll
    static void cleanup(){
        System.out.println("Running @AfterAll method!");
    }

    @BeforeEach
    void beforeEachMethod(){
        System.out.println("Running @BeforeEach method!");
         math = new SimpleMath();
    }

    @AfterEach
    void afterEachMethod(){
        System.out.println("Running @AfterEach method!");
    }

    // test[System Under Test]_[Condition or State Change]_[Expected Result]
    @Test
    @DisplayName("Test 6.2 + 2 = 8.2")
    void testSum_WhenFirstNumberIsAddedByTwo_ShouldReturnEightDotTwo() {
        System.out.println("Test 6.2 + 2 = 8.2");
        // AAA = Arrange, Act and Assert

        // Given / Arrange
        double firstNumber = 6.2D;
        double secondNumber = 2D;
        Double expected = 8.2D;

        // When / Act
        Double actual = math.sum(firstNumber, secondNumber);

        // Then / Assert
        assertNotNull(actual);
        assertNotEquals(9.2, actual);
        assertEquals(expected, actual,
                () -> "%s + %s did not produce %s!"
                        .formatted(firstNumber, secondNumber, expected));
    }

    @Test
    @DisplayName("Test 6.2 - 2 = 4.2")
    void testSubtraction() {
        System.out.println("Test 6.2 - 2 = 4.2");
        double firstNumber = 6.2D;
        double secondNumber = 2D;
        Double actual = math.subtraction(firstNumber, secondNumber);
        Double expected = 4.2D;

        assertNotNull(actual);
        assertNotEquals(10, actual);
        assertEquals(expected, actual, () -> "%s - %s did not produce %s!".formatted(firstNumber, secondNumber, expected));
    }

    @Test
    @DisplayName("Test 6.2 * 2 = 12.4")
    void testMultiplication() {
        System.out.println("Test 6.2 * 2 = 12.4");
        double firstNumber = 6.2D;
        double secondNumber = 2D;
        Double actual = math.multiplication(firstNumber, secondNumber);
        Double expected = 12.4D;

        assertNotNull(actual);
        assertNotEquals(3, actual);
        assertEquals(expected, actual, () -> "%s * %s did not produce %s!".formatted(firstNumber, secondNumber, expected));
    }

    @Test
    @DisplayName("Test 8.4 + 2 = 4.2")
    void testDivision() {
        System.out.println("Test 8.4 + 2 = 4.2");
        double firstNumber = 8.4D;
        double secondNumber = 2D;
        Double actual = math.division(firstNumber, secondNumber);
        Double expected = 4.2D;

        assertNotNull(actual);
        assertNotEquals(2.1, actual);
        assertEquals(expected, actual, () -> "%s ÷ %s did not produce %s!".formatted(firstNumber, secondNumber, expected));
    }

    // test[System Under Test]_[Condition or State Change]_[Expected Result]
    @Test
    @DisplayName("Test Division by Zero")
    void testSum_WhenFirstNumberIsDividedByZero_ShouldThrowArithmeticException() {
        System.out.println("Test Division by Zero");
        double firstNumber = 8.4D;
        double secondNumber = 0D;
        var expectedMessage = "Impossible to divide by zero!";
        ArithmeticException actual = assertThrows(ArithmeticException.class,
                () -> math.division(firstNumber, secondNumber),
                () -> "Division by zero should throw ArithmeticException");
        assertEquals(expectedMessage, actual.getMessage(),
                () -> "Unexpected exception message!");
    }

    @Test
    @DisplayName("Test (5.6 + 4)/2 = 4.8")
    void testMean() {
        System.out.println("Test (5.6 + 4)/2 = 4.8");
        double firstNumber = 5.6D;
        double secondNumber = 4D;
        Double actual = math.mean(firstNumber, secondNumber);
        Double expected = 4.8D;

        assertNotNull(actual);
        assertNotEquals(5.2, actual);
        assertEquals(expected, actual, () -> "mean of %s and %s did not produce %s!".formatted(firstNumber, secondNumber, expected));
    }

    @Test
    @DisplayName("Test Square Root of 144 = 12")
    void testSquareRoot() {
        System.out.println("Test Square Root of 144 = 12");
        double number = 144D;
        Double actual = math.squareRoot(number);
        Double expected = 12D;

        assertNotNull(actual);
        assertNotEquals(11, actual);
        assertEquals(expected, actual, () -> "squareRoot if %s did not produce %s!".formatted(number, expected));
    }

}