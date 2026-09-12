package org.citykarat_new.account;

public class Transaction {

    public enum Type {
        DEPOSIT,
        WITHDRAWAL
    }

    private final Type type;
    private final long amountInCents;

    public Transaction(Type type, long amountInCents) {
        this.type = type;
        this.amountInCents = amountInCents;
    }

    public Type getType() {
        return type;
    }

    public long getAmountInCents() {
        return amountInCents;
    }
}
