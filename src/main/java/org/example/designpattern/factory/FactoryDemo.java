package org.example.designpattern.factory;

public class FactoryDemo {
    public static void main(String[] args) {
        NotificationFactory factory = new NotificationFactory();

        Notification email = factory.create(NotificationType.EMAIL);
        Notification sms = factory.create(NotificationType.SMS);
        Notification push = factory.create(NotificationType.PUSH);

        email.send("Your order has been placed.");
        sms.send("Your OTP is 456789.");
        push.send("Your package is out for delivery.");
    }
}
