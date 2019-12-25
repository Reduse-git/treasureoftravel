package com.reduse.treasureoftravel.data.room;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;


@Dao
public interface TravelDao {

    @Query("SELECT * FROM TravelEntity")
    List<TravelEntity> getAllTravel();

    @Query("SELECT * FROM TravelEntity WHERE id == :idParam")
    TravelEntity getTravelById(String idParam);

    @Insert
    void add(TravelEntity travelEntity);

    @Delete
    void delete(TravelEntity travelEntity);

    @Update
    void update(TravelEntity travelEntity);

}
