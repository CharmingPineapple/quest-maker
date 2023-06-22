package com.example.quest_maker.presentation;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.quest_maker.R;
import com.example.quest_maker.data.repository.AuthorRepositoryImplementation;
import com.example.quest_maker.domain.models.Characteristic;
import com.example.quest_maker.domain.models.SaveCharacteristicParam;
import com.example.quest_maker.domain.repository.AuthorRepositoryInterface;
import com.example.quest_maker.domain.usecase.GetCharacteristicUseCase;
import com.example.quest_maker.domain.usecase.SaveCharacteristicUseCase;

public class PersonMakerActivity extends AppCompatActivity {

    //private AuthorRepositoryInterface authorRepositoryInterface = new AuthorRepositoryImplementation(getApplicationContext());
    private AuthorRepositoryInterface authorRepositoryInterface = new AuthorRepositoryImplementation(this);
    private GetCharacteristicUseCase getCharacteristicUseCase = new GetCharacteristicUseCase(authorRepositoryInterface);
    private SaveCharacteristicUseCase saveCharacteristicUseCase = new SaveCharacteristicUseCase(authorRepositoryInterface);

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);

        // загрузка интерфейса из activity_person_maker (xml)
        setContentView(R.layout.activity_person_maker);

        TextView TV_STR = findViewById(R.id.TV_STR_maker);
        TextView TV_DEX = findViewById(R.id.TV_DEX_maker);
        TextView TV_PER = findViewById(R.id.TV_PER_maker);
        TextView TV_KNW = findViewById(R.id.TV_KNW_maker);
        TextView TV_CHR = findViewById(R.id.TV_CHR_maker);
        TextView TV_LCK = findViewById(R.id.TV_LCK_maker);

        EditText ET_STR = findViewById(R.id.ET_STR_maker);
        EditText ET_DEX = findViewById(R.id.ET_DEX_maker);
        EditText ET_PER = findViewById(R.id.ET_PER_maker);
        EditText ET_KNW = findViewById(R.id.ET_KNW_maker);
        EditText ET_CHR = findViewById(R.id.ET_CHR_maker);
        EditText ET_LCK = findViewById(R.id.ET_LCK_maker);

        Button B_save_characteristics = findViewById(R.id.B_save_characteristics);
        Button B_update_characteristics = findViewById(R.id.B_update_characteristics);

        B_save_characteristics.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                // (#) - потом исправить на массив

                String dest = TV_STR.getText().toString();
                int value = Integer.parseInt(ET_STR.getText().toString());
                SaveCharacteristicParam saveCharacteristicParam = new SaveCharacteristicParam(dest, value);

                saveCharacteristicUseCase.execute(saveCharacteristicParam);

            }
        });

        B_update_characteristics.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                // (#) - потом исправить на массив

                String name = TV_STR.getText().toString();
                Characteristic characteristic = new Characteristic(name);

                short value;

                value = getCharacteristicUseCase.execute(characteristic);
                ET_STR.setText(value);

            }
        });

    }

}
