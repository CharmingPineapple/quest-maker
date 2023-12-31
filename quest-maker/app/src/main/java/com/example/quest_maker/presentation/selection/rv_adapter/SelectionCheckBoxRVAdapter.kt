package com.example.quest_maker.presentation.selection.rv_adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.TextView
import androidx.localbroadcastmanager.content.LocalBroadcastManager
import androidx.recyclerview.widget.RecyclerView
import com.example.domain.models.author.Item
import com.example.quest_maker.R

class SelectionCheckBoxRVAdapter (
    private val context: Context,
) : RecyclerView.Adapter<SelectionCheckBoxRVAdapter.ViewHolder>() {

    private val inflater: LayoutInflater = LayoutInflater.from(context)

    private var intent: Intent = Intent("current-selected-num-action")

    private var listAll: MutableList<Item>? = null

    private var currentList: MutableList<Item> = ArrayList()

    private var maxItemNum: Int? = 0

    fun setData(newList: List<Item>, newMaxItemNum: Int) {
        this.listAll = newList.toMutableList()

        this.maxItemNum = newMaxItemNum
        notifyDataSetChanged()
    }

    fun setList(type: String) {

        currentList.clear()

        for (one: Item in listAll!!) {
            if (one.type == type)
                currentList.add(one)
        }

        notifyDataSetChanged()
    }

    fun getSelectedItemList(): List<Item> {
        val selectedItemList: MutableList<Item> = ArrayList()

        for (one: Item in listAll!!) {
            if (one.selected)
                selectedItemList.add(one)
        }

        return selectedItemList
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {
        val view = inflater.inflate(R.layout.rv_item_selection_check_box, parent, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val one: Item = currentList[position]
        holder.nameTextView.text = one.name

        if (calcNumSelected() == maxItemNum && !one.selected)
            holder.checkBox.visibility = View.INVISIBLE
        else
            holder.checkBox.visibility = View.VISIBLE

        holder.checkBox.setOnClickListener {
            one.selected = !one.selected
            notifyDataSetChanged()
        }

        holder.checkBox.isChecked = one.selected
    }

    override fun getItemCount(): Int {
        return currentList.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var checkBox: CheckBox
        var nameTextView: TextView

        init {
            nameTextView = itemView.findViewById(R.id.RV_item_selection_TV_name)
            checkBox = itemView.findViewById(R.id.RV_item_selection_check_box)
        }
    }

    private fun calcNumSelected(): Int {
        var count = 0

        for (one: Item in listAll!!) {
            if (one.selected)
                count++
        }

        intent.putExtra("current-selected-num-name", count.toString())
        LocalBroadcastManager.getInstance(context).sendBroadcast(intent)

        return count
    }
}
