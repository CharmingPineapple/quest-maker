package com.example.quest_maker.viewModel

import androidx.lifecycle.ViewModel
import com.example.domain.models.Skill
import com.example.domain.usecase.GetSkillUseCase
import com.example.domain.usecase.SaveSkillUseCase
import com.example.quest_maker.presentation.person_maker.LoadEvent
import com.example.quest_maker.presentation.person_maker.PersonMakerEvent
import com.example.quest_maker.presentation.person_maker.PersonMakerState
import com.example.quest_maker.presentation.person_maker.SaveEvent

class PersonMakerViewModel(
    // (#!) - change to private
    private val getSkillUseCase: GetSkillUseCase,
    private val saveSkillUseCase: SaveSkillUseCase
) : ViewModel() {

    //private val stateLiveMutable = MutableLiveData<PersonMakerState>()
    var stateDataMutable: PersonMakerState? = null
    // будет ли изменяться stateData?
    //val stateData: PersonMakerState? = stateDataMutable

    fun send(event: PersonMakerEvent){
        when(event){
            is SaveEvent -> {
                save(event.skillList)
            }
            is LoadEvent -> {
                load()
            }
        }
    }

    private fun save(skillList: List<Skill>){
        saveSkillUseCase.saveAll(skillList)

        // Если save() вызывается не в onStop
        // или сохраняет только какие-то одни параметры,
        // то надо реализовать пересоздание PersonMakerState

    }

    private fun load(){
        val skillList: List<Skill> = getSkillUseCase.all

        stateDataMutable = PersonMakerState(
            skillList
        )
    }

    override fun onCleared() {
        // CODE
        super.onCleared()
    }


}