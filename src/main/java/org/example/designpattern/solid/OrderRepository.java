package org.example.designpattern.solid;

public interface OrderRepository {
    void save(Order order, PaymentReceipt paymentReceipt);
}
