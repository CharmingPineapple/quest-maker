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

    private var skillRV: RecyclerView? = null
    private var skillRVAdapter: SkillRVAdapter? = null
    private var limitScoreText: TextView? = null
    private var currentScoreText: TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // загрузка интерфейса из activity_person_maker_rv (xml)
        setContentView(R.layout.activity_person_maker_rv)

        limitScoreText = findViewById(R.id.TV_limit_score)
        currentScoreText = findViewById(R.id.TV_current_score)

        viewModel = ViewModelProvider(this, PersonMakerViewModelFactory(this))
            .get(PersonMakerViewModel::class.java)


        skillRV = findViewById(R.id.RV_skill_list)
        skillRVAdapter = SkillRVAdapter(this)

        // TODO("
        //  Будет "Осталось очков", так что кажется тут понадобится diffUtils
        //  mvvm или mvi, я пока что не понимаю
        //  ")

        viewModel.send(LoadEvent())
        skillRVAdapter!!.setData(viewModel.stateDataMutable!!.skillList, viewModel.stateDataMutable!!.maxSkillScore, viewModel.stateDataMutable!!.minSkillScore)
        skillRV!!.adapter = skillRVAdapter
        skillRV!!.layoutManager = LinearLayoutManager(applicationContext, LinearLayoutManager.VERTICAL, false)

        limitScoreText?.text = "Limit sum score: " + viewModel.stateDataMutable!!.minSkillScore.toString() + "-" + viewModel.stateDataMutable!!.maxSkillScore.toString()
        // (#)
        LocalBroadcastManager.getInstance(this).registerReceiver(mMessageReceiver, IntentFilter("current-skill-score-action"))

    }

    override fun onResume() {
        viewModel.send(LoadEvent())

        super.onResume()
    }

    override fun onPause(){
        viewModel.send(SaveEvent(skillRVAdapter!!.getList()))

        super.onPause()
    }

    // (#)
    var mMessageReceiver: BroadcastReceiver = object : BroadcastReceiver() {
        override fun onReceive(context: Context?, intent: Intent) {
            // Get extra data included in the Intent
            val ItemName: String? = intent.getStringExtra("current-skill-score-name")
            //val qty: String? = intent.getStringExtra("quantity")
            currentScoreText?.text = "Сумма очков: $ItemName"
        }
    }

}