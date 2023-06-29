package com.example.quest_maker.presentation.person_maker

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.View.GONE
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.localbroadcastmanager.content.LocalBroadcastManager
import androidx.recyclerview.widget.RecyclerView
import com.example.domain.models.Characteristic
import com.example.quest_maker.R
import kotlin.math.max

class CharacteristicsRVAdapter(
    // (#) - was: context: Context,
    private val context: Context,
    private val maxScore: Int = 33,
    private val minScore: Int = 28
    ) : RecyclerView.Adapter<CharacteristicsRVAdapter.ViewHolder>() {

    private val inflater: LayoutInflater = LayoutInflater.from(context)

    private var list: List<Characteristic>? = null

    private var currentScore: Int? = null

    private var lastTappedPosition: Int? = null

    fun setCharacteristic(newList: List<Characteristic>){
        this.list = newList
        calcCurrentScore()
        sendRemainScore()
        notifyDataSetChanged()
    }

    fun getList(): List<Characteristic> {
        return list!!
    }

    var intent: Intent = Intent("remain-characteristic-score")

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

        /*if(currentScore == maxScore){
            holder.plusButton.visibility = View.GONE
        }*/

        /*if(one.value == "0" && lastTappedPosition == position){
            holder.minusButton.visibility = View.GONE
        }*/

        //TODO("plus and minus implementation:
        // ограничение !<0
        // добавить "Осталось очков"
        // ")

        /*holder.plusButton.setOnClickListener{
            list!![position].value = (one.value.toInt() + 1).toString()

            /*//(#)
            intent.putExtra("testName", one.value)
            LocalBroadcastManager.getInstance(context).sendBroadcast(intent)*/
            calcCurrentScore()
            sendRemainScore()
            lastTappedPosition = holder.adapterPosition
            notifyDataSetChanged()
        }

        holder.minusButton.setOnClickListener{
            list!![position].value = (one.value.toInt() - 1).toString()

            // (#)
            calcCurrentScore()
            sendRemainScore()
            lastTappedPosition = holder.adapterPosition
            notifyDataSetChanged()
        }*/
    }

    override fun getItemCount(): Int {
       return list!!.size
    }

    private fun calcCurrentScore()/*: Int*/{
        // (#)

        var sumScore: Int = 0

        for(one: Characteristic in list!!){
            sumScore += one.value.toInt()
        }

        currentScore = sumScore

        //return sumScore
    }

    private fun sendRemainScore(){
        //(#)
        intent.putExtra("testName", (maxScore - currentScore!!).toString())
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

            /*if(value.text.toString() == "0"){
                minusButton.visibility = View.GONE
            }*/



        }



        /*if(currentScore == maxScore){
            plusButton.visibility = View.GONE
        }*/


    }

}