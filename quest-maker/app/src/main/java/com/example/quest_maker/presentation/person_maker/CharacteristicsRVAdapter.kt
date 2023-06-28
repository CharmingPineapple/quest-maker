package com.example.quest_maker.presentation.person_maker

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.domain.models.Characteristic
import com.example.quest_maker.R

class CharacteristicsRVAdapter(
    context: Context,
    private var list: List<Characteristic>? = null
    ) : RecyclerView.Adapter<CharacteristicsRVAdapter.ViewHolder>() {

    private val inflater: LayoutInflater
    //private var list: MutableList<Characteristic>? = null

    fun setList(list: List<Characteristic>){
        this.list = list
        notifyDataSetChanged()
    }

    init {
        inflater = LayoutInflater.from(context)
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): CharacteristicsRVAdapter.ViewHolder {
        val view = inflater.inflate(R.layout.rv_item_characteristics_input, parent, false)

        return ViewHolder(view)
    }


    override fun onBindViewHolder(holder: CharacteristicsRVAdapter.ViewHolder, position: Int) {
        val one: Characteristic = list!![position]

        holder.name.text = one.name
        holder.value.text = one.value

        //TODO("plus and minus implementation")
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
            name = itemView.findViewById(R.id.RV_item_TV_characteristic_name)
            value = itemView.findViewById(R.id.RV_item_TV_characteristic_value)
            plusButton = itemView.findViewById(R.id.RV_item_Button_characteristic_plus)
            minusButton = itemView.findViewById(R.id.RV_item_Button_characteristic_minus)
        }

    }

}