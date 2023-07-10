package com.example.quest_maker.presentation.personMaker.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.domain.models.InventoryItem
import com.example.quest_maker.R

class ItemRVAdapter (
    private val context: Context,
    ) : RecyclerView.Adapter<ItemRVAdapter.ViewHolder>() {

    private val inflater: LayoutInflater = LayoutInflater.from(context)

    private var list: List<InventoryItem>? = null

    fun setData(newList: List<InventoryItem>){
        this.list = newList
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
        holder.name.text = one.name
        holder.type.text = one.type

        // Да ну нахуй, надо было всего лишь добавить else
        /*if (holder.value.text.toString() == "0" || currentScore == minScore){
            holder.minusButton.visibility = View.GONE
        } else {
            holder.minusButton.visibility = View.VISIBLE
        }

        if (currentScore == maxItem){
            holder.plusButton.visibility = View.INVISIBLE
        } else {
            holder.plusButton.visibility = View.VISIBLE
        }*/

        /*holder.plusButton.setOnClickListener{
            list!![position].value = (one.value.toInt() + 1).toString()
            notifyDataSetChanged()
        }

        holder.minusButton.setOnClickListener{
            list!![position].value = (one.value.toInt() - 1).toString()
            notifyDataSetChanged()
        }*/
    }

    override fun getItemCount(): Int {
        return list!!.size
    }

    inner class ViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {

        var name: TextView
        var type: TextView

        init {
            name = itemView.findViewById(R.id.RV_item_TV_inv_item_name)
            type = itemView.findViewById(R.id.RV_item_TV_inv_item_type)
        }
    }
}