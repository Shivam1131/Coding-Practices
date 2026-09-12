package org.citykarat_new.playersgames;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class PlayerGameService {

    private final List<Player> players = new ArrayList<>();
    private final List<GameResult> results = new ArrayList<>();

    public void addPlayer(Player player) {
        players.add(player);
    }

    public void addResult(GameResult result) {
        results.add(result);
    }

    /*
     * TASK 1:
     * This method contains an existing bug.
     * Fix it without changing the method signature.
     */
    public List<Player> getPlayersForManager(String managerId) {
        List<Player> output = new ArrayList<>();

        for (Player player : players) {
            // Existing implementation. Do not assume it is correct.
            if (player.getManagerId() == managerId) {
                output.add(player);
            }
        }

        return output;
    }

    /*
     * TASK 2:
     * Calculate one player's average score.
     * Return null if the player has no game results.
     */
    public Double getAverageScore(String playerId) {
        throw new UnsupportedOperationException("TODO: implement getAverageScore");
    }

    /*
     * TASK 3:
     * Return a map:
     *      playerId -> average score
     * for every player managed by managerId.
     *
     * Include players who have no results with value null.
     */
    public Map<String, Double> getAverageScoresForManager(String managerId) {
        throw new UnsupportedOperationException("TODO: implement getAverageScoresForManager");
    }
}
