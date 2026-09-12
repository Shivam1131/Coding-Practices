package org.citykarat_new.passagetracker;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;

import static org.citykarat_new.passagetracker.PassageEvent.Type.ENTER;
import static org.citykarat_new.passagetracker.PassageEvent.Type.EXIT;

public class PassageTrackerTest {

    public static void main(String[] args) {
        List<PassageEvent> events = Arrays.asList(
                new PassageEvent("P1", 100, ENTER),
                new PassageEvent("P2", 105, ENTER),
                new PassageEvent("P1", 120, EXIT),
                new PassageEvent("P1", 140, ENTER),
                new PassageEvent("P1", 170, EXIT)
        );

        PassageTracker tracker = new PassageTracker();

        Set<String> inside = tracker.peopleCurrentlyInside(events);
        assertTrue(inside.contains("P2"), "P2 should still be inside");
        assertFalse(inside.contains("P1"), "P1 should not be inside");

        Map<String, Integer> counts = tracker.countCompletePassages(events);
        assertEquals(2, counts.get("P1"), "P1 should have two complete passages");

        assertEquals(25.0, tracker.averagePassageDuration(events, "P1"),
                "P1 average duration should be 25");

        System.out.println("Passage tracker tests completed.");
    }

    private static void assertTrue(boolean value, String message) {
        if (!value) throw new AssertionError(message);
    }

    private static void assertFalse(boolean value, String message) {
        if (value) throw new AssertionError(message);
    }

    private static void assertEquals(Object expected, Object actual, String message) {
        if (expected == null ? actual != null : !expected.equals(actual)) {
            throw new AssertionError(message + " | expected=" + expected + ", actual=" + actual);
        }
    }
}
