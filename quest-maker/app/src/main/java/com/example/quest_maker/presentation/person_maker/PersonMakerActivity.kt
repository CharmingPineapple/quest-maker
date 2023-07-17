package com.example.quest_maker.presentation.person_maker

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.localbroadcastmanager.content.LocalBroadcastManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.quest_maker.R
import com.example.quest_maker.presentation.person_maker.rv_adapter.InvItemRVAdapter
import com.example.quest_maker.presentation.person_maker.rv_adapter.MainParameterRVAdapter
import com.example.quest_maker.presentation.person_maker.rv_adapter.SkillRVAdapter
import com.example.quest_maker.presentation.selection.SelectionActivity
import org.koin.androidx.viewmodel.ext.android.viewModel

class PersonMakerActivity : AppCompatActivity(){

    //private lateinit var viewModel: PersonMakerViewModel
    private val viewModel by viewModel<PersonMakerViewModel>()

    private var skillRV: RecyclerView? = null
    private var mpRV: RecyclerView? = null
    private var itemRV: RecyclerView? = null

    private var skillRVAdapter: SkillRVAdapter? = null
    private var mpRVAdapter: MainParameterRVAdapter? = null
    private var invItemRVAdapter: InvItemRVAdapter? = null

    private var limitScoreText: TextView? = null
    private var currentScoreText: TextView? = null

    private var selectionButton: Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // загрузка интерфейса из activity_person_maker_rv (xml)
        setContentView(R.layout.activity_person_maker)

        limitScoreText = findViewById(R.id.TV_limit_score)
        currentScoreText = findViewById(R.id.TV_current_score)

        /*viewModel = ViewModelProvider(this, PersonMakerViewModelFactory(this))
            .get(PersonMakerViewModel::class.java)*/


        skillRV = findViewById(R.id.RV_skill_list)
        skillRVAdapter = SkillRVAdapter(this)

        mpRV = findViewById(R.id.RV_main_param_list)
        mpRVAdapter = MainParameterRVAdapter(this)

        itemRV = findViewById(R.id.RV_item_list)
        invItemRVAdapter = InvItemRVAdapter(this)


        viewModel.load()

        // Setting Skill RV
        skillRV!!.adapter = skillRVAdapter
        skillRV!!.layoutManager = LinearLayoutManager(applicationContext, LinearLayoutManager.VERTICAL, false)

        // Setting MainParameter RV
        mpRV!!.adapter = mpRVAdapter
        mpRV!!.layoutManager = LinearLayoutManager(applicationContext, LinearLayoutManager.VERTICAL, false)

        // Setting Item RV
        itemRV!!.adapter = invItemRVAdapter
        itemRV!!.layoutManager = LinearLayoutManager(applicationContext, LinearLayoutManager.VERTICAL, false)

        // Show min/max and current sum of skills
        limitScoreText?.text = "Limit sum score: " + viewModel.getMinSkillScore().toString() + "-" + viewModel.getMaxSkillScore().toString()

        // Load sum of skills from intent
        LocalBroadcastManager.getInstance(this).registerReceiver(mMessageReceiver, IntentFilter("current-skill-score-action"))

        selectionButton = findViewById(R.id.Button_selection)
        selectionButton!!.setOnClickListener{
            val intent = Intent(this@PersonMakerActivity, SelectionActivity::class.java)
            startActivity(intent)
        }

    }

    override fun onResume() {
        super.onResume()
        viewModel.load()
        setRVData()
    }

    private fun setRVData(){
        skillRVAdapter!!.setData(viewModel.getSkillList(), viewModel.getMaxSkillScore(), viewModel.getMinSkillScore())
        mpRVAdapter!!.setData(viewModel.getMPList(), viewModel.getMaxHealth(), viewModel.getMinHealth(), viewModel.getMaxFND(), viewModel.getMaxBullet())
        invItemRVAdapter!!.setData(viewModel.getItemList())
    }

    // (!) - Сделать save с rvMainParam
    override fun onPause(){
        viewModel.save(skillRVAdapter!!.getList(), mpRVAdapter!!.getList(), invItemRVAdapter!!.getList())

        super.onPause()
    }

    // Receiver sum of skills from intent
    private var mMessageReceiver: BroadcastReceiver = object : BroadcastReceiver() {
        override fun onReceive(context: Context?, intent: Intent) {
            // Get extra data included in the Intent
            val itemName: String? = intent.getStringExtra("current-skill-score-name")
            // (?) - точно ли это должно происходить здесь
            currentScoreText?.text = "Сумма очков: $itemName"
        }
    }

}