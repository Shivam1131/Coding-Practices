package org.citykarat_new.passagetracker;

import jdk.jfr.Event;

import java.util.*;
import java.util.stream.Collectors;

public class PassageTracker {

    /*
     * Existing helper used by the tests.
     *
     * TASK 1:
     * There is a bug in how EXIT events are handled.
     * Fix it.
     */
    public Set<String> peopleCurrentlyInside(List<PassageEvent> events) {
        Set<String> inside = new HashSet<>();

        for (PassageEvent event : events) {
            if (event.getType() == PassageEvent.Type.ENTER) {
                inside.add(event.getPersonId());
            } else {
                // Existing implementation. Do not assume it is correct.
                inside.remove(event.getPersonId());
            }
        }

        return inside;
    }

    /*
     * TASK 2:
     * Count complete passages for each person.
     *
     * A complete passage is ENTER followed later by EXIT.
     * A person may have multiple passages.
     *
     * Ignore an EXIT if that person is not currently inside.
     */
    public java.util.Map<String, Integer> countCompletePassages(List<PassageEvent> events) {
        events.sort(Comparator.comparing(e->e.getTimestamp()));

        java.util.Map<String, Integer> resultMap = new java.util.HashMap<String, Integer>();

        Set<String> inside = new HashSet<>();
        for(PassageEvent event: events) {
            if(event.getType() == PassageEvent.Type.ENTER){
                inside.add(event.getPersonId());
            } else {
                if (inside.contains(event.getPersonId())){
                    resultMap.put(event.getPersonId(), resultMap.getOrDefault(event.getPersonId(), 0)+1);
                    inside.remove(event.getPersonId());
                }
            }
        }
        return resultMap;
    }

    /*
     * TASK 3:
     * Return the average duration of complete passages for one person.
     * Return null if the person has no complete passage.
     */

    // Steps: filter by personId,   2-> check if entry is present then take current time and
    public Double averagePassageDuration(List<PassageEvent> events, String personId) {
        events = events.stream()
                .filter(e->e.getPersonId().equals(personId))
                .collect(Collectors.toList());

        List<Long> durations = new ArrayList<>();
        java.util.Map<String, Integer> resultMap = new java.util.HashMap<String, Integer>();
        Long enterTime = null;
        for(PassageEvent event: events) {
            if(event.getType() == PassageEvent.Type.ENTER){
                enterTime = event.getTimestamp();
            } else if(event.getType() == PassageEvent.Type.EXIT && Objects.nonNull(enterTime)) {
                durations.add(event.getTimestamp() - enterTime);
                enterTime =null;
            }
        }
        return durations
                .stream()
                .mapToLong(d->d)
                .average().orElse(0.0D);
        //throw new UnsupportedOperationException("TODO: implement averagePassageDuration");
    }
}
