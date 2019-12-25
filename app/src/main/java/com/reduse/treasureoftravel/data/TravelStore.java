package com.reduse.treasureoftravel.data;

import com.reduse.treasureoftravel.data.model.Travel;

import java.util.List;
import java.util.UUID;

public interface TravelStore {
    List<Travel> getTravel();

    Travel getById(UUID id);

    void generateRandomTravel();

    void deleteTravel(Travel travel);

    void deleteTravel(UUID id);

    void resurrectTravel(Travel travel, int position);

    void update(Travel travel);

    void addListener(Listener listener);

    void removeListener(Listener listener);

    interface Listener {
        void onTravelListChanged();
    }
}