package com.example.quest_maker.di

import com.example.domain.usecase.GetSkillUseCase
import com.example.quest_maker.viewModel.PersonMakerViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {

    viewModel<PersonMakerViewModel>{
        PersonMakerViewModel(
            getSkillUseCase = get(),
            saveSkillUseCase = get(),
            getMainParameterUseCase = get(),
            saveMainParameterUseCase = get()
        )
    }



}