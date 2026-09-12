package org.example.designpattern.facade;

public class RoomLights {
    public void dim(int percentage) {
        System.out.println("Lights dimmed to " + percentage + "%");
    }

    public void on() {
        System.out.println("Lights on");
    }
}
