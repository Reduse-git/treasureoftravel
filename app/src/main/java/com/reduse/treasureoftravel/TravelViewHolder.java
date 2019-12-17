package com.reduse.treasureoftravel;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.reduse.treasureoftravel.model.Travel;

public class TravelViewHolder extends RecyclerView.ViewHolder {

    private TextView titleView;
    private Travel travel;
    private TravelListAdapter.ItemListener itemListener;

    public TravelViewHolder(@NonNull View itemView, TravelListAdapter.ItemListener itemListener) {
        super(itemView);

        titleView = itemView.findViewById(R.id.title);
    }
    public void bindTo(Travel travel) {
        this.travel = travel;

        titleView.setText(travel.getTitle());

    }
    public Travel getTravel() {
        return travel;
    }

}
