package com.example.quest_maker.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.domain.models.Characteristic
import com.example.domain.models.CharacteristicList
import com.example.domain.usecase.GetCharacteristicUseCase
import com.example.domain.usecase.SaveCharacteristicUseCase

class PersonMakerViewModel(
    // (#!) - change to private
    public val getCharacteristicUseCase: GetCharacteristicUseCase,
    private val saveCharacteristicUseCase: SaveCharacteristicUseCase
) : ViewModel() {

    // (!)
    private val characteristicListLive = MutableLiveData<CharacteristicList>()
    //private val characteristicListLiveMutable = MutableLiveData<CharacteristicList>()
    //private val characteristicListLive = MutableLiveData<CharacteristicList>()

    fun saveCharacteristic(characteristic: Characteristic){
        val bool = saveCharacteristicUseCase.execute(characteristic)
    }

    /*fun getCharacteristic(characteristic: Characteristic){
        characteristicListLive.value = getCharacteristicUseCase.execute()
    }*/

    // (!) - сделать геттер при запуске активити или при ините. геттер не возвратный
    fun getCharacteristicListLive() : LiveData<CharacteristicList> {
        characteristicListLive.value = getCharacteristicUseCase.all;
        return characteristicListLive
    }

    override fun onCleared() {
        // CODE
        super.onCleared()
    }

}