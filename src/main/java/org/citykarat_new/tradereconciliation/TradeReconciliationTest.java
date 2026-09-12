package org.citykarat_new.tradereconciliation;

import java.util.Arrays;
import java.util.List;

public class TradeReconciliationTest {

    public static void main(String[] args) {
        testTradeEquality();
        testFindUnmatchedIncomingTrades();
        testFullyReconciled();
        System.out.println("Trade reconciliation tests completed.");
    }

    private static void testTradeEquality() {
        Trade buy = new Trade("CITI", "BUY", 100, 72.50);
        Trade sell = new Trade("CITI", "SELL", 100, 72.50);

        assertFalse(buy.equals(sell),
                "Trades with same symbol but different side must not be equal");
    }

    private static void testFindUnmatchedIncomingTrades() {
        TradeReconciliationService service = new TradeReconciliationService();

        List<Trade> incoming = Arrays.asList(
                new Trade("CITI", "BUY", 100, 72.50),
                new Trade("IBM", "SELL", 50, 201.10)
        );

        List<Trade> booked = Arrays.asList(
                new Trade("CITI", "BUY", 100, 72.50)
        );

        List<Trade> unmatched = service.findUnmatchedIncomingTrades(incoming, booked);

        assertEquals(1, unmatched.size(), "Exactly one incoming trade should be unmatched");
        assertEquals("IBM", unmatched.get(0).getSymbol(), "IBM should be unmatched");
    }

    private static void testFullyReconciled() {
        TradeReconciliationService service = new TradeReconciliationService();

        List<Trade> incoming = Arrays.asList(
                new Trade("CITI", "BUY", 100, 72.50)
        );

        List<Trade> booked = Arrays.asList(
                new Trade("CITI", "BUY", 100, 72.50)
        );

        assertTrue(service.isFullyReconciled(incoming, booked),
                "Identical incoming/booked trades should reconcile");
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
