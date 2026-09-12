package org.citykarat_new.passagetracker;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
                inside.add(event.getPersonId());
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
        throw new UnsupportedOperationException("TODO: implement countCompletePassages");
    }

    /*
     * TASK 3:
     * Return the average duration of complete passages for one person.
     * Return null if the person has no complete passage.
     */
    public Double averagePassageDuration(List<PassageEvent> events, String personId) {
        throw new UnsupportedOperationException("TODO: implement averagePassageDuration");
    }
}
