package br.com.kualit.arrays;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

@DisplayName("Tests with arrays")
class ArraysComparationTest {

    @Test
    @DisplayName("Comparing two numeric arrays")
    void compareArrays(){
        int[] numbers = {25, 8, 21, 32, 3};
        int[] expectedArray = {3, 8, 21, 25, 32};

        Arrays.sort(numbers);

        assertArrayEquals(numbers, expectedArray);
    }
}
