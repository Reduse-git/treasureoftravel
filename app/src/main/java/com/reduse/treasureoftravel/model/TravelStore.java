package com.reduse.treasureoftravel.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;
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

    public void generateRandomTravel() {
        Random random = new Random();

        Travel crime = new Travel();

        crime.setTitle("Travel #" + random.nextInt());


        travels.add(crime);
        notifyListeners();
    }
    private void notifyListeners() {
        for (Listener listener : listenersSet) {
            listener.onTravelListChanged();
        }
    }
    private final Set<Listener> listenersSet = new HashSet<>();

    public void addListener(Listener listener) {
        listenersSet.add(listener);
    }

    public void removeListener(Listener listener) {
        listenersSet.remove(listener);
    }

    public interface Listener {
        void onTravelListChanged();
    }

}


