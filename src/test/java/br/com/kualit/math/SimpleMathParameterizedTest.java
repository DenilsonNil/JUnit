package br.com.kualit.math;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Test Math operations in SimpleMath class")
class SimpleMathParameterizedTest {

    private SimpleMath simpleMath;

    @BeforeEach
    void setUp() {
        simpleMath = new SimpleMath();
    }

    @ParameterizedTest
    @DisplayName("Test division [firstNumber, secondNumber, expected]")
    @MethodSource("divisionInputParameters")
    void division(double firstNumber, double secondNumber, double expected) {
        //When
        Double actual = simpleMath.division(firstNumber, secondNumber);
        double delta = 2D; //Consider only two decimal

        //Then
        assertNotNull(actual);
        assertEquals(expected, actual, delta, () -> "Test for division failed!"
                + firstNumber + " / " + secondNumber + "should produces" + expected);
    }

    public static Stream<Arguments> divisionInputParameters() {
        return Stream.of(
                Arguments.of(6.2D, 2D, 3.0),
                Arguments.of(71D, 14D, 5.07),
                Arguments.of(18.3D, 3.1D, 5.90)
        );
    }

    //Testing with CSV - Approach 1
    @ParameterizedTest
    @DisplayName("Test division CSV 1")
    @CsvSource({
            "6.2, 2, 3.0",
            "71, 14, 5.07",
            "18.3, 3.1, 5.9"
    })
    void test_division_csv_1(double firstNumber, double secondNumber, double expected) {
        //When
        Double actual = simpleMath.division(firstNumber, secondNumber);
        double delta = 2D;
        //Then
        assertNotNull(actual);
        assertEquals(expected, actual, delta, () -> "Test for division failed!"
                + firstNumber + " / " + secondNumber + "should produces" + expected);
    }

    //Testing with CSV - Approach 2 - With csv file
    @ParameterizedTest
    @DisplayName("Test division CSV 1")
    @CsvFileSource(resources = "/division_input.csv")
    void test_division_csv_2(double firstNumber, double secondNumber, double expected) {
        //When
        Double actual = simpleMath.division(firstNumber, secondNumber);
        double delta = 2D;
        //Then
        assertNotNull(actual);
        assertEquals(expected, actual, delta, () -> "Test for division failed!"
                + firstNumber + " / " + secondNumber + "should produces" + expected);
    }

    @ParameterizedTest
    @ValueSource(strings = {"Marcos, Valdivia, Pelé"})
    void test_names_ValueSource(String name) {
        assertNotNull(name);
    }

}