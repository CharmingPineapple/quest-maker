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
    private val getCharacteristicUseCase: GetCharacteristicUseCase,
    private val saveCharacteristicUseCase: SaveCharacteristicUseCase
) : ViewModel() {

    private var characteristicListLiveMutable = MutableLiveData<MutableList<Characteristic>>()
    var characteristicListLive: LiveData<MutableList<Characteristic>> = characteristicListLiveMutable

    fun saveCharacteristic(characteristic: Characteristic){
        val bool = saveCharacteristicUseCase.execute(characteristic)
    }

    fun load(){
        characteristicListLiveMutable.value = getCharacteristicUseCase.all.getList()
    }

    override fun onCleared() {
        // CODE
        super.onCleared()
    }
    

}