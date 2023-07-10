package com.example.quest_maker.presentation.personMaker

import com.example.domain.models.InventoryItem
import com.example.domain.models.PersonItem

data class PersonMakerData(
    val skillList: List<PersonItem>,
    val mpList: List<PersonItem>,
    val itemList: List<InventoryItem>,

    val maxSkillScore: Int = 40,
    val minSkillScore: Int = 34,

    val maxHealth: Int = 21,
    val minHealth: Int = 13,
    val maxFND: Int = 10,
    val maxBullet: Int = 4,

    val maxItem: Int = 2

    // another lists
)