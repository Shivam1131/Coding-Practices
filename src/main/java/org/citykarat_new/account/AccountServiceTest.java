package org.citykarat_new.account;

public class AccountServiceTest {

    public static void main(String[] args) {
        testInvalidWithdrawal();
        testTransfer();
        testTotalWithdrawals();
        System.out.println("Account tests completed.");
    }

    private static void testInvalidWithdrawal() {
        Account account = new Account("A1", 10_000);

        boolean success = account.withdraw(-500);

        assertFalse(success, "Negative withdrawal must not succeed");
        assertEquals(10_000L, account.getBalanceInCents(),
                "Negative withdrawal must not increase balance");
    }

    private static void testTransfer() {
        Account source = new Account("A1", 10_000);
        Account destination = new Account("A2", 2_000);
        AccountService service = new AccountService();

        assertTrue(service.transfer(source, destination, 3_000), "Transfer should succeed");
        assertEquals(7_000L, source.getBalanceInCents(), "Source balance");
        assertEquals(5_000L, destination.getBalanceInCents(), "Destination balance");
    }

    private static void testTotalWithdrawals() {
        Account account = new Account("A1", 10_000);
        account.withdraw(1_000);
        account.withdraw(2_000);

        AccountService service = new AccountService();
        assertEquals(3_000L, service.totalWithdrawals(account), "Total withdrawals");
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
