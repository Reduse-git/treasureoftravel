package com.reduse.treasureoftravel.model;


import android.media.Image;

import java.util.Date;
import java.util.Set;
import java.util.UUID;

public class Travel {

    private UUID id;
    private String title;
    private Set<Image> imagesLib;
    private Date date;
    private String description;

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Travel() {
        id = UUID.randomUUID();
        title = id.toString();
    }

    public Set<Image> getImagesLib() {
        return imagesLib;
    }

    public void setImagesLib(Set<Image> imagesLib) {
        this.imagesLib = imagesLib;
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
