package com.example.quest_maker.presentation.general_data

import com.example.domain.models.viewer.Equipment
import com.example.domain.models.viewer.Injury
import com.example.domain.models.viewer.Trinket
import com.example.domain.models.viewer.Weapon

data class GeneralData (
    val weaponList: List<Weapon>,
    val equipmentList: List<Equipment>,
    val trinketList: List<Trinket>,
    val injuryList: List<Injury>,

    val typeItemList: List<String> = listOf("weapon", "equipment", "trinket"),
    val typeInjuryList: List<String> = listOf("minor", "major")
    // another lists
)


