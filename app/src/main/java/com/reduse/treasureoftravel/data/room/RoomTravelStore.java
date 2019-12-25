package com.reduse.treasureoftravel.data.room;

import android.content.Context;

import androidx.room.Room;

import com.reduse.treasureoftravel.data.BaseTravelStore;
import com.reduse.treasureoftravel.data.model.Travel;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class RoomTravelStore extends BaseTravelStore {

    private TravelDao travelDao;

    public RoomTravelStore(Context context) {
        travelDao = Room.databaseBuilder(
                context,
                TravelDatabase.class,
                "travel-database.sqlite")
                .allowMainThreadQueries()
                .build()
                .travelDao();
    }

    @Override
    public List<Travel> getTravel(){
        List<TravelEntity> travelEntityList = travelDao.getAllTravel();

        List<Travel> resultList = new ArrayList<>();

        for(TravelEntity travelEntity: travelEntityList){
            resultList.add(Converter.convert(travelEntity));
        }
        return resultList;
    }

    @Override
    public Travel getById(UUID id) {
        TravelEntity travelEntity = travelDao.getTravelById(id.toString());

        return Converter.convert(travelEntity);
    }

    @Override
    public void generateRandomTravel() {
        Travel travel = makeRandomTravel();
        travelDao.add(Converter.convert(travel));
        notifyListeners();
    }

    @Override
    public void deleteTravel(Travel travel) {
        travelDao.delete(Converter.convert(travel));
        notifyListeners();
    }

    @Override
    public void deleteTravel(UUID id) {
        TravelEntity entityToDelete = new TravelEntity();
        entityToDelete.id =id.toString();
        travelDao.delete(entityToDelete);
        notifyListeners();
    }

    @Override
    public void resurrectTravel(Travel travel, int position) {
        travelDao.add(Converter.convert(travel));
        notifyListeners();
    }

    @Override
    public void update(Travel travel){
        travelDao.update(Converter.convert(travel));
        notifyListeners();
    }
}
