package com.reduse.treasureoftravel.data.room;

import androidx.room.Database;
import androidx.room.RoomDatabase;
@Database(
        entities = {TravelEntity.class},
        version = 1,
        exportSchema = false
)
public abstract class TravelDatabase extends RoomDatabase {
    public abstract TravelDao travelDao();
}
