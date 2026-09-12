package org.example.designpattern.facade;

public class StreamingPlayer {
    public void on() {
        System.out.println("Streaming player on");
    }

    public void play(String movieName) {
        System.out.println("Playing movie: " + movieName);
    }

    public void stop() {
        System.out.println("Movie stopped");
    }

    public void off() {
        System.out.println("Streaming player off");
    }
}
