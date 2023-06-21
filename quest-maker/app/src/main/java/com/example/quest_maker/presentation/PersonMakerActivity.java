package com.example.quest_maker.presentation;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.quest_maker.R;

public class PersonMakerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);

        // загрузка интерфейса из activity_person_maker (xml)
        setContentView(R.layout.activity_person_maker);
    }

}
