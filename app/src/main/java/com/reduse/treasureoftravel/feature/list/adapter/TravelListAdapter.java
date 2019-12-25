package com.reduse.treasureoftravel.feature.list.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.reduse.treasureoftravel.R;
import com.reduse.treasureoftravel.data.model.Travel;

import java.util.List;

public class TravelListAdapter extends RecyclerView.Adapter<TravelViewHolder> {

    private List<Travel> travels;
    private ItemListener itemListener;

    public TravelListAdapter(List<Travel> travels, ItemListener itemListener) {
        this.travels = travels;
        this.itemListener = itemListener;

        setHasStableIds(true);
    }

    @Override
    public long getItemId(int position) {
        return travels.get(position).hashCode();
    }

    @NonNull
    @Override
    public TravelViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View itemView = inflater.inflate(R.layout.item_travel, parent, false);

        return new TravelViewHolder(itemView, itemListener);
    }

    @Override
    public void onBindViewHolder(@NonNull TravelViewHolder holder, int position) {
        Travel crime =  travels.get(position);
        holder.bindTo(crime);
    }

    @Override
    public int getItemCount() {
        return travels.size();
    }

    public void submitList(List<Travel> newList) {
        this.travels = newList;
        notifyDataSetChanged();
    }
    public interface ItemListener {
        void onTravelClicked(Travel travel);

        void onCrimeLongClicked(Travel travel);
    }


}
