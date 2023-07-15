package com.example.quest_maker.presentation.selection

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.quest_maker.R
import com.google.android.material.bottomnavigation.BottomNavigationView


class SelectionActivity : AppCompatActivity() {

    private var recycleView: RecyclerView? = null



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_selection)

        val bottomNavigation : BottomNavigationView = findViewById(R.id.selection_navigation_bar)
        bottomNavigation.setOnNavigationItemSelectedListener(this::onNavigationItemSelected);



    }

    private fun onNavigationItemSelected(item: MenuItem): Boolean {
        displayView(item.itemId)
        return true
    }

    fun displayView(viewId: Int) {
        //var fragment: Fragment? = null
        when (viewId) {
            /*R.id.inv -> fragment = DictionaryFragment()
            R.id.collection -> fragment = CollectionFragment()
            R.id.game -> fragment = GameFragment()*/

            R.id.inv -> {



            }

        }
        /*if (fragment != null) {
            val ft: FragmentTransaction = supportFragmentManager.beginTransaction()
            ft.replace(R.id.fragment_container_view, fragment)
            ft.commit()
        }*/
    }

}