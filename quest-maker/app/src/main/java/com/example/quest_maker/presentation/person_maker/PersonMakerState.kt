package com.example.quest_maker.presentation.person_maker

import com.example.domain.models.Skill

data class PersonMakerState(
    val skillList: List<Skill>,
    val maxSkillScore: Int = 40,
    val minSkillScore: Int = 34
    // another lists
)