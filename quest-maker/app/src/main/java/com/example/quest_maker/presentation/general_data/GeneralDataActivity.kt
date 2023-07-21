package com.example.quest_maker.presentation.general_data

import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.quest_maker.R
import com.example.quest_maker.presentation.general_data.rv_adapter.EquipmentRVAdapter
import com.example.quest_maker.presentation.general_data.rv_adapter.StatusRVAdapter
import com.example.quest_maker.presentation.general_data.rv_adapter.TrinketRVAdapter
import com.example.quest_maker.presentation.general_data.rv_adapter.WeaponRVAdapter
import com.google.android.material.bottomnavigation.BottomNavigationView
import org.koin.androidx.viewmodel.ext.android.viewModel


class GeneralDataActivity : AppCompatActivity() {

    private val viewModel by viewModel<GeneralDataViewModel>()

    private var recycleView: RecyclerView? = null

    private var weaponRVAdapter: WeaponRVAdapter? = null
    private var equipmentRVAdapter: EquipmentRVAdapter? = null
    private var trinketRVAdapter: TrinketRVAdapter? = null
    private var injuryRVAdapter: StatusRVAdapter? = null
    private var curseRVAdapter: StatusRVAdapter? = null

    private var spinner: Spinner? = null
    private var spinnerAdapter: ArrayAdapter<String>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(com.example.quest_maker.R.layout.activity_general_data)
        // (?) import android.os.PersistableBundle, what is it?

        val bottomNavigation : BottomNavigationView = findViewById(R.id.general_data_navigation_bar)
        bottomNavigation.setOnNavigationItemSelectedListener(this::onNavigationItemSelected);

        recycleView = findViewById(R.id.RV_general_data)
        spinner = findViewById(R.id.spinner_general_data)


        viewModel.load()

        val typeItemList: List<String> = viewModel.getTypeItemList()
        val typeInjuryList: List<String> = viewModel.getTypeInjuryList()
        val typeCurseList: List<String> = viewModel.getTypeCurseList()

        weaponRVAdapter = WeaponRVAdapter(this)
        equipmentRVAdapter = EquipmentRVAdapter(this)
        trinketRVAdapter = TrinketRVAdapter(this)
        injuryRVAdapter = StatusRVAdapter(this)
        curseRVAdapter = StatusRVAdapter(this)

        recycleView!!.layoutManager = LinearLayoutManager(applicationContext, LinearLayoutManager.VERTICAL, false)

        displayView(R.id.menu_inventory)

        // recycleView!!.adapter = selectionCheckBoxRVAdapter


        spinner!!.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parentView: AdapterView<*>?,
                selectedItemView: View?,
                position: Int,
                id: Long
            ) {
                when(spinnerAdapter!!.getItem(position).toString()){
                    typeItemList[0] -> recycleView!!.adapter = weaponRVAdapter
                    typeItemList[1] -> recycleView!!.adapter = equipmentRVAdapter
                    typeItemList[2] -> recycleView!!.adapter = trinketRVAdapter

                    /*typeInjuryList[0] -> recycleView!!.adapter = weaponRVAdapter
                    typeInjuryList[1] -> recycleView!!.adapter = weaponRVAdapter*/

                    typeInjuryList[0] -> injuryRVAdapter!!.setList(typeInjuryList[0])
                    typeInjuryList[1] -> injuryRVAdapter!!.setList(typeInjuryList[1])

                }
            }
            override fun onNothingSelected(parentView: AdapterView<*>?) {
                // your code here
            }
        }


    }

    private fun onNavigationItemSelected(item: MenuItem): Boolean {
        displayView(item.itemId)
        return true
    }

    private fun displayView(viewId: Int) {

        when (viewId) {

            R.id.menu_inventory -> {
                // добавить спинер

                spinnerAdapter = ArrayAdapter(this, android.R.layout.select_dialog_item, viewModel.getTypeItemList())
                spinner!!.adapter = spinnerAdapter

                // (#) - Это ускоряет появление данных, как бы тупо это не выглядело
                recycleView!!.adapter = weaponRVAdapter


            }

            R.id.menu_injury -> {
                // добавить спинер

                spinnerAdapter = ArrayAdapter(this, android.R.layout.select_dialog_item, viewModel.getTypeInjuryList())
                spinner!!.adapter = spinnerAdapter

                recycleView!!.adapter = injuryRVAdapter
            }

            R.id.menu_curse -> {
                // добавить спинер

                spinnerAdapter = ArrayAdapter(this, android.R.layout.select_dialog_item, viewModel.getTypeCurseList())
                spinner!!.adapter = spinnerAdapter

                recycleView!!.adapter = curseRVAdapter
            }

        }
    }

    override fun onResume() {
        super.onResume()
        viewModel.load()
        setRVData()
    }

    private fun setRVData(){
        weaponRVAdapter!!.setData(viewModel.getWeaponList())
        equipmentRVAdapter!!.setData(viewModel.getEquipmentList())
        trinketRVAdapter!!.setData(viewModel.getTrinketList())
        injuryRVAdapter!!.setData(viewModel.getInjuryList())
    }


}