package com.example.quest_maker.presentation.personMaker.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.localbroadcastmanager.content.LocalBroadcastManager
import androidx.recyclerview.widget.RecyclerView
import com.example.domain.models.PersonItem
import com.example.quest_maker.R

class ItemRVAdapter (
    private val context: Context,
    ) : RecyclerView.Adapter<ItemRVAdapter.ViewHolder>() {

    private val inflater: LayoutInflater = LayoutInflater.from(context)

    private var list: List<PersonItem>? = null

    fun setData(newList: List<PersonItem>){
        this.list = newList
        notifyDataSetChanged()
    }

    fun getList(): List<PersonItem> {
        return list!!
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {
        val view = inflater.inflate(R.layout.rv_item_characteristics_input, parent, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val one: PersonItem = list!![position]
        holder.name.text = one.text

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

        init {
            name = itemView.findViewById(R.id.RV_item_TV_characteristic_name)
        }
    }
}