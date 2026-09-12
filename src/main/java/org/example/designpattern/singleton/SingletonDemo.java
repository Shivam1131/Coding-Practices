package org.example.designpattern.singleton;

public class SingletonDemo {
    public static void main(String[] args) {
        AppConfig firstReference = AppConfig.getInstance();
        AppConfig secondReference = AppConfig.getInstance();

        firstReference.setEnvironment("production");

        System.out.println("App name: " + secondReference.getAppName());
        System.out.println("Environment from second reference: " + secondReference.getEnvironment());
        System.out.println("Both references point to same object: " + (firstReference == secondReference));
    }
}
