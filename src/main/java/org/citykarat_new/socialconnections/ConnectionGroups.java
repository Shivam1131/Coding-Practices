package org.citykarat_new.socialconnections;

import java.util.List;

public class ConnectionGroups {

    private final List<String> belowThreshold;
    private final List<String> atOrAboveThreshold;

    public ConnectionGroups(List<String> belowThreshold,
                            List<String> atOrAboveThreshold) {
        this.belowThreshold = belowThreshold;
        this.atOrAboveThreshold = atOrAboveThreshold;
    }

    public List<String> getBelowThreshold() {
        return belowThreshold;
    }

    public List<String> getAtOrAboveThreshold() {
        return atOrAboveThreshold;
    }
}
