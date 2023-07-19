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
        holder.source.text = one.source
        holder.buyPrice.text = one.buy_price
        holder.sellPrice.text = one.sell_price
        holder.description.text = one.description

        /*holder.name_text.text = "Name"
        holder.traits_text.text = "Traits"
        holder.effect_text.text = "Effect"
        holder.source_text.text = "Source"
        holder.buyPrice_text.text = "Buy price"
        holder.sellPrice_text.text = "Sell price"
        holder.description_text.text = "Description"

        holder.name_text.

        holder.name_text.height =       holder.name.height
        holder.traits_text.height =     holder.traits.height
        holder.effect_text.height =     holder.effect.height
        holder.source_text.height =     holder.source.height
        holder.buyPrice_text.height =   holder.buyPrice.height
        holder.sellPrice_text.height =  holder.sellPrice.height
        holder.description_text.height =holder.description.height
*/
    }

    override fun getItemCount(): Int {
        return list!!.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var name: TextView
        var traits: TextView
        var effect: TextView
        var source: TextView
        var buyPrice: TextView
        var sellPrice: TextView
        var description: TextView

        /*var name_text: TextView
        var traits_text: TextView
        var effect_text: TextView
        var source_text: TextView
        var buyPrice_text: TextView
        var sellPrice_text: TextView
        var description_text: TextView*/

        init {
            name = itemView.findViewById(R.id.RV_item_TV_equipment_name)
            traits = itemView.findViewById(R.id.RV_item_TV_equipment_traits)
            effect = itemView.findViewById(R.id.RV_item_TV_equipment_effect)
            source = itemView.findViewById(R.id.RV_item_TV_equipment_source)
            buyPrice = itemView.findViewById(R.id.RV_item_TV_equipment_buy_price)
            sellPrice = itemView.findViewById(R.id.RV_item_TV_equipment_sell_price)
            description = itemView.findViewById(R.id.RV_item_TV_equipment_description)

            /*name_text = itemView.findViewById(R.id.RV_item_TV_equipment_name_text)
            traits_text = itemView.findViewById(R.id.RV_item_TV_equipment_traits_text)
            effect_text = itemView.findViewById(R.id.RV_item_TV_equipment_effect_text)
            source_text = itemView.findViewById(R.id.RV_item_TV_equipment_source_text)
            buyPrice_text = itemView.findViewById(R.id.RV_item_TV_equipment_buy_price_text)
            sellPrice_text = itemView.findViewById(R.id.RV_item_TV_equipment_sell_price_text)
            description_text = itemView.findViewById(R.id.RV_item_TV_equipment_description_text)*/

            // (!) - Use Android resources instead.
            /*name_text        .text = "Name"
            traits_text      .text = "Traits"
            effect_text      .text = "Effect"
            source_text      .text = "Source"
            buyPrice_text    .text = "Buy price"
            sellPrice_text   .text = "Sell price"
            description_text .text = "Description"*/


        }
    }
}