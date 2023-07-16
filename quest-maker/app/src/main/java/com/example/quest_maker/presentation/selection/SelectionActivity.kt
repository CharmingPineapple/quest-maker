package com.example.quest_maker.presentation.selection

import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
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


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_selection)

        val bottomNavigation : BottomNavigationView = findViewById(R.id.selection_navigation_bar)
        bottomNavigation.setOnNavigationItemSelectedListener(this::onNavigationItemSelected);

        viewModel.load()

        recycleView = findViewById(R.id.RV_selection)
        spinner = findViewById(R.id.spinner_selection)

        // добавить спинер

        displayView(R.id.inv)

        //(#)
        var test: TextView = findViewById(R.id.selection_test_TV)

        spinner!!.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parentView: AdapterView<*>?,
                selectedItemView: View?,
                position: Int,
                id: Long
            ) {
                // (#)
                //test.text = spinnerAdapter!!.getItem(position).toString()
                selectionCheckBoxRVAdapter!!.setList(spinnerAdapter!!.getItem(position).toString())
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
        //var fragment: Fragment? = null
        when (viewId) {
            /*R.id.inv -> fragment = DictionaryFragment()
            R.id.collection -> fragment = CollectionFragment()
            R.id.game -> fragment = GameFragment()*/

            R.id.inv -> {
                // добавить спинер

                spinnerAdapter = ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, viewModel.getTypeItemList())
                spinner!!.adapter = spinnerAdapter

                selectionCheckBoxRVAdapter = SelectionCheckBoxRVAdapter(this)

                // (!#) - Заменить список оружия на список всех предметов
                selectionCheckBoxRVAdapter!!.setData(viewModel.getSimpleWeaponList(), viewModel.getMaxInventoryItem())
                recycleView!!.adapter = selectionCheckBoxRVAdapter
                recycleView!!.layoutManager = LinearLayoutManager(applicationContext, LinearLayoutManager.VERTICAL, false)

                //selectionCheckBoxRVAdapter!!.weaponList

            }

        }
        /*if (fragment != null) {
            val ft: FragmentTransaction = supportFragmentManager.beginTransaction()
            ft.replace(R.id.fragment_container_view, fragment)
            ft.commit()
        }*/
    }

    override fun onResume() {
        super.onResume()
        viewModel.load()
    }

}