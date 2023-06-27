package com.example.quest_maker.presentation.person_maker

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.domain.models.CharacteristicList
import com.example.domain.usecase.GetCharacteristicUseCase
import com.example.quest_maker.R
import com.example.quest_maker.viewModel.PersonMakerViewModel
import com.example.quest_maker.viewModel.PersonMakerViewModelFactory

class PersonMakerActivityKT : AppCompatActivity() {

    private lateinit var viewModel: PersonMakerViewModel

    private var characteristicsRV: RecyclerView? = null
    private var characteristicsRVAdapter: CharacteristicsRVAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // загрузка интерфейса из activity_person_maker_rv (xml)
        setContentView(R.layout.activity_person_maker_rv)

        viewModel = ViewModelProvider(this, PersonMakerViewModelFactory(this))
            .get(PersonMakerViewModel::class.java)

        // (#)
        /*var list_test: LiveData<CharacteristicList> = viewModel.getCharacteristicList()
        val list_test_val = viewModel.getCharacteristicUseCase.all*/

        characteristicsRV = findViewById(R.id.RV_characteristic_list)

        viewModel.getCharacteristicListLive().observe(this, { list ->
            characteristicsRVAdapter = CharacteristicsRVAdapter(this, list)
        })


        //characteristicsRVAdapter = CharacteristicsRVAdapter(this, list_test_val)
        // (?) - почему тут "!!"
        characteristicsRV!!.adapter = characteristicsRVAdapter
        characteristicsRV!!.layoutManager = LinearLayoutManager(applicationContext, LinearLayoutManager.VERTICAL, false)



    }

}