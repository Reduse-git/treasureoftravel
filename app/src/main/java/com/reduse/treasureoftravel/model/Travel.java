package com.reduse.treasureoftravel.model;


import java.util.UUID;

public class Travel {

    private UUID id;
    private String title;

    public Travel() {
        id = UUID.randomUUID();
        title = id.toString();
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
