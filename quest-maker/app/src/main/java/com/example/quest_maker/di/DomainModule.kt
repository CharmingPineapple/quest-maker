package com.example.quest_maker.di

import com.example.domain.usecase.author.status_item.GetInventoryItemUseCase
import com.example.domain.usecase.author.main_parameter.GetMainParameterUseCase
import com.example.domain.usecase.author.skill.GetSkillUseCase
import com.example.domain.usecase.author.status_item.SaveInventoryItemUseCase
import com.example.domain.usecase.author.main_parameter.SaveMainParameterUseCase
import com.example.domain.usecase.author.skill.SaveSkillUseCase
import com.example.domain.usecase.author.status_item.GetPersonInjuryUseCase
import com.example.domain.usecase.author.status_item.SavePersonInjuryUseCase
import com.example.domain.usecase.viewer.equipment.GetEquipmentUseCase
import com.example.domain.usecase.viewer.injury.GetInjuryUseCase
import com.example.domain.usecase.viewer.trinket.GetTrinketUseCase
import com.example.domain.usecase.viewer.weapon.GetWeaponUseCase
import org.koin.dsl.module


val domainModule = module {

    // main parameters

    factory<GetSkillUseCase> {
        GetSkillUseCase(get())
    }

    factory<SaveSkillUseCase> {
        SaveSkillUseCase(get())
    }

    factory<GetMainParameterUseCase> {
        GetMainParameterUseCase(
            get()
        )
    }

    factory<SaveMainParameterUseCase> {
        SaveMainParameterUseCase(
            get()
        )
    }


    // status item

    factory<GetInventoryItemUseCase> {
        GetInventoryItemUseCase(get())
    }

    factory<SaveInventoryItemUseCase> {
        SaveInventoryItemUseCase(get())
    }

    factory<GetPersonInjuryUseCase> {
        GetPersonInjuryUseCase(get())
    }

    factory<SavePersonInjuryUseCase> {
        SavePersonInjuryUseCase(get())
    }

    // general data

    factory<GetWeaponUseCase> {
        GetWeaponUseCase(get())
    }

    factory<GetEquipmentUseCase> {
        GetEquipmentUseCase(get())
    }

    factory<GetTrinketUseCase> {
        GetTrinketUseCase(get())
    }

    factory<GetInjuryUseCase> {
        GetInjuryUseCase(get())
    }

}
