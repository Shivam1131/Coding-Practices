package org.example.designpattern.solid;

import java.math.BigDecimal;

public class CheckoutService {
    private final ReceiptCalculator calculator;
    private final DiscountPolicy discountPolicy;
    private final PaymentMethod paymentMethod;
    private final OrderRepository orderRepository;
    private final ReceiptFormatter receiptFormatter;
    private final ReceiptPrinter receiptPrinter;

    public CheckoutService(
            ReceiptCalculator calculator,
            DiscountPolicy discountPolicy,
            PaymentMethod paymentMethod,
            OrderRepository orderRepository,
            ReceiptFormatter receiptFormatter,
            ReceiptPrinter receiptPrinter
    ) {
        this.calculator = calculator;
        this.discountPolicy = discountPolicy;
        this.paymentMethod = paymentMethod;
        this.orderRepository = orderRepository;
        this.receiptFormatter = receiptFormatter;
        this.receiptPrinter = receiptPrinter;
    }

    public PaymentReceipt checkout(Order order) {
        BigDecimal subtotal = calculator.subtotal(order);
        BigDecimal discount = discountPolicy.apply(subtotal);
        BigDecimal payable = subtotal.subtract(discount);

        PaymentReceipt paymentReceipt = paymentMethod.pay(payable);
        orderRepository.save(order, paymentReceipt);

        String receipt = receiptFormatter.format(order, subtotal, discount, payable, paymentReceipt);
        receiptPrinter.print(receipt);

        return paymentReceipt;
    }
}
