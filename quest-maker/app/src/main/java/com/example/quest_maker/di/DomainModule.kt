package com.example.quest_maker.di

import com.example.domain.usecase.inv_item.GetItemUseCase
import com.example.domain.usecase.main_parameter.GetMainParameterUseCase
import com.example.domain.usecase.skill.GetSkillUseCase
import com.example.domain.usecase.inv_item.SaveItemUseCase
import com.example.domain.usecase.main_parameter.SaveMainParameterUseCase
import com.example.domain.usecase.skill.SaveSkillUseCase
import com.example.domain.usecase.weapon.GetWeaponUseCase
import org.koin.dsl.module


/*
private val getSkillUseCase =
    GetSkillUseCase(authorRepositoryInterface)

private val saveSkillUseCase =
    SaveSkillUseCase(authorRepositoryInterface)*/

val domainModule = module {

    factory<GetSkillUseCase> {
        GetSkillUseCase(get())
    }

    factory<SaveSkillUseCase> {
        SaveSkillUseCase(get())
    }

    factory<GetMainParameterUseCase> {
        GetMainParameterUseCase(get())
    }

    factory<SaveMainParameterUseCase> {
        SaveMainParameterUseCase(get())
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

}
