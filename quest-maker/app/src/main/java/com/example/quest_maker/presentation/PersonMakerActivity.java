package com.example.quest_maker.presentation;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.quest_maker.R;
import com.example.data.repository.AuthorRepositoryImplementation;
import com.example.data.storage.database.DatabaseAuthorStorageImplementation;
import com.example.domain.models.Characteristic;
import com.example.domain.repository.AuthorRepositoryInterface;
import com.example.domain.usecase.GetCharacteristicUseCase;
import com.example.domain.usecase.SaveCharacteristicUseCase;
import com.example.quest_maker.viewModel.PersonMakerViewModel;

import java.util.List;

public class PersonMakerActivity extends AppCompatActivity {

    //private AuthorRepositoryInterface authorRepositoryInterface = new AuthorRepositoryImplementation(getApplicationContext());


    // (!) - Разобраться с context
    private DatabaseAuthorStorageImplementation databaseAuthorStorageImplementation = new DatabaseAuthorStorageImplementation(this);
    private AuthorRepositoryInterface authorRepositoryInterface = new AuthorRepositoryImplementation(databaseAuthorStorageImplementation);
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

        // (#)
        TextView TV_check_characteristics= findViewById(R.id.TV_test_check_all_characteristics);

        EditText ET_STR = findViewById(R.id.ET_STR_maker);
        EditText ET_DEX = findViewById(R.id.ET_DEX_maker);
        EditText ET_PER = findViewById(R.id.ET_PER_maker);
        EditText ET_KNW = findViewById(R.id.ET_KNW_maker);
        EditText ET_CHR = findViewById(R.id.ET_CHR_maker);
        EditText ET_LCK = findViewById(R.id.ET_LCK_maker);

        Button B_save_characteristics = findViewById(R.id.B_save_characteristics);
        Button B_update_characteristics = findViewById(R.id.B_update_characteristics);

        // (#)
        Button B_check_characteristics = findViewById(R.id.B_test_check_all_characteristics);

        //ViewModel vm = new PersonMakerViewModel();
        // (?) - this.  AppCompatActivity вроде бы всё решает и всё окей
       /* PersonMakerViewModel vm = new ViewModelProvider(this).get(PersonMakerViewModel.class);
        vm.getCharacteristicLive().observe(this, Observer{
            TV_LCK.setText();
        });*/

        B_save_characteristics.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                // (#) - потом исправить на массив

                String dest = TV_STR.getText().toString();
                String value = ET_STR.getText().toString();

                // (#)
                //String stringValue = ET_STR.getText().toString();
                //int value = (int) Integer.parseInt(stringValue);

                Characteristic characteristic = new Characteristic(dest, value);

                TV_DEX.setText(dest);
                TV_PER.setText(value);

                // (#)
                //TV_STR.setText(Integer.toString(value));

                saveCharacteristicUseCase.execute(characteristic);

                TV_KNW.setText(getCharacteristicUseCase.execute(characteristic));

            }
        });

        B_update_characteristics.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                // (#) - потом исправить на массив

                String name = TV_STR.getText().toString();
                Characteristic characteristic = new Characteristic(name);

                ET_STR.setText(getCharacteristicUseCase.execute(characteristic));

            }
        });

        // (#)
        /*B_check_characteristics.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {

                List<Characteristic> list = getCharacteristicUseCase.getAll();

                String string;
                String allString = "";

                for (Characteristic one : list){
                    string = one.name + one.value;
                    allString = allString + "; " + string;
                }

                TV_check_characteristics.setText(allString);

            }
        });*/

    }

}
