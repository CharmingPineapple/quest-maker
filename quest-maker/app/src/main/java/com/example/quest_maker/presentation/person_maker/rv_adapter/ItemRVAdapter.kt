package com.example.quest_maker.presentation.person_maker.rv_adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.domain.models.InventoryItem
import com.example.quest_maker.R

class ItemRVAdapter (
    private val context: Context,
    ) : RecyclerView.Adapter<ItemRVAdapter.ViewHolder>() {

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
        val view = inflater.inflate(R.layout.rv_item_inv_item_input, parent, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val one: InventoryItem = list!![position]
        holder.nameTextView.text = one.name
        holder.typeTextView.text = "("+ one.type + ")"

        holder.deleteButton.setOnClickListener{
            list!!.remove(one)
            notifyDataSetChanged()
        }
    }

    override fun getItemCount(): Int {
        return list!!.size
    }

    inner class ViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {

        var nameTextView: TextView
        var typeTextView: TextView
        var deleteButton: Button

        init {
            nameTextView = itemView.findViewById(R.id.RV_item_TV_inv_item_name)
            typeTextView = itemView.findViewById(R.id.RV_item_TV_inv_item_type)
            deleteButton = itemView.findViewById(R.id.RV_item_Button_inv_item_delete)
        }
    }
}