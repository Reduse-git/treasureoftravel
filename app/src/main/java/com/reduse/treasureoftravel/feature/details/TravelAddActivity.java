package com.reduse.treasureoftravel.feature.details;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.reduse.treasureoftravel.R;
import com.reduse.treasureoftravel.data.TravelStoreProvider;
import com.reduse.treasureoftravel.data.model.Travel;
import com.reduse.treasureoftravel.feature.list.TravelActivityList;

import java.util.Date;

public class TravelAddActivity extends AppCompatActivity {
    private EditText titleEditText;
    private EditText descriptionEditText;
    private Button saveButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_travel_add);

        titleEditText = findViewById(R.id.title_edit_text);
        descriptionEditText = findViewById(R.id.description_edit_text);
        saveButton = findViewById(R.id.save_button);

    }
    public void onClick(View view){


        TravelStoreProvider.getInstance(this).insert( createTravel());
        Intent intent = new Intent(this,TravelActivityList.class);
        startActivity(intent);
    }

    Travel createTravel(){
        Travel newTravel = new Travel();
        newTravel.setDate(new Date());
        newTravel.setTitle(titleEditText.getText().toString());
        newTravel.setDescription(descriptionEditText.getText().toString());
        return newTravel;
    }
}
