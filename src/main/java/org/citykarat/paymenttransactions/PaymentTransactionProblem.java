package org.citykarat.paymenttransactions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

enum TransactionType {
    CREDIT,
    DEBIT
}

class Account {
    int accountId;
    String ownerName;

    Account(int accountId, String ownerName) {
        this.accountId = accountId;
        this.ownerName = ownerName;
    }
}

class Transaction {
    int transactionId;
    int accountId;
    TransactionType type;
    double amount;
    long timestampSec;

    Transaction(int transactionId, int accountId, TransactionType type, double amount, long timestampSec) {
        this.transactionId = transactionId;
        this.accountId = accountId;
        this.type = type;
        this.amount = amount;
        this.timestampSec = timestampSec;
    }
}

public class PaymentTransactionProblem {
    public static List<Account> sampleAccounts() {
        return Arrays.asList(
                new Account(1, "Alice"),
                new Account(2, "Bob"),
                new Account(3, "Charlie")
        );
    }

    public static List<Transaction> sampleTransactions() {
        return Arrays.asList(
                new Transaction(101, 1, TransactionType.CREDIT, 100.0, 1000),
                new Transaction(102, 1, TransactionType.DEBIT, 30.0, 1010),
                new Transaction(103, 1, TransactionType.DEBIT, 20.0, 1020),
                new Transaction(104, 1, TransactionType.CREDIT, 10.0, 1030),
                new Transaction(201, 2, TransactionType.CREDIT, 80.0, 2000),
                new Transaction(202, 2, TransactionType.DEBIT, 5.5, 2010),
                new Transaction(203, 2, TransactionType.DEBIT, 14.5, 2020)
        );
    }

    // TODO 1: Return current balance for one account.
    // Example:
    // account 1 balance = 100 - 30 - 20 + 10 = 60
    // account 2 balance = 80 - 5.5 - 14.5 = 60
    public double getBalance(int accountId) {
        Map<TransactionType, Double> map = transactions.stream()
                .filter(t->t.accountId == accountId)
                .collect(Collectors.groupingBy(transaction -> transaction.type,
                        Collectors.summingDouble(transaction -> transaction.amount)));
        transactions.stream().filter(t->t.accountId == accountId).
                mapToDouble(t->t.type == TransactionType.CREDIT ? t.amount : -t.amount).sum();
        return map.getOrDefault(TransactionType.CREDIT, 0.0D) - map.getOrDefault(TransactionType.DEBIT, 0.0D);
        //throw new UnsupportedOperationException("Implement this");
    }

    // TODO 2: Return average absolute transaction amount by account.
    // Example:
    // account 1 amounts = 100, 30, 20, 10 => average = 40
    // account 2 amounts = 80, 5.5, 14.5 => average = 33.333...
    // account 3 has no transactions, so it should not appear in the map.
    public Map<Integer, Double> getAverageTransactionAmountByAccount() {
       // throw new UnsupportedOperationException("Implement this");

return transactions.stream()
        .collect(Collectors.groupingBy(
                transaction -> transaction.accountId,
                Collectors.averagingDouble(
                        transaction -> Math.abs(transaction.amount))));

       // return null;
    }

    // Use these fields while solving, or create your own constructor if preferred.
    List<Account> accounts = new ArrayList<>(sampleAccounts());
    List<Transaction> transactions = new ArrayList<>(sampleTransactions());
}


