package com.reduse.treasureoftravel.data;

import com.reduse.treasureoftravel.data.model.Travel;

import java.util.HashSet;

import java.util.Random;
import java.util.Set;


public abstract class BaseTravelStore implements TravelStore {

    private final Set<Listener> listenerSet = new HashSet<>();

    protected final void notifyListeners() {
        for (Listener listener : listenerSet) {
            listener.onTravelListChanged();
        }
    }

    @Override
    public void removeListener(Listener listener) {
        listenerSet.remove(listener);
    }

    @Override
    public void addListener(Listener listener) {
        listenerSet.add(listener);
    }
    protected static Travel makeRandomTravel() {
        Random random = new Random();
        Travel travel = new Travel();
        travel.setTitle("Travel #" + random.nextInt());
        return travel;
    }



    @Override
    public void update(Travel travel) {
        //TODO implement
    }
}
