package org.citykarat_new.account;

import java.util.List;

public class AccountService {

    /*
     * TASK 2:
     * Transfer amount from source to destination.
     *
     * Requirements:
     * - amount must be positive
     * - no money must disappear
     * - if source has insufficient funds, neither account changes
     * - return true on successful transfer, false otherwise
     */
    public boolean transfer(Account source, Account destination, long amountInCents) {
        throw new UnsupportedOperationException("TODO: implement transfer");
    }

    /*
     * TASK 3:
     * Return the total amount withdrawn from an account.
     */
    public long totalWithdrawals(Account account) {
        throw new UnsupportedOperationException("TODO: implement totalWithdrawals");
    }

    /*
     * TASK 4:
     * Given accounts, return IDs of accounts with balance less than threshold.
     * Preserve input order.
     */
    public List<String> accountsBelowBalance(List<Account> accounts, long thresholdInCents) {
        throw new UnsupportedOperationException("TODO: implement accountsBelowBalance");
    }
}
