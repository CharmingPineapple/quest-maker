package com.example.quest_maker.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.domain.models.Characteristic
import com.example.domain.usecase.GetCharacteristicUseCase
import com.example.domain.usecase.SaveCharacteristicUseCase
import com.example.quest_maker.presentation.person_maker.LoadEvent
import com.example.quest_maker.presentation.person_maker.PersonMakerEvent
import com.example.quest_maker.presentation.person_maker.PersonMakerState
import com.example.quest_maker.presentation.person_maker.SaveEvent

class PersonMakerViewModel(
    // (#!) - change to private
    private val getCharacteristicUseCase: GetCharacteristicUseCase,
    private val saveCharacteristicUseCase: SaveCharacteristicUseCase
) : ViewModel() {

    //private val stateLiveMutable = MutableLiveData<PersonMakerState>()
    var stateDataMutable: PersonMakerState? = null
    // будет ли изменяться stateData?
    //val stateData: PersonMakerState? = stateDataMutable

    fun send(event: PersonMakerEvent){
        when(event){
            is SaveEvent -> {
                save(event.characteristicList)
            }
            is LoadEvent -> {
                load()
            }
        }
    }

    private fun save(characteristicList: List<Characteristic>){
        saveCharacteristicUseCase.saveAll(characteristicList)

        // Если save() вызывается не в onStop
        // или сохраняет только какие-то одни параметры,
        // то надо реализовать пересоздание PersonMakerState

    }

    private fun load(){
        val characteristicList: List<Characteristic> = getCharacteristicUseCase.all

        stateDataMutable = PersonMakerState(
            characteristicList
        )
    }

    override fun onCleared() {
        // CODE
        super.onCleared()
    }


}