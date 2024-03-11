package br.com.kualit.math;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@DisplayName("Repeatable tests")
public class RepeatableTests {

    SimpleMath simpleMath;

    @BeforeEach
    void setUp() {
        simpleMath = new SimpleMath();
    }

    @AfterEach
    void cleanup() {
        simpleMath = null;
    }

    @RepeatedTest(3)
    @DisplayName("Division By Zero")
    void divisionByZero(RepetitionInfo repetitionInfo, TestInfo testInfo) {

        //Given
        Double firstNumber = 6D;
        Double secondNumber = 0D;
        String expectedMessage = "Impossible to divide by zero";

        System.out.println("Repetition numer: " + repetitionInfo.getCurrentRepetition() +
                " of " + repetitionInfo.getTotalRepetitions());

        System.out.println("Running now: " + testInfo.getTestMethod().get().getName());
        //When
        ArithmeticException exception = assertThrows(ArithmeticException.class,
                () -> simpleMath.division(firstNumber, secondNumber),
                "Division by zero should throw an arithmetic exception!");

        assertEquals(expectedMessage, exception.getMessage());
    }


    @RepeatedTest(value = 3, name = "{displayName}. Repetition {currentRepetition} of {totalRepetitions}")
    @DisplayName("Division By Zero")
    void divisionByZero__approach_configured_display_name() {
        //Given
        Double firstNumber = 6D;
        Double secondNumber = 0D;
        String expectedMessage = "Impossible to divide by zero";

        //When
        ArithmeticException exception = assertThrows(ArithmeticException.class,
                () -> simpleMath.division(firstNumber, secondNumber),
                "Division by zero should throw an arithmetic exception!");

        assertEquals(expectedMessage, exception.getMessage());
    }

}
