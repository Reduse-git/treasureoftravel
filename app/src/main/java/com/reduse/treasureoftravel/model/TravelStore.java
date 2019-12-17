package com.reduse.treasureoftravel.model;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class TravelStore {

    // Singleton
    private static TravelStore instance;

    private TravelStore() {
    }

    public static TravelStore getInstance() {
        if (instance == null) {
            instance = new TravelStore();
        }
        return instance;
    }

    // End of Singleton
    private List<Travel> travels = new ArrayList<>();

    public List<Travel> getTravels() {
        return travels;
    }
    public Travel getById(UUID id) {
        for (Travel travel : travels) {
            if (travel.getId().equals(id)) {
                return travel;
            }
        }
        return null;
    }



}


