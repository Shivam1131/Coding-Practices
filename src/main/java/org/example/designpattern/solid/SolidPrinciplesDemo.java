package org.example.designpattern.solid;

import java.math.BigDecimal;
import java.util.List;

public class SolidPrinciplesDemo {
    public static void main(String[] args) {
        Order order = new Order(
                "ORD-1001",
                "student@example.com",
                List.of(
                        new OrderItem("Java Book", 1, new BigDecimal("650.00")),
                        new OrderItem("Practice Notebook", 2, new BigDecimal("80.00"))
                )
        );

        System.out.println("=== Checkout with card payment ===");
        runCheckout(order, new FestivalDiscount(new BigDecimal("10")), new CardPayment("1234"));

        System.out.println();
        System.out.println("=== Same checkout service with UPI payment ===");
        runCheckout(order, new NoDiscount(), new UpiPayment("student@upi"));

        System.out.println();
        System.out.println("SOLID summary:");
        System.out.println("S: ReceiptCalculator calculates totals; ReceiptFormatter formats text; repository saves orders.");
        System.out.println("O: Add a new DiscountPolicy or PaymentMethod without changing CheckoutService.");
        System.out.println("L: CardPayment and UpiPayment can both replace PaymentMethod safely.");
        System.out.println("I: ReceiptPrinter and ReceiptEmailSender are separate small interfaces.");
        System.out.println("D: CheckoutService depends on interfaces such as DiscountPolicy, PaymentMethod, and OrderRepository.");
    }

    private static void runCheckout(Order order, DiscountPolicy discountPolicy, PaymentMethod paymentMethod) {
        CheckoutService checkoutService = new CheckoutService(
                new ReceiptCalculator(),
                discountPolicy,
                paymentMethod,
                new InMemoryOrderRepository(),
                new ReceiptFormatter(),
                new ConsoleReceiptPrinter()
        );

        PaymentReceipt receipt = checkoutService.checkout(order);
        System.out.println("Transaction id: " + receipt.transactionId());
    }
}
