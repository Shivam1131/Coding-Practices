package org.citykarat_new.resourceaccesslog;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class ResourceAccessAnalyzerTest {

    public static void main(String[] args) {
        List<AccessRecord> records = Arrays.asList(
                new AccessRecord("U1", "/orders", 100),
                new AccessRecord("U1", "/orders", 110),
                new AccessRecord("U2", "/users", 120),
                new AccessRecord("U1", "/orders", 130),
                new AccessRecord("U2", "/orders", 140)
        );

        ResourceAccessAnalyzer analyzer = new ResourceAccessAnalyzer();

        Map<String, Integer> counts = analyzer.countByResource(records);
        assertEquals(4, counts.get("/orders"), "/orders count");

        assertEquals("/orders", analyzer.mostAccessedResource(records),
                "Most accessed resource");

        Map<String, List<String>> byUser = analyzer.resourcesByUser(records);
        assertEquals(Arrays.asList("/orders"), byUser.get("U1"), "U1 resources");

        List<String> frequent = analyzer.frequentUsersForSameResource(records, 3);
        assertTrue(frequent.contains("U1"), "U1 should qualify");

        System.out.println("Resource access tests completed.");
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
