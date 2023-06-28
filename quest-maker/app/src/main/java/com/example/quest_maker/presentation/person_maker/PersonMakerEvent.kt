package com.example.quest_maker.presentation.person_maker

import com.example.domain.models.Characteristic
import com.example.domain.models.CharacteristicList

interface PersonMakerEvent

class SaveEvent(val characteristicList: List<Characteristic>): PersonMakerEvent

class LoadEvent(): PersonMakerEvent
