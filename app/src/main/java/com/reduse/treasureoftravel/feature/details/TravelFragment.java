package com.reduse.treasureoftravel.feature.details;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.reduse.treasureoftravel.R;
import com.reduse.treasureoftravel.model.Travel;
import com.reduse.treasureoftravel.model.TravelStore;

import java.util.UUID;

public class TravelFragment extends Fragment {

    private static final String KEY_TRAVEL_ID = "key_crime_id";

    //model
    private Travel travel;


    private EditText titleEditText;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        UUID id = (UUID) getArguments().getSerializable(KEY_TRAVEL_ID);
        travel = TravelStore.getInstance().getById(id);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_travel, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        titleEditText = view.findViewById(R.id.crime_title);

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        titleEditText.setText(travel.getTitle());


        titleEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                travel.setTitle(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }

    public static TravelFragment makeInstance(UUID id) {
        TravelFragment fragment = new TravelFragment();
        Bundle args = new Bundle();
        args.putSerializable(KEY_TRAVEL_ID, id);
        fragment.setArguments(args);
        return fragment;
    }
}
