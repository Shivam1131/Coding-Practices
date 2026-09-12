package org.citykarat_new.passagetracker;

public class PassageEvent {

    public enum Type {
        ENTER,
        EXIT
    }

    private final String personId;
    private final long timestamp;
    private final Type type;

    public PassageEvent(String personId, long timestamp, Type type) {
        this.personId = personId;
        this.timestamp = timestamp;
        this.type = type;
    }

    public String getPersonId() {
        return personId;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public Type getType() {
        return type;
    }
}
