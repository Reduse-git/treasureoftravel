package com.reduse.treasureoftravel;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.reduse.treasureoftravel.model.Travel;
import com.reduse.treasureoftravel.model.TravelStore;

public class TravelListFragment extends Fragment {

    private RecyclerView recyclerView;
    private TravelListAdapter adapter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.travel_list_fragment, container, false);
    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        recyclerView = view.findViewById(R.id.recycler);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        adapter = new TravelListAdapter(TravelStore.getInstance().getTravels(),itemListener);
    }

    private final TravelListAdapter.ItemListener itemListener = new TravelListAdapter.ItemListener() {
        @Override
        public void onCrimeClicked(Travel travel) {

        }

        @Override
        public void onCrimeLongClicked(Travel travel) {

        }
    };
}
