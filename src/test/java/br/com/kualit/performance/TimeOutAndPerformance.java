package br.com.kualit.performance;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;

@DisplayName("Testing timeout and performance")
public class TimeOutAndPerformance {

    @Test
    @DisplayName("The method time execution may be between 0 and 1 second")
    @Timeout(1)
    void testSortPerformanceInSeconds() {
        int[] numbers = {25, 8, 21, 32, 3};
        for (int i = 0; i < 1000000000; i++) {
            numbers[0] = 99;
            Arrays.sort(numbers);
        }
    }

    @Test
    @DisplayName("The method time execution may be between 0 and 15 miliseconds")
    @Timeout(value = 15, unit = TimeUnit.MILLISECONDS)
    void testSortPerformanceInMiliseconds() {
        int[] numbers = {25, 8, 21, 32, 3};
        for (int i = 0; i < 1000000000; i++) {
            numbers[0] = 99;
            Arrays.sort(numbers);
        }
    }
}
