package com.reduse.treasureoftravel.feature.details;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.reduse.treasureoftravel.R;

import java.util.UUID;

public class TravelActivity extends AppCompatActivity {
    private static final String KEY_ID = "key_id";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);


        FragmentManager fragmentManager = getSupportFragmentManager();

        if (fragmentManager.findFragmentById(R.id.fragment_container) == null) {
            UUID travelId = (UUID) getIntent().getSerializableExtra(KEY_ID);

            fragmentManager.beginTransaction()
                    .replace(R.id.fragment_container, TravelFragment.makeInstance(travelId))
                    .commit();
        }
    }

    public static Intent makeIntent(Context context, UUID travelId) {
        Intent intent = new Intent(context, TravelActivity.class);
        intent.putExtra(KEY_ID, travelId);
        return intent;
    }
}
