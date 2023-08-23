package com.example.quest_maker.presentation.selection

import androidx.lifecycle.ViewModel
import com.example.domain.models.author.Item
import com.example.domain.models.viewer.Equipment
import com.example.domain.models.viewer.Status
import com.example.domain.models.viewer.Trinket
import com.example.domain.models.viewer.Weapon
import com.example.domain.usecase.author.inventory.GetInventoryItemUseCase
import com.example.domain.usecase.author.status.GetPersonInjuryUseCase
import com.example.domain.usecase.author.inventory.SaveInventoryItemUseCase
import com.example.domain.usecase.author.status.GetPersonCurseUseCase
import com.example.domain.usecase.author.status.SavePersonCurseUseCase
import com.example.domain.usecase.author.status.SavePersonInjuryUseCase
import com.example.domain.usecase.viewer.equipment.GetEquipmentUseCase
import com.example.domain.usecase.viewer.status.GetCurseUseCase
import com.example.domain.usecase.viewer.status.GetInjuryUseCase
import com.example.domain.usecase.viewer.trinket.GetTrinketUseCase
import com.example.domain.usecase.viewer.weapon.GetWeaponUseCase
import com.example.quest_maker.presentation.general_data.GeneralData

class SelectionViewModel(
    private val getInventoryItemUseCase: GetInventoryItemUseCase,
    private val saveInventoryItemUseCase: SaveInventoryItemUseCase,

    private val getWeaponUseCase: GetWeaponUseCase,
    private val getEquipmentUseCase: GetEquipmentUseCase,
    private val getTrinketUseCase: GetTrinketUseCase,

    private val getPersonInjuryUseCase: GetPersonInjuryUseCase,
    private val savePersonInjuryUseCase: SavePersonInjuryUseCase,

    private val getInjuryUseCase: GetInjuryUseCase,

    private val getPersonCurseUseCase: GetPersonCurseUseCase,
    private val savePersonCurseUseCase: SavePersonCurseUseCase,


    private val getCurseUseCase: GetCurseUseCase

    ) : ViewModel() {

    private var generalDataMutable: GeneralData? = null
    private var selectionDataMutable: SelectionData? = null


    /*fun save(inventoryItemList: List<Item>, personInjuryList: List<Item>) {
        saveInventoryItemUseCase.saveAll(inventoryItemList)
        savePersonInjuryUseCase.saveAll(personInjuryList)
    }*/

    fun saveInventoryItem(itemList: List<Item>) {
        saveInventoryItemUseCase.saveAll(itemList)
    }

    fun savePersonInjury(itemList: List<Item>) {
        savePersonInjuryUseCase.saveAll(itemList)
    }
    fun savePersonCurse(itemList: List<Item>) {
        savePersonCurseUseCase.saveAll(itemList)
    }


    // get list from general data

    private fun getWeaponList(): List<Weapon> {
        return generalDataMutable!!.weaponList
    }

    private fun getEquipmentList(): List<Equipment> {
        return generalDataMutable!!.equipmentList
    }

    private fun getTrinketList(): List<Trinket> {
        return generalDataMutable!!.trinketList
    }

    private fun getInjuryList(): List<Status> {
        return generalDataMutable!!.injuryList
    }
    private fun getCurseList(): List<Status> {
        return generalDataMutable!!.curseList
    }

    // get simple list
    fun getSimpleInventoryItemList(): List<Item> {
        val weaponList: List<Weapon> = getWeaponList()
        val equipmentList: List<Equipment> = getEquipmentList()
        val trinketList : List<Trinket> = getTrinketList()

        val simpleItemList: MutableList<Item> = ArrayList()
        val selectedItemList: List<Item> = selectionDataMutable!!.selectedItemList

        // (!) - some hardcode (?) - maybe change to one.type
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

    fun getSimplePersonInjuryList(): List<Item> {
        val statusList: List<Status> = getInjuryList()

        val simpleInjuryList: MutableList<Item> = ArrayList()
        val selectedInjuryList: List<Item> = selectionDataMutable!!.selectedInjuryList

        // (!) - some hardcode
        for (one: Status in statusList) {
            simpleInjuryList.add(
                Item(
                    one.name,
                    one.type
                )
            )
        }

        if (selectedInjuryList.isNotEmpty()) {

            for (one: Item in selectedInjuryList) {
                simpleInjuryList[getIndexElement(simpleInjuryList, one)].selected = true
            }
        }

        return simpleInjuryList
    }

    fun getSimplePersonCurseList(): List<Item> {
        val statusList: List<Status> = getCurseList()

        val simpleCurseList: MutableList<Item> = ArrayList()
        val selectedCurseList: List<Item> = selectionDataMutable!!.selectedCurseList

        // (!) - some hardcode
        for (one: Status in statusList) {
            simpleCurseList.add(
                Item(
                    one.name,
                    one.type
                )
            )
        }

        if (selectedCurseList.isNotEmpty()) {

            for (one: Item in selectedCurseList) {
                simpleCurseList[getIndexElement(simpleCurseList, one)].selected = true
            }
        }

        return simpleCurseList
    }


    private fun getIndexElement(list: List<Item>, element: Item): Int {
        for (one: Item in list) {
            if (one.name == element.name) {
                return list.indexOf(one)
            }
        }

        return -1
    }


    // type
    fun getTypeInventoryItemList(): List<String> {
        return generalDataMutable!!.typeItemList
    }
    fun getTypePersonInjuryList(): List<String> {
        return generalDataMutable!!.typeInjuryList
    }
    fun getTypePersonCurseList(): List<String> {
        return generalDataMutable!!.typeCurseList
    }

    // max count
    fun getMaxInventoryItem(): Int {
        return selectionDataMutable!!.maxItem
    }

    fun getMaxPersonInjury(): Int {
        return selectionDataMutable!!.maxInjury
    }

    fun getMaxPersonCurse(): Int {
        return selectionDataMutable!!.maxCurse
    }

    fun load() {
        val weaponList: List<Weapon> = getWeaponUseCase.all
        val equipmentList: List<Equipment> = getEquipmentUseCase.all
        val trinketList: List<Trinket> = getTrinketUseCase.all
        val injuryList: List<Status> = getInjuryUseCase.all
        val curseList: List<Status> = getCurseUseCase.all


        val selectedItemList: List<Item> = getInventoryItemUseCase.all
        val selectedInjuryList: List<Item> = getPersonInjuryUseCase.all
        val selectedCurseList: List<Item> = getPersonCurseUseCase.all

        generalDataMutable = GeneralData(
            weaponList,
            equipmentList,
            trinketList,
            injuryList,
            curseList
        )

        selectionDataMutable = SelectionData(
            selectedItemList,
            selectedInjuryList,
            selectedCurseList
        )
    }




    override fun onCleared() {
// CODE
        super.onCleared()
    }


}