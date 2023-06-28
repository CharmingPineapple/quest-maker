package com.example.quest_maker.presentation.person_maker

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.quest_maker.R
import com.example.quest_maker.viewModel.PersonMakerViewModel
import com.example.quest_maker.viewModel.PersonMakerViewModelFactory

class PersonMakerActivity : AppCompatActivity() {

    private lateinit var viewModel: PersonMakerViewModel

    private var characteristicsRV: RecyclerView? = null
    private var characteristicsRVAdapter: CharacteristicsRVAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // загрузка интерфейса из activity_person_maker_rv (xml)
        setContentView(R.layout.activity_person_maker_rv)

        viewModel = ViewModelProvider(this, PersonMakerViewModelFactory(this))
            .get(PersonMakerViewModel::class.java)


        characteristicsRV = findViewById(R.id.RV_characteristic_list)

        viewModel.load()

        characteristicsRVAdapter = CharacteristicsRVAdapter(this)
        viewModel.characteristicListLive.observe(this) {list ->
            characteristicsRVAdapter!!.setList(list)
        }

        characteristicsRV!!.adapter = characteristicsRVAdapter
        characteristicsRV!!.layoutManager = LinearLayoutManager(applicationContext, LinearLayoutManager.VERTICAL, false)



    }

}