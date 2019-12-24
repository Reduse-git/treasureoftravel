package com.reduse.treasureoftravel.feature.details;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import com.reduse.treasureoftravel.R;

import java.util.UUID;

public class TravelAddActivity  extends AppCompatActivity {
    private static final String KEY_ID = "key_id";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_list);


    }

    public static Intent makeIntent(Context context) {
        Intent intent = new Intent(context, TravelActivity.class);
        return intent;
    }
}
