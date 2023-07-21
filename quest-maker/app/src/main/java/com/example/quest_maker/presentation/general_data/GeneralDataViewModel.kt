package com.example.quest_maker.presentation.general_data

import androidx.lifecycle.ViewModel
import com.example.domain.models.viewer.Equipment
import com.example.domain.models.viewer.Status
import com.example.domain.models.viewer.Trinket
import com.example.domain.models.viewer.Weapon
import com.example.domain.usecase.viewer.equipment.GetEquipmentUseCase
import com.example.domain.usecase.viewer.status.GetCurseUseCase
import com.example.domain.usecase.viewer.status.GetInjuryUseCase
import com.example.domain.usecase.viewer.trinket.GetTrinketUseCase
import com.example.domain.usecase.viewer.weapon.GetWeaponUseCase

class GeneralDataViewModel (
    private val getWeaponUseCase: GetWeaponUseCase,
    private val getEquipmentUseCase: GetEquipmentUseCase,
    private val getTrinketUseCase : GetTrinketUseCase,
    private val getInjuryUseCase : GetInjuryUseCase,
    private val getCurseUseCase : GetCurseUseCase

    ) : ViewModel() {

    private var generalDataMutable: GeneralData? = null

    // inventory list
    fun getWeaponList() : List<Weapon>{
        return generalDataMutable!!.weaponList
    }

    fun getEquipmentList() : List<Equipment>{
        return generalDataMutable!!.equipmentList
    }


    fun getTrinketList() : List<Trinket>{
        return generalDataMutable!!.trinketList
    }

    // status list
    fun getInjuryList() : List<Status>{
        return generalDataMutable!!.injuryList
    }

    fun getCurseList() : List<Status>{
        return generalDataMutable!!.curseList
    }


    // type list
    fun getTypeItemList(): List<String> {
        return generalDataMutable!!.typeItemList
    }
    fun getTypeInjuryList(): List<String> {
        return generalDataMutable!!.typeInjuryList
    }
    fun getTypeCurseList(): List<String> {
        return generalDataMutable!!.typeCurseList
    }

    fun load(){
        val weaponList: List<Weapon> = getWeaponUseCase.all
        val equipmentList: List<Equipment> = getEquipmentUseCase.all
        val trinketList: List<Trinket> = getTrinketUseCase.all
        val injuryList: List<Status> = getInjuryUseCase.all
        val curseList: List<Status> = getCurseUseCase.all

        generalDataMutable = GeneralData(
            weaponList,
            equipmentList,
            trinketList,
            injuryList,
            curseList
        )
    }


}