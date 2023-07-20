package com.example.quest_maker.presentation.general_data.rv_adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.domain.models.viewer.Weapon
import com.example.quest_maker.R

class WeaponRVAdapter(private val context: Context,
) : RecyclerView.Adapter<WeaponRVAdapter.ViewHolder>() {

    private val inflater: LayoutInflater = LayoutInflater.from(context)

    private var list: List<Weapon>? = null

    fun setData(newList: List<Weapon>){
        this.list = newList
        notifyDataSetChanged()
    }

    /*fun getList(): List<Weapon> {
        return list!!
    }*/

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {
        val view = inflater.inflate(R.layout.rv_item_weapon_table, parent, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val one: Weapon = list!![position]
        holder.name.text = one.name
        holder.damageType.text = one.damage_type
        holder.handed.text = one.handed
        holder.preferredStat.text = one.preferred_stat
        holder.damage.text = one.damage
        holder.speed.text = one.speed
        holder.speedEquip.text = one.speed_equip
        holder.hitChance.text = one.hit_chance
        holder.throwDamage.text = one.throw_damage
        holder.sellPrice.text = one.sell_price
        holder.description.text = one.description
    }

    override fun getItemCount(): Int {
        return list!!.size
    }

    inner class ViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {

        var name : TextView
        var damageType : TextView
        var handed : TextView
        var preferredStat : TextView
        var damage : TextView
        var speed : TextView
        var speedEquip : TextView
        var hitChance : TextView
        var throwDamage : TextView
        var sellPrice : TextView
        var description : TextView

        init {
            name = itemView.findViewById(R.id.RV_item_TV_weapon_name)
            damageType = itemView.findViewById(R.id.RV_item_TV_weapon_damage_type)
            handed = itemView.findViewById(R.id.RV_item_TV_weapon_handed)
            preferredStat = itemView.findViewById(R.id.RV_item_TV_weapon_prefstat)
            damage = itemView.findViewById(R.id.RV_item_TV_weapon_damage)
            speed = itemView.findViewById(R.id.RV_item_TV_weapon_speed)
            speedEquip = itemView.findViewById(R.id.RV_item_TV_weapon_speed_equip)
            hitChance = itemView.findViewById(R.id.RV_item_TV_weapon_hit_chance)
            throwDamage = itemView.findViewById(R.id.RV_item_TV_weapon_throw_damage)
            sellPrice = itemView.findViewById(R.id.RV_item_TV_weapon_sell_price)
            description = itemView.findViewById(R.id.RV_item_TV_weapon_description)
        }
    }
}