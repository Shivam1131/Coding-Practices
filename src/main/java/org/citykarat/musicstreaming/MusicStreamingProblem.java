package org.citykarat.musicstreaming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

class Song {
    int songId;
    String title;
    String artist;
    int durationSeconds;

    Song(int songId, String title, String artist, int durationSeconds) {
        this.songId = songId;
        this.title = title;
        this.artist = artist;
        this.durationSeconds = durationSeconds;
    }
}

class PlayEvent {
    int playId;
    int userId;
    int songId;
    int listenedSeconds;

    PlayEvent(int playId, int userId, int songId, int listenedSeconds) {
        this.playId = playId;
        this.userId = userId;
        this.songId = songId;
        this.listenedSeconds = listenedSeconds;
    }
}

class ListenerStats {
    int totalPlays;
    int uniqueSongs;
    double completionRate;

    ListenerStats(int totalPlays, int uniqueSongs, double completionRate) {
        this.totalPlays = totalPlays;
        this.uniqueSongs = uniqueSongs;
        this.completionRate = completionRate;
    }
}

class DedupResult {
    int songId;
    List<Integer> mergedIds;

    DedupResult(int songId, List<Integer> mergedIds) {
        this.songId = songId;
        this.mergedIds = mergedIds;
    }
}

public class MusicStreamingProblem {
    public static List<Song> sampleSongs() {
        return Arrays.asList(
                new Song(1, "Sky Road", "Nova", 180),
                new Song(2, "River Run", "Echo", 210),
                new Song(3, "sky road", "NOVA", 180),
                new Song(4, "Midnight", "Echo", 200),
                new Song(5, "River Run", "Echo", 210)
        );
    }

    public static List<PlayEvent> samplePlayEvents() {
        return Arrays.asList(
                new PlayEvent(101, 10, 1, 180),
                new PlayEvent(102, 10, 2, 50),
                new PlayEvent(103, 10, 1, 120),
                new PlayEvent(104, 20, 4, 200),
                new PlayEvent(105, 20, 2, 210)
        );
    }

    // TODO 1: Return stats for one listener.
    // totalPlays: total play events by the user.
    // uniqueSongs: distinct songs played by the user.
    // completionRate: completed plays / total plays.
    // A play is completed if listenedSeconds >= song duration.
    public ListenerStats getListenerStats(int userId) {
        List<PlayEvent> userEvents = playEvents.stream()
                .filter(event -> event.userId == userId)
                .collect(Collectors.toList());

        int totalPlays = userEvents.size();

        int uniqueSongs = (int) userEvents.stream()
                .map(event -> event.songId)
                .distinct()
                .count();

        Map<Integer, Song> songsById = songs.stream()
                .collect(Collectors.toMap(song -> song.songId, song -> song));

        int completedPlays = (int) userEvents.stream()
                .filter(event -> event.listenedSeconds >= songsById.get(event.songId).durationSeconds)
                .count();

        double completionRate = totalPlays == 0
                ? 0.0
                : completedPlays / (double) totalPlays;

        return new ListenerStats(totalPlays, uniqueSongs, completionRate);
    }

    // TODO 2: Find duplicate song groups.
    // Duplicate key: title case-insensitive + artist case-insensitive + duration.
    // Keep the smallest songId. mergedIds should be sorted ascending.
    // Example duplicate groups:
    // song 1 keeps song 3
    // song 2 keeps song 5
    public List<DedupResult> findDuplicateGroups() {
        Map<String, List<Song>> songsByDuplicateKey = songs.stream()
                .collect(Collectors.groupingBy(song ->
                        song.title.toLowerCase() + "|" +
                                song.artist.toLowerCase() + "|" +
                                song.durationSeconds
                ));

        return songsByDuplicateKey.values()
                .stream()
                .filter(group -> group.size() > 1)
                .map(group -> {
                    List<Song> sortedGroup = group.stream()
                            .sorted((a, b) -> Integer.compare(a.songId, b.songId))
                            .collect(Collectors.toList());

                    int keptSongId = sortedGroup.get(0).songId;

                    List<Integer> mergedIds = sortedGroup.stream()
                            .skip(1)
                            .map(song -> song.songId)
                            .collect(Collectors.toList());

                    return new DedupResult(keptSongId, mergedIds);
                })
                .sorted((a, b) -> Integer.compare(a.songId, b.songId))
                .collect(Collectors.toList());
    }

    List<Song> songs = new ArrayList<>(sampleSongs());
    List<PlayEvent> playEvents = new ArrayList<>(samplePlayEvents());
}


