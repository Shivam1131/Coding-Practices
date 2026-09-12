package org.citykarat_new.resourceaccesslog;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ResourceAccessAnalyzer {

    /*
     * TASK 1:
     * This existing implementation should count accesses per resource.
     * A test exposes a bug. Find and fix it.
     */
    public Map<String, Integer> countByResource(List<AccessRecord> records) {
        Map<String, Integer> counts = new HashMap<>();

        for (AccessRecord record : records) {
            counts.put(record.getResource(), counts.getOrDefault(record.getResource(), 0) + 1);
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
        Map<String, Long> recordMap = records.stream().collect(Collectors.groupingBy(record-> record.getResource(),
                Collectors.collectingAndThen(Collectors.toList(), list->list.stream().count())));

        long max = recordMap.values().stream().mapToLong(Long::longValue).max().orElse(0);

        String mostAccessedResource = "";
        for(Map.Entry<String, Long> entry : recordMap.entrySet()) {
            if(entry.getValue().equals(max)){
                mostAccessedResource =  entry.getKey();
            }
        }

        return mostAccessedResource;
        //throw new UnsupportedOperationException("TODO: implement mostAccessedResource");
    }

    /*
     * TASK 3:
     * Return:
     *      userId -> distinct resources accessed
     *
     * Each user's resource list must be sorted alphabetically.
     */
    public Map<String, List<String>> resourcesByUser(List<AccessRecord> records) {
        Map<String, List<String>> recordMap = records.stream()
                .collect(Collectors.groupingBy(record -> record.getUserId(),
                        Collectors.collectingAndThen(Collectors.toList(), list -> list.stream().map(e -> e.getResource()).distinct().collect(Collectors.toList()))));
        return recordMap;
        //throw new UnsupportedOperationException("TODO: implement resourcesByUser");
    }

    /*
     * TASK 4:
     * Return users who accessed the SAME resource at least threshold times.
     *
     * Example:
     * threshold = 3
     * A user who hits /payments 3 times qualifies.
     */
    // List<AccessRecord> records = Arrays.asList(
    //                new AccessRecord("U1", "/orders", 100),
    //                new AccessRecord("U1", "/orders", 110),
    //                new AccessRecord("U2", "/users", 120),
    //                new AccessRecord("U1", "/orders", 130),
    //                new AccessRecord("U2", "/orders", 140)
    //        );
    public List<String> frequentUsersForSameResource(List<AccessRecord> records,
                                                     int threshold) {

        //Map<userId, Map<resource,count>>
        Map<String, Map<String,Long>> recordMap =
                records.stream().collect(Collectors.groupingBy(record-> record.getUserId(),
                Collectors.groupingBy(e->e.getResource(), Collectors.counting())));
        List<String> userIds = new ArrayList<>();

        for(Map.Entry<String, Map<String,Long>> group: recordMap.entrySet()) {
            for(Map.Entry<String, Long> resource: group.getValue().entrySet()){
                if(resource.getValue()>=threshold)
                    userIds.add(group.getKey());
            }
        }

        return userIds;
        // throw new UnsupportedOperationException("TODO: implement frequentUsersForSameResource");
    }
}
