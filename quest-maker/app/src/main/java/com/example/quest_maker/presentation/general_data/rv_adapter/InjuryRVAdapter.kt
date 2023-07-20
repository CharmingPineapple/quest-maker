package com.example.quest_maker.presentation.general_data.rv_adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.domain.models.viewer.Injury
import com.example.quest_maker.R

class InjuryRVAdapter(
    private val context: Context,
) : RecyclerView.Adapter<InjuryRVAdapter.ViewHolder>() {

    private val inflater: LayoutInflater = LayoutInflater.from(context)

    private var listAll: List<Injury>? = null
    private var currentList: MutableList<Injury> = ArrayList()


    fun setData(newList: List<Injury>) {
        this.listAll = newList
        notifyDataSetChanged()
    }

    fun setList(type: String) {
        currentList.clear()

        for (one: Injury in listAll!!) {
            if (one.type == type)
                currentList.add(one)
        }

        notifyDataSetChanged()
    }


    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {
        val view = inflater.inflate(R.layout.rv_item_injury_table, parent, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val one: Injury = currentList[position]
        holder.name.text = one.name
        holder.type.text = one.type
        holder.effect.text = one.effect
        holder.description.text = one.description
    }

    override fun getItemCount(): Int {
        return currentList.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var name: TextView
        var type: TextView
        var effect: TextView
        var description: TextView

        init {
            name = itemView.findViewById(R.id.RV_item_TV_injury_name)
            type = itemView.findViewById(R.id.RV_item_TV_injury_type)
            effect = itemView.findViewById(R.id.RV_item_TV_injury_effect)
            description = itemView.findViewById(R.id.RV_item_TV_injury_description)
        }
    }
}