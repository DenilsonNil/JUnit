package br.com.kualit.math;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Test Math operations in SimpleMath class")
class SimpleMathTest {

    private SimpleMath simpleMath;

    @BeforeEach
    void setUp() {
        simpleMath = new SimpleMath();
    }

    @AfterEach
    void tearDown() {
        simpleMath = null;
    }

    @BeforeAll
    static void beforeAllMethods() {}

    @AfterAll
    static void afterAllMethods() {}

    @Test
    @DisplayName("6D + 2D = 8D")
    void sum() {
        //Given
        Double firstNumber = 6D;
        Double secondNumber = 2D;
        Double expected = 8D;

        //When
        Double actual = simpleMath.sum(firstNumber, secondNumber);

        //Then
        assertNotNull(actual);
        assertEquals(expected, actual,
                () -> "Test for sum failed!" + firstNumber + " + " + secondNumber +  "should produces " + expected);
    }

    @Test
    @DisplayName("6D - 2D = 4D")
    void subtraction() {
        //Given
        Double firstNumber = 6D;
        Double secondNumber = 2D;
        Double expected = 4D;

        //When
        Double actual = simpleMath.subtraction(firstNumber, secondNumber);

        //Then
        assertNotNull(actual);
        assertEquals(expected, actual,
                () -> "Test for subtraction failed!" + firstNumber + " - " + secondNumber +  "should produces " + expected);
    }

    @Test
    @DisplayName("6D * 2D = 12D")
    void multiplication() {
        //Given
        Double firstNumber = 6D;
        Double secondNumber = 2D;
        Double expected = 12D;

        //When
        Double actual = simpleMath.multiplication(firstNumber, secondNumber);

        //Then
        assertNotNull(actual);
        assertEquals(expected, actual,
                () -> "Test for multiplication failed!" + firstNumber + " * " + secondNumber +  "should produces " + expected);
    }

    @Test
    @DisplayName("6D / 2D = 3D")
    void division() {
        //Given
        Double firstNumber = 6D;
        Double secondNumber = 2D;
        Double expected = 3D;

        //When
        Double actual = simpleMath.division(firstNumber, secondNumber);

        //Then
        assertNotNull(actual);
        assertEquals(expected, actual,
                () -> "Test for division failed!" + firstNumber + " / " + secondNumber +  "should produces " + expected);
    }

    @Test
    @DisplayName("(6D + 2D) / 2 = 4D")
    void average() {
        //Given
        Double firstNumber = 6D;
        Double secondNumber = 2D;
        Double expected = 4D;

        //When
        Double actual = simpleMath.average(firstNumber, secondNumber);

        //Then
        assertNotNull(actual);
        assertEquals(expected, actual,
                () -> "Test for average failed! (" + firstNumber + " / " + secondNumber +  ") / 2 should produces " + expected);
    }

    @Test
    @DisplayName("Square root of 49D is 7D")
    void squareRoot() {
        //Given
        Double expected = 7D;
        Double number = 49D;

        //When
        Double actual = simpleMath.squareRoot(number);

        //Then
        assertNotNull(actual);
        assertEquals(expected, actual,
                () -> "Test for squareRoot failed! The operation square root " +
                        "with the parameter " + number +  "should produces " + expected);
    }

    @Test
    @DisplayName("Division By Zero")
    void divisionByZero() {
        String expectedMessage = "Impossible to divide by zero";
        //When
        ArithmeticException exception = assertThrows(ArithmeticException.class,
                () -> simpleMath.division(6D, 0D),
                "Division by zero should throw an arithmetic exception!");

        assertEquals(expectedMessage, exception.getMessage());
    }
}