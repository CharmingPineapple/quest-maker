package com.example.quest_maker.di

import com.example.domain.usecase.author.inv_item.GetItemUseCase
import com.example.domain.usecase.author.main_parameter.GetMainParameterUseCase
import com.example.domain.usecase.author.skill.GetSkillUseCase
import com.example.domain.usecase.author.inv_item.SaveItemUseCase
import com.example.domain.usecase.author.main_parameter.SaveMainParameterUseCase
import com.example.domain.usecase.author.skill.SaveSkillUseCase
import com.example.domain.usecase.viewer.equipment.GetEquipmentUseCase
import com.example.domain.usecase.viewer.weapon.GetWeaponUseCase
import org.koin.dsl.module


val domainModule = module {

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

    factory<GetItemUseCase> {
        GetItemUseCase(get())
    }

    factory<SaveItemUseCase> {
        SaveItemUseCase(get())
    }

    factory<GetWeaponUseCase> {
        GetWeaponUseCase(get())
    }

    factory<GetEquipmentUseCase> {
        GetEquipmentUseCase(get())
    }

}
