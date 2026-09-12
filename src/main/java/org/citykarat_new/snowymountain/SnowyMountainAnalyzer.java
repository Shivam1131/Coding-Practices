package org.citykarat_new.snowymountain;

import java.util.Arrays;
import java.util.List;

public class SnowyMountainAnalyzer {

    /*
     * This practice reconstruction models:
     * - fixed ground heights
     * - daily snowfall per position
     * - old snow beginning to melt after two consecutive days
     *   without new snow at a position
     *
     * TASK 1:
     * This helper should calculate the climbing effort of a profile.
     * Climbing effort is the sum of positive upward differences from
     * left to right.
     *
     * Example:
     * [2, 5, 4, 7] => 3 + 0 + 3 = 6
     *
     * The existing implementation contains a bug.
     */
    public int climbingEffort(int[] profile) {
        int effort = 0;

        for (int i = 1; i < profile.length; i++) {
            // Existing implementation. Do not assume it is correct.
            effort += Math.abs(profile[i] - profile[i - 1]);
        }

        return effort;
    }

    /*
     * TASK 2:
     * Simulate the snow depth after each day.
     *
     * Rules:
     * - snowfall for the day is added first
     * - if a position receives no snow for two consecutive days,
     *   one unit of existing snow melts at the end of that day
     * - snow depth never becomes negative
     *
     * Return one int[] profile per day containing:
     *      groundHeight + currentSnowDepth
     */
    public List<int[]> simulateProfiles(int[] groundHeights, List<SnowDay> days) {
        throw new UnsupportedOperationException("TODO: implement simulateProfiles");
    }

    /*
     * TASK 3:
     * Return the zero-based day index with the smallest climbing effort.
     * Earliest day wins ties.
     *
     * Return -1 if there are no days.
     */
    public int bestDayToCross(int[] groundHeights, List<SnowDay> days) {
        throw new UnsupportedOperationException("TODO: implement bestDayToCross");
    }

    public static String profileToString(int[] profile) {
        return Arrays.toString(profile);
    }
}
