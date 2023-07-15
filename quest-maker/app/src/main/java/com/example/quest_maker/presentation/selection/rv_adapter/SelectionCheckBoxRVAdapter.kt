package com.example.quest_maker.presentation.selection.rv_adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.domain.models.InventoryItem
import com.example.quest_maker.R

class SelectionCheckBoxRVAdapter (
    private val context: Context,
) : RecyclerView.Adapter<SelectionCheckBoxRVAdapter.ViewHolder>() {

    private val inflater: LayoutInflater = LayoutInflater.from(context)

    private var list: MutableList<InventoryItem>? = null

    fun setData(newList: List<InventoryItem>){
        this.list = newList.toMutableList()
        notifyDataSetChanged()
    }

    fun getList(): List<InventoryItem> {
        return list!!
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {
        val view = inflater.inflate(R.layout.rv_item_selection_check_box, parent, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val one: InventoryItem = list!![position]
        holder.nameTextView.text = one.name



    }

    override fun getItemCount(): Int {
        return list!!.size
    }

    inner class ViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {

        var checkBox: CheckBox
        var nameTextView: TextView

        init {
            nameTextView = itemView.findViewById(R.id.RV_item_selection_TV_name)
            checkBox = itemView.findViewById(R.id.RV_item_selection_check_box)
        }
    }

}