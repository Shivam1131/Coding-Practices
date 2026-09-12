package org.citykarat_new.socialconnections;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class SocialNetwork {

    private final Map<String, Set<String>> connections = new HashMap<>();

    public void apply(ConnectionEvent event) {
        connections.computeIfAbsent(event.getUserA(), key -> new HashSet<>());
        connections.computeIfAbsent(event.getUserB(), key -> new HashSet<>());

        if (event.getType() == ConnectionEvent.Type.CONNECT) {
            connections.get(event.getUserA()).add(event.getUserB());
            connections.get(event.getUserB()).add(event.getUserA());
        } else {
            /*
             * TASK 1:
             * A supplied test exposes a bug in DISCONNECT behavior.
             * Find and fix it.
             */
            connections.get(event.getUserA()).remove(event.getUserB());
        }
    }

    public int connectionCount(String user) {
        return connections.getOrDefault(user, java.util.Collections.emptySet()).size();
    }

    /*
     * TASK 2:
     * Split every known user into:
     *  - number of active connections < threshold
     *  - number of active connections >= threshold
     *
     * Return names sorted alphabetically within each group.
     */
    public ConnectionGroups groupByConnectionCount(int threshold) {
        throw new UnsupportedOperationException("TODO: implement groupByConnectionCount");
    }
}
