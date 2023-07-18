package com.example.quest_maker.presentation.general_data

import androidx.lifecycle.ViewModel
import com.example.domain.models.viewer.Equipment
import com.example.domain.models.viewer.Weapon
import com.example.domain.usecase.viewer.equipment.GetEquipmentUseCase
import com.example.domain.usecase.viewer.weapon.GetWeaponUseCase

class GeneralDataViewModel (
    private val getWeaponUseCase: GetWeaponUseCase,
    private val getEquipmentUseCase: GetEquipmentUseCase
) : ViewModel() {

    private var dataMutable: GeneralData? = null

    fun getWeaponList() : List<Weapon>{
        return dataMutable!!.weaponList
    }

    fun getEquipmentList() : List<Equipment>{
        return dataMutable!!.equipmentList
    }

    fun load(){
        val weaponList: List<Weapon> = getWeaponUseCase.all
        val equipmentList: List<Equipment> = getEquipmentUseCase.all

        dataMutable = GeneralData(
            weaponList,
            equipmentList
        )
    }


}