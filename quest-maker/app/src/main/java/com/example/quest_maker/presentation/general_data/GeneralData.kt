package com.example.quest_maker.presentation.general_data

import com.example.domain.models.viewer.Equipment
import com.example.domain.models.viewer.Weapon

data class GeneralData (
    val weaponList: List<Weapon>,
    val equipmentList: List<Equipment>,

    val typeItemList: List<String> = listOf("weapon", "equipment", "trinkets"),
    val typeInjuryList: List<String> = listOf("minor", "major")
    // another lists
)


