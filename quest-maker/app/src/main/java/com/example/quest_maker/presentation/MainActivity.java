package com.example.quest_maker.presentation;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.quest_maker.R;
import com.example.quest_maker.presentation.person_maker.PersonMakerActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);

        // загрузка интерфейса из activity_person_maker (xml)
        setContentView(R.layout.activity_main);

        Button buttonPersonMaker = findViewById(R.id.B_person_maker);




        buttonPersonMaker.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {
                // Обработка нажатия -> переход на activity_person_maker (xml)
                //Intent intent = new Intent(MainActivity.this, PersonMakerActivity.class);
                Intent intent = new Intent(MainActivity.this, PersonMakerActivity.class);
                startActivity(intent);
            }
        });

    }
}
