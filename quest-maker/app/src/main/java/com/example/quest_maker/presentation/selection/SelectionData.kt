package com.example.quest_maker.presentation.selection

import com.example.domain.models.author.Item

data class SelectionData(
    val selectedItemList: List<Item>,

    val maxItem: Int = 4,
    val maxInjury: Int = 3

    // another lists
)