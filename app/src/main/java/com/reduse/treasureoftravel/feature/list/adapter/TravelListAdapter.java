package com.reduse.treasureoftravel.feature.list.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.reduse.treasureoftravel.R;
import com.reduse.treasureoftravel.model.Travel;

import java.util.Collections;
import java.util.List;

public class TravelListAdapter extends RecyclerView.Adapter<TravelViewHolder> implements ItemTouchHelperAdapter{

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


    public interface ItemListener {
        void onCrimeClicked(Travel travel);

        void onCrimeLongClicked(Travel travel);
    }
    @Override
    public void onItemDismiss(int position) {
       travels.remove(position);
        notifyItemRemoved(position);
    }

    @Override
    public void onItemMove(int fromPosition, int toPosition) {
        if (fromPosition < toPosition) {
            for (int i = fromPosition; i < toPosition; i++) {
                Collections.swap(travels, i, i + 1);
            }
        } else {
            for (int i = fromPosition; i > toPosition; i--) {
                Collections.swap(travels, i, i - 1);
            }
        }
        notifyItemMoved(fromPosition, toPosition);

    }

}
