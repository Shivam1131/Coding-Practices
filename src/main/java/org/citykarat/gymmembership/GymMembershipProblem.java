package org.citykarat.gymmembership;

import java.util.*;
import java.util.stream.Collectors;

enum MembershipStatus {
    BRONZE,
    SILVER,
    GOLD
}

class Member {
    int memberId;
    String name;
    MembershipStatus status;

    Member(int memberId, String name, MembershipStatus status) {
        this.memberId = memberId;
        this.name = name;
        this.status = status;
    }
}

class Workout {
    int workoutId;
    int startMinute;
    int endMinute;

    Workout(int workoutId, int startMinute, int endMinute) {
        this.workoutId = workoutId;
        this.startMinute = startMinute;
        this.endMinute = endMinute;
    }

    int getDuration() {
        return endMinute - startMinute;
    }
}

class MembershipStatistics {
    int totalMembers;
    int paidMembers;
    double paidConversionRate;

    MembershipStatistics(int totalMembers, int paidMembers, double paidConversionRate) {
        this.totalMembers = totalMembers;
        this.paidMembers = paidMembers;
        this.paidConversionRate = paidConversionRate;
    }
}

public class GymMembershipProblem {
    public static List<Member> sampleMembers() {
        return Arrays.asList(
                new Member(12, "Anu", MembershipStatus.BRONZE),
                new Member(22, "Ben", MembershipStatus.SILVER),
                new Member(31, "Cara", MembershipStatus.GOLD),
                new Member(44, "Dev", MembershipStatus.BRONZE)
        );
    }

    public static Map<Integer, List<Workout>> sampleWorkoutMap() {
        Map<Integer, List<Workout>> workouts = new HashMap<>();
        workouts.put(
                12, new ArrayList<>(Arrays.asList(
                        new Workout(1, 60, 80),
                        new Workout(2, 90, 120)
                )));
        workouts.put(
                22, new ArrayList<>(Arrays.asList(
                        new Workout(3, 100, 150)
                )));
        workouts.put(
                31, new ArrayList<>(Arrays.asList(
                        new Workout(4, 30, 100),
                        new Workout(5, 200, 275)
                )));
        return workouts;
    }

    // TODO 1: Count total members, paid members, and paid conversion rate.
    // SILVER and GOLD are paid memberships.
    // Example: 4 total, 2 paid, conversion = 50.0
    public MembershipStatistics getMembershipStatistics() {
        int paidMembers = (int) members.stream().filter(e-> !e.status.equals(MembershipStatus.BRONZE)).count();
        int totalMembers = members.size();
        double conversionRate = totalMembers == 0 ? 0.0 : (paidMembers / (double) totalMembers) * 100;
        return new MembershipStatistics(totalMembers, paidMembers, conversionRate);
        //throw new UnsupportedOperationException("Implement this");
    }

    // TODO 2: Add workout for an existing member.
    // If member does not exist, ignore or return false depending on version.
    public boolean addWorkout(int memberId, Workout workout) {
        if(members.stream().anyMatch(e-> e.memberId == memberId)){
            workoutsByMember.computeIfAbsent(memberId, id->new ArrayList<>()).add(workout);
            return true;
        } else
            return false;
       // throw new UnsupportedOperationException("Implement this");
    }

    // TODO 3: Average workout duration by member.
    // Example:
    // member 12 => (20 + 30) / 2 = 25.0
    // member 22 => 50.0
    // member 31 => (70 + 75) / 2 = 72.5
    public Map<Integer, Double> getAverageWorkoutDurations() {
        Map<Integer, Double> memberAverageMap = new HashMap<>();
        workoutsByMember.forEach((memberId, workout)->{
                Double average = workout.stream().collect(Collectors.averagingInt(e-> e.getDuration()));
                    memberAverageMap.put(memberId, average);
        });
        return memberAverageMap;
        //throw new UnsupportedOperationException("Implement this");
    }

    // TODO 4: Calculate due payments.
    // BRONZE: first 1 workout free, then $10/hour
    // SILVER: first 3 workouts free, then $8/hour
    // GOLD: first 5 workouts free, then $6/hour
    // Round every workout duration up to the nearest hour.
    public Map<Integer, Integer> getDuePayments() {
        Map<Integer, Integer> paymentsMap = new HashMap<>();
        for(Member member : members) {
            if(workoutsByMember.containsKey(member.memberId)){
               List<Workout> workouts = workoutsByMember.get(member.memberId);
               workouts.sort(Comparator.comparingInt(k->k.workoutId));
                int freeWorkout;
                int hourlyRate;
               if(member.status.equals(MembershipStatus.BRONZE)){
                    freeWorkout = 1;
                    hourlyRate = 10;
                } else if (member.status.equals(MembershipStatus.SILVER)) {
                    freeWorkout = 3;
                    hourlyRate = 8;
                } else if (member.status.equals(MembershipStatus.GOLD)) {
                    freeWorkout = 5;
                    hourlyRate = 6;
                } else {
                   freeWorkout = 0;
                   hourlyRate = 10;
               }
                int payment = workouts.stream()
                        .skip(freeWorkout)
                        .mapToInt(e -> (int) (Math.ceil(e.getDuration() / 60.0) * hourlyRate))
                        .sum();
                paymentsMap.put(member.memberId, payment);
            }
        }

      //  throw new UnsupportedOperationException("Implement this");
    return paymentsMap;
    }

    List<Member> members = new ArrayList<>(sampleMembers());
    Map<Integer, List<Workout>> workoutsByMember = sampleWorkoutMap();
}

