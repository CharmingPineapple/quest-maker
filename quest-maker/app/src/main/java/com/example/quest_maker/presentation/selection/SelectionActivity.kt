package com.example.quest_maker.presentation.selection

import android.os.Bundle
import android.view.MenuItem
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


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_selection)

        val bottomNavigation : BottomNavigationView = findViewById(R.id.selection_navigation_bar)
        bottomNavigation.setOnNavigationItemSelectedListener(this::onNavigationItemSelected);

        //viewModel.load()

        recycleView = findViewById(R.id.RV_selection)

        // добавить спинер

        displayView(R.id.inv)


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

                selectionCheckBoxRVAdapter = SelectionCheckBoxRVAdapter(this)

                // добавить спинер

                selectionCheckBoxRVAdapter!!.setData(viewModel.getSimpleWeaponList(), viewModel.getMaxInventoryItem())
                recycleView!!.adapter = selectionCheckBoxRVAdapter
                recycleView!!.layoutManager = LinearLayoutManager(applicationContext, LinearLayoutManager.VERTICAL, false)

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