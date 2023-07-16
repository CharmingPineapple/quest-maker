package com.example.quest_maker.presentation.selection

import androidx.lifecycle.ViewModel
import com.example.domain.models.InventoryItem
import com.example.domain.models.Weapon
import com.example.domain.usecase.inv_item.GetItemUseCase
import com.example.domain.usecase.inv_item.SaveItemUseCase
import com.example.domain.usecase.weapon.GetWeaponUseCase
import com.example.quest_maker.presentation.general_data.GeneralData

class SelectionViewModel (
    private val getItemUseCase: GetItemUseCase,
    private val saveItemUseCase: SaveItemUseCase,

    private val getWeaponUseCase: GetWeaponUseCase
) : ViewModel() {

    private var generalDataMutable: GeneralData? = null
    private var selectionDataMutable: SelectionData? = null


    fun save(itemList: List<InventoryItem>){
        saveItemUseCase.saveAll(itemList)
    }



    private fun getWeaponList() : List<Weapon>{
        return generalDataMutable!!.weaponList
    }

    // (!#)
    fun getSimpleItemList() : List<InventoryItem>{
        val weaponList : List<Weapon> = getWeaponList()
        //val equipmentList : List<Weapon> = getEquipmentList()
        //val trinketsList : List<Weapon> = getTrinketsList()

        val simpleItemList : MutableList<InventoryItem> = ArrayList()
        val selectedItemList: List<InventoryItem> = selectionDataMutable!!.selectedItemList

        // get all weapon from DB
        for(one: Weapon in weaponList){
            simpleItemList.add(InventoryItem(one.name, "weapon"))
        }

        /*for(one: Equipment in equipmentList){
            simpleItemList.add(InventoryItem(one.name, "equipment"))
        }*/

        /*for(one: Trinkets in trinketsList){
            simpleItemList.add(InventoryItem(one.name, "trinkets"))
        }*/

        // mark the selected weapon
        if (selectedItemList.isNotEmpty()) {
            for (count: Int in 0 until simpleItemList.size) {
                if (simpleItemList[count].name == selectedItemList[0].name)
                    simpleItemList[count].selected = true
            }
        }

        return simpleItemList
    }

    fun getSimpleWeaponList() : List<InventoryItem>{
        val weaponList : List<Weapon> = getWeaponList()
        val simpleWeaponList : MutableList<InventoryItem> = ArrayList()
        val selectedItemList: List<InventoryItem> = selectionDataMutable!!.selectedItemList

        // get all weapon from DB
        for(one: Weapon in weaponList){
            simpleWeaponList.add(InventoryItem(one.name, "weapon"))
        }

        // mark the selected weapon
        if (selectedItemList.isNotEmpty()) {
            for (count: Int in 0 until simpleWeaponList.size) {
                if (simpleWeaponList[count].name == selectedItemList[0].name)
                    simpleWeaponList[count].selected = true
            }
        }

        return simpleWeaponList
    }

    fun getTypeItemList(): List<String>{
        return generalDataMutable!!.typeItemList
    }

    fun getMaxInventoryItem() : Int{
        return selectionDataMutable!!.maxItem
    }

    fun load(){
        val weaponList: List<Weapon> = getWeaponUseCase.all
        val usingItemList: List<InventoryItem> = getItemUseCase.all

        generalDataMutable = GeneralData(
            weaponList
        )

        selectionDataMutable = SelectionData(
            usingItemList
        )
    }

    override fun onCleared() {
        // CODE
        super.onCleared()
    }


}