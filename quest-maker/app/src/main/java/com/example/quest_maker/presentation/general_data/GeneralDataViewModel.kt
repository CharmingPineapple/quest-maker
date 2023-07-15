package com.example.quest_maker.presentation.general_data

import androidx.lifecycle.ViewModel
import com.example.domain.models.InventoryItem
import com.example.domain.models.PersonItem
import com.example.domain.models.Weapon
import com.example.domain.usecase.inv_item.GetItemUseCase
import com.example.domain.usecase.inv_item.SaveItemUseCase
import com.example.domain.usecase.main_parameter.GetMainParameterUseCase
import com.example.domain.usecase.main_parameter.SaveMainParameterUseCase
import com.example.domain.usecase.skill.GetSkillUseCase
import com.example.domain.usecase.skill.SaveSkillUseCase
import com.example.domain.usecase.weapon.GetWeaponUseCase
import com.example.quest_maker.presentation.general_data.GeneralData
import com.example.quest_maker.presentation.person_maker.PersonMakerData

class GeneralDataViewModel (
    private val getWeaponUseCase: GetWeaponUseCase
) : ViewModel() {

    private var dataMutable: GeneralData? = null

    fun getWeaponList() : List<Weapon>{
        return dataMutable!!.weaponList
    }

    fun load(){
        val weaponList: List<Weapon> = getWeaponUseCase.all

        dataMutable = GeneralData(
            weaponList
        )
    }


}