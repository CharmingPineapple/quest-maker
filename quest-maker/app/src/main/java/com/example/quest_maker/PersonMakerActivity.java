package com.example.quest_maker;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class PersonMakerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);

        // загрузка интерфейса из activity_person_maker (xml)
        setContentView(R.layout.activity_person_maker);
    }

}
