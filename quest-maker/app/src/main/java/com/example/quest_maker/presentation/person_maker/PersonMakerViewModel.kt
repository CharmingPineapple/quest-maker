package com.example.quest_maker.presentation.person_maker

import androidx.lifecycle.ViewModel
import com.example.domain.models.author.Item
import com.example.domain.models.author.PersonItem
import com.example.domain.usecase.author.inventory.GetInventoryItemUseCase
import com.example.domain.usecase.author.main_parameter.GetMainParameterUseCase
import com.example.domain.usecase.author.skill.GetSkillUseCase
import com.example.domain.usecase.author.inventory.SaveInventoryItemUseCase
import com.example.domain.usecase.author.main_parameter.SaveMainParameterUseCase
import com.example.domain.usecase.author.skill.SaveSkillUseCase
import com.example.domain.usecase.author.status.GetPersonCurseUseCase
import com.example.domain.usecase.author.status.GetPersonInjuryUseCase
import com.example.domain.usecase.author.status.SavePersonCurseUseCase
import com.example.domain.usecase.author.status.SavePersonInjuryUseCase

class PersonMakerViewModel(
    private val getSkillUseCase: GetSkillUseCase,
    private val saveSkillUseCase: SaveSkillUseCase,

    private val getMainParameterUseCase: GetMainParameterUseCase,
    private val saveMainParameterUseCase: SaveMainParameterUseCase,

    private val getInventoryItemUseCase: GetInventoryItemUseCase,
    private val saveInventoryItemUseCase: SaveInventoryItemUseCase,

    private val getPersonInjuryUseCase: GetPersonInjuryUseCase,
    private val savePersonInjuryUseCase: SavePersonInjuryUseCase,

    private val getPersonCurseUseCase: GetPersonCurseUseCase,
    private val savePersonCurseUseCase: SavePersonCurseUseCase

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

    fun save(skillList: List<PersonItem>,
             mpList: List<PersonItem>,
             inventoryItemList: List<Item>,
             personInjuryList: List<Item>,
             personCurseList: List<Item>
    ){
        saveSkillUseCase.saveAll(skillList)
        saveMainParameterUseCase.saveAll(mpList)
        saveInventoryItemUseCase.saveAll(inventoryItemList)
        savePersonInjuryUseCase.saveAll(personInjuryList)
        savePersonCurseUseCase.saveAll(personCurseList)


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

    fun getInventoryItemList() : List<Item>{
        return dataMutable!!.inventoryItemList
    }

    fun getPersonInjuryList() : List<Item>{
        return dataMutable!!.personInjuryList
    }
    fun getPersonCurseList() : List<Item>{
        return dataMutable!!.personCurseList
    }

    fun load(){
        val skillList: List<PersonItem> = getSkillUseCase.all
        val mpList: List<PersonItem> = getMainParameterUseCase.all
        val inventoryItemList: List<Item> = getInventoryItemUseCase.all
        val personInjuryList: List<Item> = getPersonInjuryUseCase.all
        val personCurseList: List<Item> = getPersonCurseUseCase.all

        dataMutable = PersonMakerData(
            skillList,
            mpList,
            inventoryItemList,
            personInjuryList,
            personCurseList
        )
    }

    override fun onCleared() {
        // CODE
        super.onCleared()
    }


}