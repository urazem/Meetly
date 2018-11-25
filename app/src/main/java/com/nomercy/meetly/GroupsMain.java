package com.nomercy.meetly;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class GroupsMain extends AppCompatActivity {
    private List<Groups> groupsList = new ArrayList<>();
    private RecyclerView recyclerView;
    private GroupsAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.my_groups);


        recyclerView = (RecyclerView) findViewById(R.id.recyclerGroups);

        mAdapter = new GroupsAdapter(groupsList);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(mAdapter);

        preparePlaceData();

        recyclerView.addOnItemTouchListener(new RecyclerTouchListener(getApplicationContext(), recyclerView, new RecyclerTouchListener.ClickListener() {
            @Override
            public void onClick(View view, int position) {
                Groups groups = groupsList.get(position);
                Toast.makeText(getApplicationContext(), groups.getgroupName() + " is selected!", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onLongClick(View view, int position) {

            }
        }));
    }



    private void preparePlaceData() {
        Groups groups = new Groups("Family", "img");
        groupsList.add(groups);
        groups = new Groups("Friend", "img");
        groupsList.add(groups);
        groups = new Groups("Work", "img");
        groupsList.add(groups);
    }
}