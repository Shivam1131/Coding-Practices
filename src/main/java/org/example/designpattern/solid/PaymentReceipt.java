package org.example.designpattern.solid;

import java.math.BigDecimal;

public record PaymentReceipt(String paymentMode, BigDecimal amount, String transactionId) {
}
