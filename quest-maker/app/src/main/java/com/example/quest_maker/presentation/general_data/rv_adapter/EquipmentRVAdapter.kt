package com.example.quest_maker.presentation.general_data.rv_adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.domain.models.viewer.Equipment
import com.example.quest_maker.R

class EquipmentRVAdapter(
    private val context: Context,
) : RecyclerView.Adapter<EquipmentRVAdapter.ViewHolder>() {

    private val inflater: LayoutInflater = LayoutInflater.from(context)

    private var list: List<Equipment>? = null

    fun setData(newList: List<Equipment>) {
        this.list = newList
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {
        val view = inflater.inflate(R.layout.rv_item_equipment_table, parent, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val one: Equipment = list!![position]

        holder.name.text = one.name
        holder.traits.text = one.traits
        holder.effect.text = one.effect
        holder.throwDamage.text = one.throw_damage
        holder.source.text = one.source
        holder.buyPrice.text = one.buy_price
        holder.sellPrice.text = one.sell_price
        holder.description.text = one.description
    }

    override fun getItemCount(): Int {
        return list!!.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var name: TextView
        var traits: TextView
        var effect: TextView
        var throwDamage: TextView
        var source: TextView
        var buyPrice: TextView
        var sellPrice: TextView
        var description: TextView

        init {
            name = itemView.findViewById(R.id.RV_item_TV_equipment_name)
            traits = itemView.findViewById(R.id.RV_item_TV_equipment_traits)
            effect = itemView.findViewById(R.id.RV_item_TV_equipment_effect)
            throwDamage = itemView.findViewById(R.id.RV_item_TV_equipment_throw_damage)
            source = itemView.findViewById(R.id.RV_item_TV_equipment_source)
            buyPrice = itemView.findViewById(R.id.RV_item_TV_equipment_buy_price)
            sellPrice = itemView.findViewById(R.id.RV_item_TV_equipment_sell_price)
            description = itemView.findViewById(R.id.RV_item_TV_equipment_description)
        }
    }
}