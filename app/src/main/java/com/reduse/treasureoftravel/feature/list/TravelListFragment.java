package com.reduse.treasureoftravel.feature.list;

import android.content.Intent;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.snackbar.Snackbar;
import com.reduse.treasureoftravel.R;
import com.reduse.treasureoftravel.feature.details.TravelActivity;
import com.reduse.treasureoftravel.feature.details.TravelAddActivity;
import com.reduse.treasureoftravel.feature.list.adapter.ItemTouchHelperAdapter;
import com.reduse.treasureoftravel.feature.list.adapter.TravelListAdapter;
import com.reduse.treasureoftravel.feature.list.adapter.TravelViewHolder;
import com.reduse.treasureoftravel.model.Travel;
import com.reduse.treasureoftravel.model.TravelStore;

public class TravelListFragment extends Fragment {

    private boolean mOrderChanged;
    private RecyclerView recyclerView;
    private TravelListAdapter adapter;
    public static final float ALPHA_FULL = 1.0f;

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
    private Drawable deleteDrawable;
    private int intrinsicWidth;
    private int intrinsicHeight;
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        adapter = new TravelListAdapter(TravelStore.getInstance().getTravels(), itemListener);

        recyclerView.setAdapter(adapter);

        /*ItemTouchHelper touchHelper = new ItemTouchHelper(
                new ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT) {
                    @Override
                    public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
                        return false;
                    }

                    @Override
                    public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {
                        TravelViewHolder travelViewHolder = (TravelViewHolder) viewHolder;
                        Travel travel = travelViewHolder.getTravel();
                        deleteItem(travel, viewHolder.getAdapterPosition());
                    }
                });*/
        ItemTouchHelper touchHelper = new ItemTouchHelper(new ItemTouchHelper.Callback() {


            @Override
            public int getMovementFlags(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder) {
               /* int dragFlags = ItemTouchHelper.UP | ItemTouchHelper.DOWN;
                int swipeFlags = ItemTouchHelper.START | ItemTouchHelper.END;*/
                return makeMovementFlags(ItemTouchHelper.ACTION_STATE_IDLE, ItemTouchHelper.END);
            }

            @Override
            public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
                /*adapter.onItemMove(viewHolder.getAdapterPosition(),
                        target.getAdapterPosition());*/
                mOrderChanged = true;
                return true;
            }

            @Override
            public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {
                TravelViewHolder travelViewHolder = (TravelViewHolder) viewHolder;
                Travel travel = travelViewHolder.getTravel();
                deleteItem(travel, viewHolder.getAdapterPosition());
            }

            @Override
            public void onChildDrawOver(@NonNull Canvas c, @NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, float dX, float dY, int actionState, boolean isCurrentlyActive) {
                if (actionState == ItemTouchHelper.ACTION_STATE_SWIPE) {

                    final float alpha = ALPHA_FULL - Math.abs(dX) / (float) viewHolder.itemView.getWidth();
                    viewHolder.itemView.setAlpha(alpha);
                    viewHolder.itemView.setTranslationX(dX);
                    mOrderChanged = true;
                    int dx = (int) dX;

                    final ColorDrawable background = new ColorDrawable(Color.RED);
                    background.setBounds(0, viewHolder.itemView.getTop(), viewHolder.itemView.getLeft() + dx, viewHolder.itemView.getBottom());

                    background.draw(c);
                    deleteDrawable = ContextCompat.getDrawable(recyclerView.getContext(), R.drawable.my_icon);
                    intrinsicWidth = deleteDrawable.getIntrinsicWidth();
                    intrinsicHeight = deleteDrawable.getIntrinsicHeight();

                    int deleteIconTop = viewHolder.itemView.getTop() + (viewHolder.itemView.getHeight() - intrinsicHeight) / 2;
                    int deleteIconMargin = (viewHolder.itemView.getHeight() - intrinsicHeight) / 2;
                    int deleteIconLeft = 0;
                    int deleteIconRight = viewHolder.itemView.getRight() + deleteIconMargin - viewHolder.itemView.getWidth();
                    int deleteIconBottom = deleteIconTop + intrinsicHeight;


                    deleteDrawable.setBounds(deleteIconLeft, deleteIconTop, deleteIconRight, deleteIconBottom);
                    deleteDrawable.draw(c);


                } else {
                    super.onChildDraw(c, recyclerView, viewHolder, dX, dY, actionState, isCurrentlyActive);
                }
            }

            @Override
            public boolean isLongPressDragEnabled() {
                return true;
            }

            @Override
            public boolean isItemViewSwipeEnabled() {
                return true;
            }
        });

        touchHelper.attachToRecyclerView(recyclerView);
    }



    private void deleteItem(final Travel travel, final int position) {
        TravelStore.getInstance().deleteTravel(travel);
        Snackbar.make(recyclerView, R.string.snackbar_message, Snackbar.LENGTH_LONG)
                .setAction(R.string.snackbar_action, new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        TravelStore.getInstance().resurrectTravel(travel, position);
                    }
                })
                .show();
    }

    @Override
    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {
        inflater.inflate(R.menu.travel_menu, menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.add) {
            TravelStore.getInstance().generateRandomTravel();
           /* Intent intent = TravelAddActivity.makeIntent(getContext());
            startActivity(intent);*/
            return true;
        } else {
            return super.onOptionsItemSelected(item);
        }
    }

    private final TravelStore.Listener travelListChangedListener = new TravelStore.Listener() {
        @Override
        public void onTravelListChanged() {
            adapter.notifyDataSetChanged();
        }
    };

    @Override
    public void onResume() {
        super.onResume();
        TravelStore.getInstance().addListener(travelListChangedListener);
        adapter.notifyDataSetChanged();
    }

    @Override
    public void onPause() {
        TravelStore.getInstance().removeListener(travelListChangedListener);
        super.onPause();
    }


    private final TravelListAdapter.ItemListener itemListener = new TravelListAdapter.ItemListener() {
        @Override
        public void onCrimeClicked(Travel travel) {
            Intent intent = TravelActivity.makeIntent(getContext(), travel.getId());
            startActivity(intent);
        }

        @Override
        public void onCrimeLongClicked(Travel travel) {

        }
    };
}
