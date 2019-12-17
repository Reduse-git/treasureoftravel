package com.reduse.treasureoftravel.feature.list;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;


import android.os.Bundle;

import com.reduse.treasureoftravel.R;
import com.reduse.treasureoftravel.feature.list.TravelListFragment;


public class TravelActivityList extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        FragmentManager fragmentManager = getSupportFragmentManager();

        if (fragmentManager.findFragmentById(R.id.fragment_container) == null) {
            fragmentManager.beginTransaction()
                    .replace(R.id.fragment_container, new TravelListFragment())
                    .commit();
        }
    }
}
