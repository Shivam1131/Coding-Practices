package org.citykarat_new.playersgames;

public class GameResult {

    private final String playerId;
    private final String gameId;
    private final int score;

    public GameResult(String playerId, String gameId, int score) {
        this.playerId = playerId;
        this.gameId = gameId;
        this.score = score;
    }

    public String getPlayerId() {
        return playerId;
    }

    public String getGameId() {
        return gameId;
    }

    public int getScore() {
        return score;
    }
}
