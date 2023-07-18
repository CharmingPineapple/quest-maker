package com.example.quest_maker.presentation.general_data

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.domain.models.viewer.Weapon
import com.example.quest_maker.R
import com.example.quest_maker.presentation.general_data.rv_adapter.WeaponRVAdapter
import org.koin.androidx.viewmodel.ext.android.viewModel


class GeneralDataActivity : AppCompatActivity() {

    private val viewModel by viewModel<GeneralDataViewModel>()

    private var weaponRV: RecyclerView? = null
    private var weaponRVAdapter: WeaponRVAdapter? = null



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(com.example.quest_maker.R.layout.activity_general_data)

        // (?) import android.os.PersistableBundle, what is it?


        weaponRV = findViewById(R.id.RV_general_list)
        weaponRVAdapter = WeaponRVAdapter(this)

        viewModel.load()

        weaponRVAdapter!!.setData(viewModel.getWeaponList())
        weaponRV!!.adapter = weaponRVAdapter
        weaponRV!!.layoutManager = LinearLayoutManager(applicationContext, LinearLayoutManager.VERTICAL, false)

        var testList: List<Weapon> = viewModel.getWeaponList()

        // (#)
        /*var test: TextView = findViewById(R.id.TV_TEST_NAME)
        test.text = testList[0].name
        //test.text = "test"*/


    }
}