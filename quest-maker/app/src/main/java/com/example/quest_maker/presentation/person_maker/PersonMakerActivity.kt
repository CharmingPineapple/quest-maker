package com.example.quest_maker.presentation.person_maker

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.localbroadcastmanager.content.LocalBroadcastManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.quest_maker.R
import com.example.quest_maker.viewModel.PersonMakerViewModel
import com.example.quest_maker.viewModel.PersonMakerViewModelFactory

class PersonMakerActivity : AppCompatActivity() {

    private lateinit var viewModel: PersonMakerViewModel

    private var characteristicsRV: RecyclerView? = null
    private var characteristicsRVAdapter: CharacteristicsRVAdapter? = null
    private var remainScoreText: TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // загрузка интерфейса из activity_person_maker_rv (xml)
        setContentView(R.layout.activity_person_maker_rv)

        remainScoreText = findViewById(R.id.TV_remain_score)

        viewModel = ViewModelProvider(this, PersonMakerViewModelFactory(this))
            .get(PersonMakerViewModel::class.java)


        characteristicsRV = findViewById(R.id.RV_characteristic_list)
        characteristicsRVAdapter = CharacteristicsRVAdapter(this)

        // TODO("
        //  Будет "Осталось очков", так что кажется тут понадобится diffUtils
        //  mvvm или mvi, я пока что не понимаю
        //  ")

        /*viewModel.stateLive.observe(this) { state ->
            characteristicsRVAdapter!!.setList(state.characteristicList)
        }*/
        //characteristicsRVAdapter!!.setList()

        viewModel.send(LoadEvent())
        characteristicsRVAdapter!!.setCharacteristic(viewModel.stateDataMutable!!.characteristicList)

        characteristicsRV!!.adapter = characteristicsRVAdapter
        characteristicsRV!!.layoutManager = LinearLayoutManager(applicationContext, LinearLayoutManager.VERTICAL, false)

        // (#)
        LocalBroadcastManager.getInstance(this).registerReceiver(mMessageReceiver, IntentFilter("remain-characteristic-score"))

    }

    override fun onResume() {
        viewModel.send(LoadEvent())

        super.onResume()
    }

    override fun onPause(){
        viewModel.send(SaveEvent(characteristicsRVAdapter!!.getList()))

        super.onPause()
    }

    // (#)
    var mMessageReceiver: BroadcastReceiver = object : BroadcastReceiver() {
        override fun onReceive(context: Context?, intent: Intent) {
            // Get extra data included in the Intent
            val ItemName: String? = intent.getStringExtra("remain-characteristic-score-name")
            //val qty: String? = intent.getStringExtra("quantity")
            remainScoreText?.setText("Осталось очков: $ItemName")
        }
    }

}