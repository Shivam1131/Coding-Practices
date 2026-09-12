package org.citykarat_new.account;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Account {

    private final String accountId;
    private long balanceInCents;
    private final List<Transaction> transactions = new ArrayList<>();

    public Account(String accountId, long openingBalanceInCents) {
        this.accountId = accountId;
        this.balanceInCents = openingBalanceInCents;
    }

    public String getAccountId() {
        return accountId;
    }

    public long getBalanceInCents() {
        return balanceInCents;
    }

    public List<Transaction> getTransactions() {
        return Collections.unmodifiableList(transactions);
    }

    public void deposit(long amountInCents) {
        if (amountInCents <= 0) {
            throw new IllegalArgumentException("Deposit must be positive");
        }

        balanceInCents += amountInCents;
        transactions.add(new Transaction(Transaction.Type.DEPOSIT, amountInCents));
    }

    /*
     * TASK 1:
     * A test reveals incorrect withdrawal behavior.
     * Fix the existing implementation.
     */
    public boolean withdraw(long amountInCents) {
        if (amountInCents > balanceInCents) {
            return false;
        }

        balanceInCents -= amountInCents;
        transactions.add(new Transaction(Transaction.Type.WITHDRAWAL, amountInCents));
        return true;
    }
}
