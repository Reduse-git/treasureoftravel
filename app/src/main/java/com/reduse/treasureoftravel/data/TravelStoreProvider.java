package com.reduse.treasureoftravel.data;

import android.content.Context;

import com.reduse.treasureoftravel.data.room.RoomTravelStore;

public class TravelStoreProvider {
    private static TravelStore instance;

    private TravelStoreProvider() {

    }
    public  static  TravelStore getInstance(Context context){
        if(instance == null){
            instance = new RoomTravelStore(context);
        }
        return instance;
    }
}
