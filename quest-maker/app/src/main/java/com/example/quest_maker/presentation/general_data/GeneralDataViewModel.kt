package com.example.quest_maker.presentation.general_data

import androidx.lifecycle.ViewModel
import com.example.domain.models.viewer.Equipment
import com.example.domain.models.viewer.Injury
import com.example.domain.models.viewer.Trinket
import com.example.domain.models.viewer.Weapon
import com.example.domain.usecase.viewer.equipment.GetEquipmentUseCase
import com.example.domain.usecase.viewer.injury.GetInjuryUseCase
import com.example.domain.usecase.viewer.trinket.GetTrinketUseCase
import com.example.domain.usecase.viewer.weapon.GetWeaponUseCase

class GeneralDataViewModel (
    private val getWeaponUseCase: GetWeaponUseCase,
    private val getEquipmentUseCase: GetEquipmentUseCase,
    private val getTrinketUseCase : GetTrinketUseCase,
    private val getInjuryUseCase : GetInjuryUseCase

    ) : ViewModel() {

    private var generalDataMutable: GeneralData? = null

    fun getWeaponList() : List<Weapon>{
        return generalDataMutable!!.weaponList
    }

    fun getEquipmentList() : List<Equipment>{
        return generalDataMutable!!.equipmentList
    }


    fun getTrinketList() : List<Trinket>{
        return generalDataMutable!!.trinketList
    }

    fun getTypeItemList(): List<String> {
        return generalDataMutable!!.typeItemList
    }

    fun getInjuryList() : List<Injury>{
        return generalDataMutable!!.injuryList
    }
    fun getTypeInjuryList(): List<String> {
        return generalDataMutable!!.typeInjuryList
    }

    fun load(){
        val weaponList: List<Weapon> = getWeaponUseCase.all
        val equipmentList: List<Equipment> = getEquipmentUseCase.all
        val trinketList: List<Trinket> = getTrinketUseCase.all
        val injuryList: List<Injury> = getInjuryUseCase.all

        generalDataMutable = GeneralData(
            weaponList,
            equipmentList,
            trinketList,
            injuryList
        )
    }


}