package org.example.designpattern.singleton;

public class AppConfig {
    private static volatile AppConfig instance;

    private String appName = "Coding Prep";
    private String environment = "local";

    private AppConfig() {
    }

    public static AppConfig getInstance() {
        if (instance == null) {
            instance = new AppConfig();
        }
        return instance;
    }

    public String getAppName() {
        return appName;
    }

    public String getEnvironment() {
        return environment;
    }

    public void setEnvironment(String environment) {
        this.environment = environment;
    }
}
