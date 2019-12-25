package com.reduse.treasureoftravel.data.room;




import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;




@Entity
public class TravelEntity {
    @PrimaryKey
    @NonNull
    public String id;
    public String title;
   // public Set<Image> imagesLib;
    public long date;
    public String description;
}
