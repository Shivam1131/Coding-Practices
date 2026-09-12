package org.citykarat_new.playersgames;

import java.util.*;
import java.util.stream.Collectors;

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
            if (player.getManagerId().equals(managerId)) {
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

        double average =  results.stream()
                .filter(e->e.getPlayerId().equals(playerId))
                .mapToInt(p->p.getScore())
                .average()
                .orElse(0.0d);

        return average == 0? null: average;
    }


  //      service.addPlayer(new Player("P1", "Asha", new String("M1")));
   //     service.addPlayer(new Player("P2", "Ravi", new String("M1")));
    //    service.addPlayer(new Player("P3", "Meera", new String("M2")));
    /*
     * TASK 3:
     * Return a map:
     *      playerId -> average score
     * for every player managed by managerId.
     *
     * Include players who have no results with value null.
     */
    public Map<String, Double> getAverageScoresForManager(String managerId) {
        Map<String, Double> scoresMap = new HashMap<>();
        players.stream().filter(p->p.getManagerId().equals(managerId)).forEach(player -> {
            scoresMap.put(player.getId(), getAverageScore(player.getId()));
        });
        return scoresMap;
        //throw new UnsupportedOperationException("TODO: implement getAverageScoresForManager");
    }
}
