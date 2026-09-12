package org.example.designpattern.proxy;

public class ProxyDemo {
    public static void main(String[] args) {
        Image image = new ImageProxy("profile-photo.png");

        System.out.println("Proxy object created. Real image is not loaded yet.");
        image.display();
        image.display();
    }
}
