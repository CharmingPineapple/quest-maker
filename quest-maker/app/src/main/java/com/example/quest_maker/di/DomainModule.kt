package com.example.quest_maker.di

import com.example.domain.usecase.author.inventory.GetInventoryItemUseCase
import com.example.domain.usecase.author.main_parameter.GetMainParameterUseCase
import com.example.domain.usecase.author.skill.GetSkillUseCase
import com.example.domain.usecase.author.inventory.SaveInventoryItemUseCase
import com.example.domain.usecase.author.main_parameter.SaveMainParameterUseCase
import com.example.domain.usecase.author.skill.SaveSkillUseCase
import com.example.domain.usecase.author.status.GetPersonCurseUseCase
import com.example.domain.usecase.author.status.GetPersonInjuryUseCase
import com.example.domain.usecase.author.status.SavePersonCurseUseCase
import com.example.domain.usecase.author.status.SavePersonInjuryUseCase
import com.example.domain.usecase.viewer.equipment.GetEquipmentUseCase
import com.example.domain.usecase.viewer.status.GetCurseUseCase
import com.example.domain.usecase.viewer.status.GetInjuryUseCase
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


    // status and inventory

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

    factory<GetPersonCurseUseCase> {
        GetPersonCurseUseCase(get())
    }

    factory<SavePersonCurseUseCase> {
        SavePersonCurseUseCase(get())
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

    factory<GetCurseUseCase> {
        GetCurseUseCase(get())
    }

}
