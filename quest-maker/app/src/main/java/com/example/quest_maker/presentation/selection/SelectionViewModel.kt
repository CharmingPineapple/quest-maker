package com.example.quest_maker.presentation.selection

import androidx.lifecycle.ViewModel
import com.example.domain.models.InventoryItem
import com.example.domain.models.PersonItem
import com.example.domain.models.Weapon
import com.example.domain.usecase.inv_item.GetItemUseCase
import com.example.domain.usecase.inv_item.SaveItemUseCase
import com.example.domain.usecase.weapon.GetWeaponUseCase
import com.example.quest_maker.presentation.general_data.GeneralData

import com.example.quest_maker.presentation.person_maker.PersonMakerData

class SelectionViewModel (
    private val getItemUseCase: GetItemUseCase,
    private val saveItemUseCase: SaveItemUseCase,

    private val getWeaponUseCase: GetWeaponUseCase
) : ViewModel() {

    private var dataMutable: GeneralData? = null


    fun save(itemList: List<InventoryItem>){
        saveItemUseCase.saveAll(itemList)
    }



    private fun getWeaponList() : List<Weapon>{
        return dataMutable!!.weaponList
    }

    fun getSimpleWeaponList() : List<InventoryItem>{
        val weaponList : List<Weapon> = getWeaponList()
        val simpleWeaponList : MutableList<InventoryItem> = ArrayList()

        for(one: Weapon in weaponList){
            simpleWeaponList.add(InventoryItem(one.name, "weapon"))
        }

        return simpleWeaponList
    }

    fun load(){
        val weaponList: List<Weapon> = getWeaponUseCase.all

        dataMutable = GeneralData(
            weaponList
        )
    }

    override fun onCleared() {
        // CODE
        super.onCleared()
    }


}