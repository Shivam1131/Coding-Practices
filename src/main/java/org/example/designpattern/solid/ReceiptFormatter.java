package org.example.designpattern.solid;

import java.math.BigDecimal;

public class ReceiptFormatter {
    public String format(Order order, BigDecimal subtotal, BigDecimal discount, BigDecimal payable, PaymentReceipt paymentReceipt) {
        StringBuilder receipt = new StringBuilder();
        receipt.append("Order: ").append(order.id()).append(System.lineSeparator());
        receipt.append("Customer: ").append(order.customerEmail()).append(System.lineSeparator());
        receipt.append("Items:").append(System.lineSeparator());

        for (OrderItem item : order.items()) {
            receipt.append("- ")
                    .append(item.name())
                    .append(" x ")
                    .append(item.quantity())
                    .append(" = Rs.")
                    .append(item.total())
                    .append(System.lineSeparator());
        }

        receipt.append("Subtotal: Rs.").append(subtotal).append(System.lineSeparator());
        receipt.append("Discount: Rs.").append(discount).append(System.lineSeparator());
        receipt.append("Paid: Rs.").append(payable).append(System.lineSeparator());
        receipt.append("Payment: ").append(paymentReceipt.paymentMode());
        return receipt.toString();
    }
}
