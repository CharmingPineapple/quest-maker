package com.example.quest_maker.presentation.selection

import androidx.lifecycle.ViewModel
import com.example.domain.models.author.Item
import com.example.domain.models.viewer.Equipment
import com.example.domain.models.viewer.Injury
import com.example.domain.models.viewer.Trinket
import com.example.domain.models.viewer.Weapon
import com.example.domain.usecase.author.inv_item.GetItemUseCase
import com.example.domain.usecase.author.inv_item.SaveItemUseCase
import com.example.domain.usecase.viewer.equipment.GetEquipmentUseCase
import com.example.domain.usecase.viewer.injury.GetInjuryUseCase
import com.example.domain.usecase.viewer.trinket.GetTrinketUseCase
import com.example.domain.usecase.viewer.weapon.GetWeaponUseCase
import com.example.quest_maker.presentation.general_data.GeneralData

class SelectionViewModel(
    private val getItemUseCase: GetItemUseCase,
    private val saveItemUseCase: SaveItemUseCase,

    private val getWeaponUseCase: GetWeaponUseCase,
    private val getEquipmentUseCase: GetEquipmentUseCase,
    private val getTrinketUseCase: GetTrinketUseCase,

    private val getInjuryUseCase: GetInjuryUseCase,
) : ViewModel() {

    private var generalDataMutable: GeneralData? = null
    private var selectionDataMutable: SelectionData? = null


    fun save(itemList: List<Item>) {
        saveItemUseCase.saveAll(itemList)
    }

    fun saveInvItem(itemList: List<Item>) {
        saveItemUseCase.saveAll(itemList)
    }


    private fun getWeaponList(): List<Weapon> {
        return generalDataMutable!!.weaponList
    }

    private fun getEquipmentList(): List<Equipment> {
        return generalDataMutable!!.equipmentList
    }

    private fun getTrinketList(): List<Trinket> {
        return generalDataMutable!!.trinketList
    }

    private fun getInjuryList(): List<Injury> {
        return generalDataMutable!!.injuryList
    }

    // (!#)
    fun getSimpleItemList(): List<Item> {
        val weaponList: List<Weapon> = getWeaponList()
        val equipmentList: List<Equipment> = getEquipmentList()
        val trinketList : List<Trinket> = getTrinketList()

        val simpleItemList: MutableList<Item> = ArrayList()
        val selectedItemList: List<Item> = selectionDataMutable!!.selectedItemList


        // (!) - some hardcode
        // get all weapon from DB
        for (one: Weapon in weaponList) {
            simpleItemList.add(
                Item(
                    one.name,
                    "weapon"
                )
            )
        }

        for (one: Equipment in equipmentList) {
            simpleItemList.add(
                Item(
                    one.name,
                    "equipment"
                )
            )
        }

        for(one: Trinket in trinketList){
            simpleItemList.add(
                Item(
                    one.name,
                    "trinket"
                )
            )
        }

        // mark the selected weapon
        if (selectedItemList.isNotEmpty()) {

            for (one: Item in selectedItemList) {
                simpleItemList[getIndexElement(simpleItemList, one)].selected = true
            }
        }

        return simpleItemList
    }

    /*fun getSimpleWeaponList(): List<InventoryItem> {
        val weaponList: List<Weapon> = getWeaponList()
        val simpleWeaponList: MutableList<InventoryItem> = ArrayList()
        val selectedItemList: List<InventoryItem> = selectionDataMutable!!.selectedItemList

        // get all weapon from DB
        for (one: Weapon in weaponList) {
            simpleWeaponList.add(
                InventoryItem(
                    one.name,
                    "weapon"
                )
            )
        }

        if (selectedItemList.isNotEmpty()) {

            for (one: InventoryItem in selectedItemList) {
                simpleWeaponList[getIndexElement(simpleWeaponList, one)].selected = true
            }
        }

        return simpleWeaponList
    }*/

    private fun getIndexElement(list: List<Item>, element: Item): Int {
        for (one: Item in list) {
            if (one.name == element.name) {
                return list.indexOf(one)
            }
        }

        return 0
    }

    fun getTypeItemList(): List<String> {
        return generalDataMutable!!.typeItemList
    }

    fun getMaxInventoryItem(): Int {
        return selectionDataMutable!!.maxItem
    }

    fun load() {
        val weaponList: List<Weapon> = getWeaponUseCase.all
        val equipmentList: List<Equipment> = getEquipmentUseCase.all
        val trinketList: List<Trinket> = getTrinketUseCase.all
        val injuryList: List<Injury> = getInjuryUseCase.all


        val selectedItemList: List<Item> = getItemUseCase.all

        generalDataMutable = GeneralData(
            weaponList,
            equipmentList,
            trinketList,
            injuryList
        )

        selectionDataMutable = SelectionData(
            selectedItemList
        )
    }


    override fun onCleared() {
// CODE
        super.onCleared()
    }


}