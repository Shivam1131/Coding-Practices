package org.example.designpattern.solid;

public class ConsoleReceiptPrinter implements ReceiptPrinter {
    @Override
    public void print(String receiptText) {
        System.out.println(receiptText);
    }
}
