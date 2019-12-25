package com.reduse.treasureoftravel.feature.list.adapter;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.reduse.treasureoftravel.R;

import com.reduse.treasureoftravel.data.model.Travel;

public class TravelViewHolder extends RecyclerView.ViewHolder {

    private TextView titleView;
    private Travel travel;
    private TravelListAdapter.ItemListener itemListener;

    private final View.OnClickListener clickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            itemListener.onTravelClicked(travel);
        }
    };

    public TravelViewHolder(@NonNull View itemView, TravelListAdapter.ItemListener itemListener) {
        super(itemView);

        titleView = itemView.findViewById(R.id.title);

        itemView.setOnClickListener(clickListener);

        this.itemListener = itemListener;
    }

    public void bindTo(Travel travel) {
        this.travel = travel;

        titleView.setText(travel.getTitle());

    }

    public Travel getTravel() {
        return travel;
    }

}
