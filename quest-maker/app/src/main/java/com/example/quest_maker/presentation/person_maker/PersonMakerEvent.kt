package com.example.quest_maker.presentation.person_maker

import com.example.domain.models.Skill

interface PersonMakerEvent

class SaveEvent(val skillList: List<Skill>): PersonMakerEvent

class LoadEvent(): PersonMakerEvent
