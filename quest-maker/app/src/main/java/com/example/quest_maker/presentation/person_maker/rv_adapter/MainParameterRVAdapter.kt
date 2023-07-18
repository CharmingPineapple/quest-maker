package com.example.quest_maker.presentation.person_maker.rv_adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.domain.models.author.PersonItem
import com.example.quest_maker.R

class MainParameterRVAdapter(
    private val context: Context,
    ) : RecyclerView.Adapter<MainParameterRVAdapter.ViewHolder>() {

    private val inflater: LayoutInflater = LayoutInflater.from(context)

    private var list: List<PersonItem>? = null

    private var maxHealth: Int? = null
    private var minHealth: Int? = null
    private var maxFND: Int? = null
    private var maxBullet: Int? = null

    fun setData(newList: List<PersonItem>, newMaxHealth: Int, newMinHealth: Int, newMaxFND: Int, newMaxBullet: Int){
        this.list = newList
        this.maxHealth = newMaxHealth
        this.minHealth = newMinHealth
        this.maxFND = newMaxFND
        this.maxBullet = newMaxBullet
        notifyDataSetChanged()
    }

    fun getList(): List<PersonItem> {
        return list!!
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {
        val view = inflater.inflate(R.layout.rv_item_pers_item_input, parent, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val one: PersonItem = list!![position]
        holder.name.text = one.text
        holder.value.text = one.value

        if (holder.value.text.toString() == "0" || one.value.toInt() == minHealth){
            holder.minusButton.visibility = View.INVISIBLE
        } else {
            holder.minusButton.visibility = View.VISIBLE
        }

        if (
            one.value.toInt() == maxHealth
            || (one.value.toInt() == maxBullet && one.text.toString() == "BUL")
            || (one.value.toInt() == maxFND && one.text.toString() == "FND")
        ) {
            holder.plusButton.visibility = View.INVISIBLE
        } else {
            holder.plusButton.visibility = View.VISIBLE
        }

        holder.plusButton.setOnClickListener{
            list!![position].value = (one.value.toInt() + 1).toString()
            notifyDataSetChanged()
        }

        holder.minusButton.setOnClickListener{
            list!![position].value = (one.value.toInt() - 1).toString()
            notifyDataSetChanged()
        }
    }

    override fun getItemCount(): Int {
        return list!!.size
    }

    inner class ViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {

        var name: TextView
        var value: TextView
        var plusButton: Button
        var minusButton: Button

        init {
            name = itemView.findViewById(R.id.RV_item_TV_pers_item_name)
            value = itemView.findViewById(R.id.RV_item_TV_pers_item_value)
            plusButton = itemView.findViewById(R.id.RV_item_Button_pers_item_plus)
            minusButton = itemView.findViewById(R.id.RV_item_Button_pers_item_minus)
        }
    }

}