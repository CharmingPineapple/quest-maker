package com.example.quest_maker.presentation.person_maker

import com.example.domain.models.author.Item
import com.example.domain.models.author.PersonItem

data class PersonMakerData(
    val skillList: List<PersonItem>,
    val mpList: List<PersonItem>,
    val inventoryItemList: List<Item>,
    val personInjuryList: List<Item>,

    val maxSkillScore: Int = 40,
    val minSkillScore: Int = 34,

    val maxHealth: Int = 21,
    val minHealth: Int = 13,
    val maxFND: Int = 10,
    val maxBullet: Int = 4

    //val maxItem: Int = 4

    // another lists
)