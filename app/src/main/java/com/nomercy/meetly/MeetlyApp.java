package com.nomercy.meetly;

import android.support.constraint.ConstraintLayout;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;

public class MeetlyApp extends AppCompatActivity implements AuthorizationFragment.onSomeEventListener {

    // Инициализация переменных и объектов:
    FrameLayout frameHead, frameBody;
    RecyclerView feed;
    ConstraintLayout registrationAccountScreen;
    Button button4;

    Adapter adapter;
    LinearLayoutManager manager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meetly_app);

        // Определение переменных и объектов:
        frameHead = findViewById(R.id.frameHead);
        frameBody = findViewById(R.id.frameBody);
        registrationAccountScreen = findViewById(R.id.registrationAccountScreen);
        feed = findViewById(R.id.feed);
        button4 = findViewById(R.id.button4);

        authorization();

        addListenerOnButton();


    }

    // Сканер косаний:
    public void addListenerOnButton() {
        button4.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        registrationAccountScreen.setVisibility(View.GONE);

                        ContactsFragment contactsFragment = new ContactsFragment();
                        FragmentManager fragmentManager1 = getSupportFragmentManager();
                        fragmentManager1.beginTransaction()
                                .replace(R.id.frameBody, contactsFragment)
                                .commit();
                        frameBody.setVisibility(View.VISIBLE);
                    }
                }
        );
    }


    // Fragment listener:
    @Override
    public void someEvent(String s) {
        switch(s) {
            case "toMain":
                // Переход к главному экрану:
                frameBody.setVisibility(View.GONE);
                frameHead.setVisibility(View.VISIBLE);

                HeadFragment headFragment = new HeadFragment();
                FragmentManager fragmentManager = getSupportFragmentManager();
                fragmentManager.beginTransaction()
                        .add(R.id.frameHead, headFragment)
                        .commit();

                feed();
                break;

            case "toNewMeeting":
                // Переход к созданию встречи:
                registrationAccountScreen.setVisibility(View.GONE);


                NewMeetingFragment newMeetingFragment = new NewMeetingFragment();
                FragmentManager fragmentManager1 = getSupportFragmentManager();
                fragmentManager1.beginTransaction()
                        .replace(R.id.frameBody, newMeetingFragment)
                        .commit();
                frameBody.setVisibility(View.VISIBLE);
                break;

            case "backToMain":
                frameBody.setVisibility(View.GONE);
                registrationAccountScreen.setVisibility(View.VISIBLE);
        }
    }


    // Переход к авторизации:
    void authorization() {
        frameBody.setVisibility(View.VISIBLE);
        AuthorizationFragment authorizationFragment = new AuthorizationFragment();
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction()
                .add(R.id.frameBody, authorizationFragment)
                .commit();
    }


    // Переход к главному экрану:
    void feed() {
        registrationAccountScreen.setVisibility(View.VISIBLE);
        manager = new LinearLayoutManager(this);

        final String[] a = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "12", "14", "15", "16", "17"};
        final ArrayList<String> list = new ArrayList<>(Arrays.asList(a));

        adapter = new Adapter(list, this);
        feed.setAdapter(adapter);
        feed.setLayoutManager(manager);

        adapter.setOnItemClickListener(new Adapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                String name = list.get(position);
                Toast.makeText(MeetlyApp.this, name + " was clicked!", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
