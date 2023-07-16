package com.example.quest_maker.presentation.selection

import com.example.domain.models.InventoryItem

data class SelectionData(
    val selectedItemList: List<InventoryItem>,

    val maxItem: Int = 4,
    val maxInjury: Int = 3

    // another lists
)