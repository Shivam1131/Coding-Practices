package org.example.designpattern.solid;

public class ConsoleReceiptEmailSender implements ReceiptEmailSender {
    @Override
    public void email(String customerEmail, String receiptText) {
        System.out.println("Email sent to " + customerEmail);
    }
}
