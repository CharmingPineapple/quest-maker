package com.example.quest_maker.presentation.selection

import com.example.domain.models.InventoryItem
import com.example.domain.models.PersonItem

data class SelectionData(
    val itemList: List<InventoryItem>,

    val maxItem: Int = 4

    // another lists
)