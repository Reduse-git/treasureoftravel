package com.reduse.treasureoftravel.data.room;

import com.reduse.treasureoftravel.data.model.Travel;

import java.util.Date;
import java.util.UUID;

class Converter {
    static Travel convert(TravelEntity entity){
        Travel travel = new Travel();
        travel.setId(UUID.fromString(entity.id));
        travel.setTitle(entity.title);
        travel.setDescription(entity.description);
        travel.setDate(new Date(entity.date));
        //travel.setImagesLib(entity.imagesLib);

        return travel;
    }

    static TravelEntity convert(Travel travel){
        TravelEntity travelEntity = new TravelEntity();
        travelEntity.id  = travel.getId().toString();
        travelEntity.title = travel.getTitle();
        travelEntity.description = travel.getDescription();
        travelEntity.date =travel.getDate().getTime();
       // travelEntity.imagesLib = travel.getImagesLib();
        return travelEntity;
    }

}
