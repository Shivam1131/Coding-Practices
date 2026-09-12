package org.citykarat_new.playersgames;

public class Player {

    private final String id;
    private final String name;
    private final String managerId;

    public Player(String id, String name, String managerId) {
        this.id = id;
        this.name = name;
        this.managerId = managerId;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getManagerId() {
        return managerId;
    }
}
