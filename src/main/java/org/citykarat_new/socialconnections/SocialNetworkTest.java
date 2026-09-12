package org.citykarat_new.socialconnections;

import static org.citykarat_new.socialconnections.ConnectionEvent.Type.CONNECT;
import static org.citykarat_new.socialconnections.ConnectionEvent.Type.DISCONNECT;

public class SocialNetworkTest {

    public static void main(String[] args) {
        SocialNetwork network = new SocialNetwork();

        network.apply(new ConnectionEvent(CONNECT, "Alice", "Bob"));
        network.apply(new ConnectionEvent(CONNECT, "Alice", "Charlie"));
        network.apply(new ConnectionEvent(CONNECT, "Bob", "Dennis"));
        network.apply(new ConnectionEvent(DISCONNECT, "Alice", "Bob"));

        assertEquals(1, network.connectionCount("Alice"),
                "Alice should have only Charlie after disconnect");

        assertEquals(1, network.connectionCount("Bob"),
                "Bob should have only Dennis after disconnect");

        ConnectionGroups groups = network.groupByConnectionCount(2);

        assertTrue(groups.getBelowThreshold().contains("Alice"),
                "Alice should be below threshold");

        assertTrue(groups.getAtOrAboveThreshold().contains("Dennis") == false,
                "Dennis should not be in >=2 group");

        System.out.println("Social connection tests completed.");
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
