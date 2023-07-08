package com.example.quest_maker.di

import com.example.domain.usecase.GetItemUseCase
import com.example.domain.usecase.GetMainParameterUseCase
import com.example.domain.usecase.GetSkillUseCase
import com.example.domain.usecase.SaveItemUseCase
import com.example.domain.usecase.SaveMainParameterUseCase
import com.example.domain.usecase.SaveSkillUseCase
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

}
