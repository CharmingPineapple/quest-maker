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

class SkillRVAdapter(
    // (#) - was: context: Context,
    private val context: Context,

    ) : RecyclerView.Adapter<SkillRVAdapter.ViewHolder>() {

    private val inflater: LayoutInflater = LayoutInflater.from(context)

    private var list: List<PersonItem>? = null

    private var currentScore: Int? = null

    private var maxScore: Int? = null
    private var minScore: Int? = null

    fun setData(newList: List<PersonItem>, newMaxScore: Int, newMinScore: Int){
        this.list = newList
        this.maxScore = newMaxScore
        this.minScore = newMinScore
        notifyDataSetChanged()
    }

    fun getList(): List<PersonItem> {
        return list!!
    }

    private var intent: Intent = Intent("current-skill-score-action")

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
        holder.value.text = one.value

        sendCurrentScore()

        // Да ну нахуй, надо было всего лишь добавить else
        if (holder.value.text.toString() == "0" || currentScore == minScore){
            holder.minusButton.visibility = View.GONE
        } else {
            holder.minusButton.visibility = View.VISIBLE
        }

        if (currentScore == maxScore){
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

    private fun calcCurrentScore()/*: Int*/{
        var sumScore: Int = 0

        for(one: PersonItem in list!!){
            sumScore += one.value.toInt()
        }
        currentScore = sumScore
    }

    private fun sendCurrentScore(){
        calcCurrentScore()
        intent.putExtra("current-skill-score-name", currentScore.toString())
        LocalBroadcastManager.getInstance(context).sendBroadcast(intent)
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