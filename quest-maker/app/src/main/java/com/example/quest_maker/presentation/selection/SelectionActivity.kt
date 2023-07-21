package com.example.quest_maker.presentation.selection

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.Spinner
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.localbroadcastmanager.content.LocalBroadcastManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.quest_maker.R
import com.example.quest_maker.presentation.selection.rv_adapter.SelectionCheckBoxRVAdapter
import com.google.android.material.bottomnavigation.BottomNavigationView
import org.koin.androidx.viewmodel.ext.android.viewModel


class SelectionActivity : AppCompatActivity() {

    private val viewModel by viewModel<SelectionViewModel>()

    private var recycleView: RecyclerView? = null

    private var selectionCheckBoxRVAdapter: SelectionCheckBoxRVAdapter? = null

    private var spinner: Spinner? = null
    private var spinnerAdapter: ArrayAdapter<String>? = null

    private var selectedNumTV: TextView? = null
    private var selectedLimitTV: TextView? = null

    private var lastViewId: Int? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_selection)

        val bottomNavigation : BottomNavigationView = findViewById(R.id.selection_navigation_bar)
        bottomNavigation.setOnNavigationItemSelectedListener(this::onNavigationItemSelected);

        viewModel.load()

        recycleView = findViewById(R.id.RV_selection)
        spinner = findViewById(R.id.spinner_selection)

        selectedNumTV = findViewById(R.id.TV_selected_num_selection)
        selectedLimitTV = findViewById(R.id.TV_selected_limit_selection)


        selectionCheckBoxRVAdapter = SelectionCheckBoxRVAdapter(this)

        recycleView!!.layoutManager = LinearLayoutManager(applicationContext, LinearLayoutManager.VERTICAL, false)



        spinner!!.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parentView: AdapterView<*>?,
                selectedItemView: View?,
                position: Int,
                id: Long
            ) {
                selectionCheckBoxRVAdapter!!.setList(spinnerAdapter!!.getItem(position).toString())
            }
            override fun onNothingSelected(parentView: AdapterView<*>?) {
                // your code here
            }
        }

        displayView(R.id.menu_inventory)

        LocalBroadcastManager.getInstance(this).registerReceiver(mMessageReceiver, IntentFilter("current-selected-num-action"))
    }

    private fun onNavigationItemSelected(item: MenuItem): Boolean {
        displayView(item.itemId)
        return true
    }

    private fun displayView(viewId: Int) {

        lastViewId?.let { saveLast() }

        lastViewId = viewId

            when (viewId) {
            R.id.menu_inventory -> {

                viewModel.load()

                setSpinnerData(viewModel.getTypeInventoryItemList())

                selectedLimitTV!!.text = "Limit num: " + viewModel.getMaxInventoryItem().toString()

                selectionCheckBoxRVAdapter!!.setData(viewModel.getSimpleInventoryItemList(), viewModel.getMaxInventoryItem())
                recycleView!!.adapter = selectionCheckBoxRVAdapter
            }

            R.id.menu_injury -> {

                viewModel.load()

                setSpinnerData(viewModel.getTypePersonInjuryList())

                selectedLimitTV!!.text = "Limit num: " + viewModel.getMaxPersonInjury().toString()

                selectionCheckBoxRVAdapter!!.setData(viewModel.getSimplePersonInjuryList(), viewModel.getMaxPersonInjury())
                recycleView!!.adapter = selectionCheckBoxRVAdapter

            }


        }
        /*if (fragment != null) {
            val ft: FragmentTransaction = supportFragmentManager.beginTransaction()
            ft.replace(R.id.fragment_container_view, fragment)
            ft.commit()
        }*/
    }

    private fun saveLast(){
        // viewModel.saveInvItem(selectionCheckBoxRVAdapter!!.getSelectedItemList())

        when(lastViewId){

            R.id.menu_inventory ->{
                viewModel.saveInventoryItem(selectionCheckBoxRVAdapter!!.getSelectedItemList())
            }

            R.id.menu_injury ->{
                viewModel.savePersonInjury(selectionCheckBoxRVAdapter!!.getSelectedItemList())
            }


        }


    }

    private var mMessageReceiver: BroadcastReceiver = object : BroadcastReceiver() {
        override fun onReceive(context: Context?, intent: Intent) {
            // Get extra data included in the Intent
            val itemName: String? = intent.getStringExtra("current-selected-num-name")
            selectedNumTV?.text = "Current num: $itemName"
        }
    }

    private fun setSpinnerData(list: List<String>){
        spinnerAdapter = ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, list)
        spinner!!.adapter = spinnerAdapter
    }

    override fun onResume() {
        super.onResume()
        viewModel.load()
        spinnerAdapter = ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, viewModel.getTypeInventoryItemList())
    }

    override fun onPause() {
        super.onPause()

        saveLast()

    }

}