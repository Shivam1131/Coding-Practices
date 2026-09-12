package org.citykarat_new.snowymountain;

import java.util.Arrays;
import java.util.List;

public class SnowyMountainAnalyzerTest {

    public static void main(String[] args) {
        SnowyMountainAnalyzer analyzer = new SnowyMountainAnalyzer();

        assertEquals(6, analyzer.climbingEffort(new int[]{2, 5, 4, 7}),
                "Only upward movement should count as climbing");

        int[] ground = {2, 5, 4};

        List<SnowDay> days = Arrays.asList(
                new SnowDay(new int[]{2, 0, 0}),
                new SnowDay(new int[]{0, 0, 2}),
                new SnowDay(new int[]{0, 0, 0})
        );

        List<int[]> profiles = analyzer.simulateProfiles(ground, days);

        assertEquals(3, profiles.size(), "One profile per day");
        assertEquals(3, profiles.get(2)[0],
                "Position 0 should have one unit of snow after melting");

        int bestDay = analyzer.bestDayToCross(ground, days);
        assertTrue(bestDay >= 0 && bestDay < days.size(),
                "Best day should be a valid day index");

        System.out.println("Snowy mountain tests completed.");
    }

    private static void assertTrue(boolean value, String message) {
        if (!value) throw new AssertionError(message);
    }

    private static void assertEquals(Object expected, Object actual, String message) {
        if (expected == null ? actual != null : !expected.equals(actual)) {
            throw new AssertionError(message + " | expected=" + expected + ", actual=" + actual);
        }
    }
}
