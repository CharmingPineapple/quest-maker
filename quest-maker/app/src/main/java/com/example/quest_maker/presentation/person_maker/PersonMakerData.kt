package com.example.quest_maker.presentation.person_maker

import com.example.domain.models.MainParameter
import com.example.domain.models.Skill

data class PersonMakerData(
    val skillList: List<Skill>,
    val mpList: List<MainParameter>,

    val maxSkillScore: Int = 40,
    val minSkillScore: Int = 34,

    val maxHealth: Int = 21,
    val minHealth: Int = 13,
    val maxFND: Int = 10,
    val maxBullet: Int = 4
    // another lists
)