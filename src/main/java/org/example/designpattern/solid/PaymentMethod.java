package org.example.designpattern.solid;

import java.math.BigDecimal;

public interface PaymentMethod {
    PaymentReceipt pay(BigDecimal amount);
}
