package org.citykarat_new.account;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

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
        if(amountInCents <= 0L || Objects.isNull(source) || Objects.isNull(destination) || source.getBalanceInCents() < amountInCents) {
            return false;
        }
        source.withdraw(amountInCents);
        destination.deposit(amountInCents);
        return true;
       // throw new UnsupportedOperationException("TODO: implement transfer");
    }

    /*
     * TASK 3:
     * Return the total amount withdrawn from an account.
     */
    public long totalWithdrawals(Account account) {
        return account.getTransactions().stream().filter(t->t.getType().equals(Transaction.Type.WITHDRAWAL)).mapToLong(e->e.getAmountInCents()).sum();
        //throw new UnsupportedOperationException("TODO: implement totalWithdrawals");
    }

    /*
     * TASK 4:
     * Given accounts, return IDs of accounts with balance less than threshold.
     * Preserve input order.
     */
    public List<String> accountsBelowBalance(List<Account> accounts, long thresholdInCents) {
        return accounts.stream().filter(a->a.getBalanceInCents() < thresholdInCents).map(acc->acc.getAccountId()).collect(Collectors.toList());
       // throw new UnsupportedOperationException("TODO: implement accountsBelowBalance");
    }
}
