package com.example.quest_maker.presentation.person_maker

import androidx.lifecycle.ViewModel
import com.example.domain.models.author.Item
import com.example.domain.models.author.PersonItem
import com.example.domain.usecase.author.status_item.GetInventoryItemUseCase
import com.example.domain.usecase.author.main_parameter.GetMainParameterUseCase
import com.example.domain.usecase.author.skill.GetSkillUseCase
import com.example.domain.usecase.author.status_item.SaveInventoryItemUseCase
import com.example.domain.usecase.author.main_parameter.SaveMainParameterUseCase
import com.example.domain.usecase.author.skill.SaveSkillUseCase

class PersonMakerViewModel(
    private val getSkillUseCase: GetSkillUseCase,
    private val saveSkillUseCase: SaveSkillUseCase,
    private val getMainParameterUseCase: GetMainParameterUseCase,
    private val saveMainParameterUseCase: SaveMainParameterUseCase,
    private val getInventoryItemUseCase: GetInventoryItemUseCase,
    private val saveInventoryItemUseCase: SaveInventoryItemUseCase
) : ViewModel() {

    //private val stateLiveMutable = MutableLiveData<PersonMakerState>()
    private var dataMutable: PersonMakerData? = null
    // будет ли изменяться stateData?
    //val stateData: PersonMakerState? = stateDataMutable

    /*fun send(event: PersonMakerEvent){
        when(event){
            is SaveEvent -> {
                save(event.skillList)
            }
            is LoadEvent -> {
                load()
            }
        }
    }*/

    fun save(skillList: List<PersonItem>, mpList: List<PersonItem>, itemList: List<Item>){
        saveSkillUseCase.saveAll(skillList)
        saveMainParameterUseCase.saveAll(mpList)
        saveInventoryItemUseCase.saveAll(itemList)


        // Если save() вызывается не в onStop
        // или сохраняет только какие-то одни параметры,
        // то надо реализовать пересоздание PersonMakerState

    }

    // (!) - Нужно ли?
    fun getSkillList() : List<PersonItem>{
        return dataMutable!!.skillList
    }

    fun getMPList() : List<PersonItem>{
        return dataMutable!!.mpList
    }

    fun getMaxSkillScore() : Int {
        return dataMutable!!.maxSkillScore
    }

    fun getMinSkillScore() : Int {
        return dataMutable!!.minSkillScore
    }

    fun getMaxHealth() : Int {
        return dataMutable!!.maxHealth
    }

    fun getMinHealth() : Int {
        return dataMutable!!.minHealth
    }

    fun getMaxFND() : Int {
        return dataMutable!!.maxFND
    }

    fun getMaxBullet() : Int {
        return dataMutable!!.maxBullet
    }

    fun getItemList() : List<Item>{
        return dataMutable!!.itemList
    }

    fun load(){
        val skillList: List<PersonItem> = getSkillUseCase.all
        val mpList: List<PersonItem> = getMainParameterUseCase.all
        val itemList: List<Item> = getInventoryItemUseCase.all

        dataMutable = PersonMakerData(
            skillList,
            mpList,
            itemList
        )
    }

    override fun onCleared() {
        // CODE
        super.onCleared()
    }


}