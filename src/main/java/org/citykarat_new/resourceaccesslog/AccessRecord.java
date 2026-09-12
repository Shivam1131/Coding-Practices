package org.citykarat_new.resourceaccesslog;

public class AccessRecord {

    private final String userId;
    private final String resource;
    private final long timestamp;

    public AccessRecord(String userId, String resource, long timestamp) {
        this.userId = userId;
        this.resource = resource;
        this.timestamp = timestamp;
    }

    public String getUserId() {
        return userId;
    }

    public String getResource() {
        return resource;
    }

    public long getTimestamp() {
        return timestamp;
    }
}
