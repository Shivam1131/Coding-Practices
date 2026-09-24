package org.citykarat.obstaclecourse;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Course {
    String title;
    int obstacleCount;

    Course(String title, int obstacleCount) {
        this.title = title;
        this.obstacleCount = obstacleCount;
    }
}

class Run {
    Course course;
    boolean complete;
    List<Integer> obstacleTimes = new ArrayList<>();

    Run(Course course, Integer... obstacleTimes) {
        this.course = course;
        this.obstacleTimes.addAll(Arrays.asList(obstacleTimes));
        this.complete = this.obstacleTimes.size() == course.obstacleCount;
    }

    int getRunTime() {
        return obstacleTimes.stream().mapToInt(Integer::intValue).sum();
    }
}

public class ObstacleCourseProblem {
    static Course sampleCourse = new Course("Test course", 4);

    public static List<Run> sampleRuns() {
        return Arrays.asList(
                new Run(sampleCourse, 3, 4, 5, 6),    // total 18, complete
                new Run(sampleCourse, 4, 4, 4, 5),    // total 17, complete
                new Run(sampleCourse, 4, 5, 4, 6),    // total 19, complete
                new Run(sampleCourse, 5, 5, 3)        // total 13, incomplete
        );
    }

    // TODO 1: Return the fastest complete run time.
    // Expected from raw data: 17
    /*public int personalBest() {

    }*/

    // TODO 2: Best possible total by taking fastest time for each obstacle.
    // Use complete and incomplete runs.
    // Obstacle 1 fastest = 3
    // Obstacle 2 fastest = 4
    // Obstacle 3 fastest = 3
    // Obstacle 4 fastest = 5
    // Expected total = 15
    public int bestOfBests() {
        int total = 0;



        return total;
    }

    // TODO 3: Use simulation to estimate chance that an in-progress run
    // will match or beat the current personal best.
    public double chanceOfPersonalBest(Run inProgressRun) {
       return 0.0d;
    }

    private List<Integer> getKnownTimesForObstacle(int obstacleIndex) {
        List<Integer> possibleTimes = new ArrayList<>();

        for (Run run : runs) {
            if (run.obstacleTimes.size() > obstacleIndex) {
                possibleTimes.add(run.obstacleTimes.get(obstacleIndex));
            }
        }

        return possibleTimes;
    }

  /*  // TODO 1: Return the fastest complete run time.
    // Expected from raw data: 17
    public int personalBest() {
        return runs.stream()
                .filter(run -> run.complete)
                .mapToInt(Run::getRunTime)
                .min()
                .orElse(-1);
    }

    // TODO 2: Best possible total by taking fastest time for each obstacle.
    // Use complete and incomplete runs.
    // Obstacle 1 fastest = 3
    // Obstacle 2 fastest = 4
    // Obstacle 3 fastest = 3
    // Obstacle 4 fastest = 5
    // Expected total = 15
    public int bestOfBests() {
        int total = 0;

        for (int obstacleIndex = 0; obstacleIndex < sampleCourse.obstacleCount; obstacleIndex++) {
            int bestTimeForObstacle = Integer.MAX_VALUE;

            for (Run run : runs) {
                if (run.obstacleTimes.size() > obstacleIndex) {
                    bestTimeForObstacle = Math.min(
                            bestTimeForObstacle,
                            run.obstacleTimes.get(obstacleIndex)
                    );
                }
            }

            if (bestTimeForObstacle != Integer.MAX_VALUE) {
                total += bestTimeForObstacle;
            }
        }

        return total;
    }

    // TODO 3: Use simulation to estimate chance that an in-progress run
    // will match or beat the current personal best.
    public double chanceOfPersonalBest(Run inProgressRun) {
        int personalBest = personalBest();
        int trials = 10_000;
        int successCount = 0;
        Random random = new Random(0);

        for (int trial = 0; trial < trials; trial++) {
            int simulatedTotal = inProgressRun.getRunTime();

            for (int obstacleIndex = inProgressRun.obstacleTimes.size();
                 obstacleIndex < inProgressRun.course.obstacleCount;
                 obstacleIndex++) {

                List<Integer> possibleTimes = getKnownTimesForObstacle(obstacleIndex);

                if (!possibleTimes.isEmpty()) {
                    int randomIndex = random.nextInt(possibleTimes.size());
                    simulatedTotal += possibleTimes.get(randomIndex);
                }
            }

            if (simulatedTotal <= personalBest) {
                successCount++;
            }
        }

        return successCount / (double) trials;
    }

    private List<Integer> getKnownTimesForObstacle(int obstacleIndex) {
        List<Integer> possibleTimes = new ArrayList<>();

        for (Run run : runs) {
            if (run.obstacleTimes.size() > obstacleIndex) {
                possibleTimes.add(run.obstacleTimes.get(obstacleIndex));
            }
        }

        return possibleTimes;
    }*/

    List<Run> runs = new ArrayList<>(sampleRuns());
}


