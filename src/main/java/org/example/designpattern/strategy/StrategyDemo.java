package org.example.designpattern.strategy;

import java.math.BigDecimal;

public class StrategyDemo {
    public static void main(String[] args) {
        ShoppingCart cart = new ShoppingCart(new NoDiscountStrategy());
        BigDecimal amount = new BigDecimal("1000.00");

        System.out.println("No discount final amount: Rs." + cart.finalAmount(amount));

        cart.setDiscountStrategy(new PercentageDiscountStrategy(new BigDecimal("15")));
        System.out.println("15% discount final amount: Rs." + cart.finalAmount(amount));

        cart.setDiscountStrategy(new FlatDiscountStrategy(new BigDecimal("200.00")));
        System.out.println("Flat Rs.200 discount final amount: Rs." + cart.finalAmount(amount));
    }
}
