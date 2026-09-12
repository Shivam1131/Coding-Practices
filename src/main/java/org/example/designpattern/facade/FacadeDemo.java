package org.example.designpattern.facade;

public class FacadeDemo {
    public static void main(String[] args) {
        HomeTheaterFacade homeTheater = new HomeTheaterFacade(
                new Projector(),
                new SoundSystem(),
                new StreamingPlayer(),
                new RoomLights()
        );

        System.out.println("Starting movie night");
        homeTheater.watchMovie("Interstellar");

        System.out.println();
        System.out.println("Ending movie night");
        homeTheater.endMovie();
    }
}
