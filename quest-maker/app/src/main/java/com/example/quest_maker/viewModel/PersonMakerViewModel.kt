package com.example.quest_maker.viewModel

import androidx.lifecycle.ViewModel
import com.example.domain.models.PersonItem
import com.example.domain.usecase.GetItemUseCase
import com.example.domain.usecase.GetMainParameterUseCase
import com.example.domain.usecase.GetSkillUseCase
import com.example.domain.usecase.SaveItemUseCase
import com.example.domain.usecase.SaveMainParameterUseCase
import com.example.domain.usecase.SaveSkillUseCase
import com.example.quest_maker.presentation.person_maker.PersonMakerData

class PersonMakerViewModel(
    // (#!) - change to private
    private val getSkillUseCase: GetSkillUseCase,
    private val saveSkillUseCase: SaveSkillUseCase,
    private val getMainParameterUseCase: GetMainParameterUseCase,
    private val saveMainParameterUseCase: SaveMainParameterUseCase,
    private val getItemUseCase: GetItemUseCase,
    private val saveItemUseCase: SaveItemUseCase
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

    fun save(skillList: List<PersonItem>, mpList: List<PersonItem>){
        saveSkillUseCase.saveAll(skillList)
        saveMainParameterUseCase.saveAll(mpList)


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

    fun load(){
        val skillList: List<PersonItem> = getSkillUseCase.all
        val mpList: List<PersonItem> = getMainParameterUseCase.all

        dataMutable = PersonMakerData(
            skillList,
            mpList
        )
    }

    override fun onCleared() {
        // CODE
        super.onCleared()
    }


}