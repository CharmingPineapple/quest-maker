package com.example.quest_maker.presentation.selection

import com.example.domain.models.author.Item

data class SelectionData(
    val selectedItemList: List<Item>,
    val selectedInjuryList: List<Item>,
    val selectedCurseList: List<Item>,

    val maxItem: Int = 4,
    val maxInjury: Int = 3,
    val maxCurse: Int = 4

    // another lists
)