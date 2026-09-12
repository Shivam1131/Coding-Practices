package org.example.designpattern.builder;

public class BuilderDemo {
    public static void main(String[] args) {
        PizzaOrder simpleOrder = new PizzaOrder.Builder("medium")
                .cheese()
                .build();

        PizzaOrder customOrder = new PizzaOrder.Builder("large")
                .crust("thin")
                .cheese()
                .paneer()
                .olives()
                .extraSauce()
                .build();

        System.out.println(simpleOrder);
        System.out.println(customOrder);
    }
}
