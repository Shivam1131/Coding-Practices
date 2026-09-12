package org.citykarat_new.socialconnections;

public class ConnectionEvent {

    public enum Type {
        CONNECT,
        DISCONNECT
    }

    private final Type type;
    private final String userA;
    private final String userB;

    public ConnectionEvent(Type type, String userA, String userB) {
        this.type = type;
        this.userA = userA;
        this.userB = userB;
    }

    public Type getType() {
        return type;
    }

    public String getUserA() {
        return userA;
    }

    public String getUserB() {
        return userB;
    }
}
