package org.citykarat.tollboothlogs;

import java.util.HashSet;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

enum BoothType {
    ENTRY,
    EXIT,
    MAINROAD
}

class LogEntry {
    double timestamp;
    String licensePlate;
    String location;
    BoothType boothType;

    LogEntry(double timestamp, String licensePlate, String location, BoothType boothType) {
        this.timestamp = timestamp;
        this.licensePlate = licensePlate;
        this.location = location;
        this.boothType = boothType;
    }
}

public class TollBoothLogProblem {
    public static List<String> rawLogLines() {
        return Arrays.asList(
                "90750.191 JOX304 250E ENTRY",
                "91081.684 JOX304 260E MAINROAD",
                "91483.251 JOX304 280E EXIT",
                "91874.493 THX138 250E ENTRY",
                "91910.000 THX138 260E MAINROAD",
                "92200.000 THX138 280E EXIT",
                "93000.000 ABC123 250E ENTRY",
                "93100.000 ABC123 280E EXIT"
        );
    }

    // TODO 1: Parse one raw log line into a LogEntry.
    public LogEntry parse(String line) {
        String[] parts = line.split("\\s+");

        double timestamp = Double.parseDouble(parts[0]);
        String licensePlate = parts[1];
        String location = parts[2];
        BoothType boothType = BoothType.valueOf(parts[3]);

        return new LogEntry(timestamp, licensePlate, location, boothType);
    }

    // TODO 2: Count complete journeys.
    // Complete journey pattern:
    // ENTRY -> zero or more MAINROAD -> EXIT
    // You may assume no missing entries in the simple version.
    public int countJourneys(List<String> lines) {
        Set<String> activeCars = new HashSet<>();
        int journeys = 0;

        for (String line : lines) {
            LogEntry entry = parse(line);

            if (entry.boothType == BoothType.ENTRY) {
                activeCars.add(entry.licensePlate);
            } else if (entry.boothType == BoothType.EXIT
                    && activeCars.contains(entry.licensePlate)) {
                journeys++;
                activeCars.remove(entry.licensePlate);
            }
        }

        return journeys;
    }

    // TODO 3: Calculate average speed between two sensor records.
    // This is usually the harder follow-up.
    public double calculateSpeedKmph(LogEntry start, LogEntry end) {
        double distanceKm = Math.abs(getLocationNumber(end.location) - getLocationNumber(start.location));
        double hours = (end.timestamp - start.timestamp) / 3600.0;

        if (hours <= 0) {
            return 0.0;
        }

        return distanceKm / hours;
    }

    private int getLocationNumber(String location) {
        String numberOnly = location.replaceAll("[^0-9]", "");
        return Integer.parseInt(numberOnly);
    }
}


