package org.example.designpattern.facade;

public class HomeTheaterFacade {
    private final Projector projector;
    private final SoundSystem soundSystem;
    private final StreamingPlayer streamingPlayer;
    private final RoomLights roomLights;

    public HomeTheaterFacade(
            Projector projector,
            SoundSystem soundSystem,
            StreamingPlayer streamingPlayer,
            RoomLights roomLights
    ) {
        this.projector = projector;
        this.soundSystem = soundSystem;
        this.streamingPlayer = streamingPlayer;
        this.roomLights = roomLights;
    }

    public void watchMovie(String movieName) {
        roomLights.dim(20);
        projector.on();
        projector.wideScreenMode();
        soundSystem.on();
        soundSystem.setVolume(7);
        streamingPlayer.on();
        streamingPlayer.play(movieName);
    }

    public void endMovie() {
        streamingPlayer.stop();
        streamingPlayer.off();
        soundSystem.off();
        projector.off();
        roomLights.on();
    }
}
