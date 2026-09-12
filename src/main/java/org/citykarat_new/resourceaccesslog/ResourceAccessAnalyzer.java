package org.citykarat_new.resourceaccesslog;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ResourceAccessAnalyzer {

    /*
     * TASK 1:
     * This existing implementation should count accesses per resource.
     * A test exposes a bug. Find and fix it.
     */
    public Map<String, Integer> countByResource(List<AccessRecord> records) {
        Map<String, Integer> counts = new HashMap<>();

        for (AccessRecord record : records) {
            // Existing implementation. Do not assume it is correct.
            counts.put(record.getResource(), 1);
        }

        return counts;
    }

    /*
     * TASK 2:
     * Return the name of the most-accessed resource.
     *
     * Tie breaker:
     * alphabetically smaller resource name wins.
     *
     * Return null for an empty input.
     */
    public String mostAccessedResource(List<AccessRecord> records) {
        throw new UnsupportedOperationException("TODO: implement mostAccessedResource");
    }

    /*
     * TASK 3:
     * Return:
     *      userId -> distinct resources accessed
     *
     * Each user's resource list must be sorted alphabetically.
     */
    public Map<String, List<String>> resourcesByUser(List<AccessRecord> records) {
        throw new UnsupportedOperationException("TODO: implement resourcesByUser");
    }

    /*
     * TASK 4:
     * Return users who accessed the SAME resource at least threshold times.
     *
     * Example:
     * threshold = 3
     * A user who hits /payments 3 times qualifies.
     */
    public List<String> frequentUsersForSameResource(List<AccessRecord> records,
                                                     int threshold) {
        throw new UnsupportedOperationException("TODO: implement frequentUsersForSameResource");
    }
}
