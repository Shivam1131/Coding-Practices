package org.citykarat_new.playersgames;

import java.util.List;
import java.util.Map;

public class PlayerGameServiceTest {

    public static void main(String[] args) {
        PlayerGameService service = buildService();

        testManagerLookup(service);
        testPlayerAverage(service);
        testManagerAverages(service);

        System.out.println("Players/games tests completed.");
    }

    private static PlayerGameService buildService() {
        PlayerGameService service = new PlayerGameService();

        service.addPlayer(new Player("P1", "Asha", new String("M1")));
        service.addPlayer(new Player("P2", "Ravi", new String("M1")));
        service.addPlayer(new Player("P3", "Meera", new String("M2")));

        service.addResult(new GameResult("P1", "G1", 80));
        service.addResult(new GameResult("P1", "G2", 100));
        service.addResult(new GameResult("P3", "G1", 70));

        return service;
    }

    private static void testManagerLookup(PlayerGameService service) {
        List<Player> players = service.getPlayersForManager(new String("M1"));
        assertEquals(2, players.size(), "M1 should manage two players");
    }

    private static void testPlayerAverage(PlayerGameService service) {
        assertEquals(90.0, service.getAverageScore("P1"), "P1 average should be 90");
        assertEquals(null, service.getAverageScore("P2"), "P2 has no results");
    }

    private static void testManagerAverages(PlayerGameService service) {
        Map<String, Double> result = service.getAverageScoresForManager("M1");
        assertEquals(2, result.size(), "M1 result should contain every managed player");
        assertEquals(90.0, result.get("P1"), "P1 average");
        assertEquals(null, result.get("P2"), "P2 should be included with null");
    }

    private static void assertEquals(Object expected, Object actual, String message) {
        if (expected == null ? actual != null : !expected.equals(actual)) {
            throw new AssertionError(message + " | expected=" + expected + ", actual=" + actual);
        }
    }
}
