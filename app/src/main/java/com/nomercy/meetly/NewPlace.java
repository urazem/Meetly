package com.nomercy.meetly;

import android.graphics.Movie;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class NewPlace extends AppCompatActivity {
    private List<Place> placeList = new ArrayList<>();
    private RecyclerView recyclerView;
    private PlaceAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meetly_app);


        recyclerView = (RecyclerView) findViewById(R.id.feed);

        mAdapter = new PlaceAdapter(placeList);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(mAdapter);

        preparePlaceData();

        recyclerView.addOnItemTouchListener(new RecyclerTouchListener(getApplicationContext(), recyclerView, new RecyclerTouchListener.ClickListener() {
            @Override
            public void onClick(View view, int position) {
                Place place = placeList.get(position);
                Toast.makeText(getApplicationContext(), place.getPlaceName() + " is selected!", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onLongClick(View view, int position) {

            }
        }));
    }



    private void preparePlaceData() {
        Place place = new Place("Lounge Cafe", "Grand Voyage, Simpheropol, Kirova 29", "2015");
        placeList.add(place);
        place = new Place("Marry Barry", "Action & Adventure", "2015");
        placeList.add(place);
        place = new Place("Bistro", "Relaxed atmosphere", "2015");
        placeList.add(place);
        place = new Place("Mad Max: Fury Road", "Action & Adventure", "2015");
        placeList.add(place);
    }
}