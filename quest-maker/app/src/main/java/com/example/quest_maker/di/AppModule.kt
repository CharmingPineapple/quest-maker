package com.example.quest_maker.di

import com.example.domain.usecase.viewer.status.GetCurseUseCase
import com.example.quest_maker.presentation.general_data.GeneralDataViewModel
import com.example.quest_maker.presentation.person_maker.PersonMakerViewModel
import com.example.quest_maker.presentation.selection.SelectionViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {

    viewModel<PersonMakerViewModel>{
        PersonMakerViewModel(
            getSkillUseCase = get(),
            saveSkillUseCase = get(),

            getMainParameterUseCase = get(),
            saveMainParameterUseCase = get(),

            getInventoryItemUseCase = get(),
            saveInventoryItemUseCase = get(),

            getPersonInjuryUseCase = get(),
            savePersonInjuryUseCase = get(),

            getPersonCurseUseCase = get(),
            savePersonCurseUseCase = get()
        )
    }

    viewModel<GeneralDataViewModel>{
        GeneralDataViewModel(
            getWeaponUseCase = get(),
            getEquipmentUseCase = get(),
            getTrinketUseCase = get(),
            getInjuryUseCase = get(),
            getCurseUseCase = get()
        )
    }

    viewModel<SelectionViewModel>{
        SelectionViewModel(
            getInventoryItemUseCase = get(),
            saveInventoryItemUseCase = get(),

            getWeaponUseCase = get(),
            getEquipmentUseCase = get(),
            getTrinketUseCase = get(),

            getInjuryUseCase = get(),

            getPersonInjuryUseCase = get(),
            savePersonInjuryUseCase = get(),

            getCurseUseCase = get(),

            getPersonCurseUseCase = get(),
            savePersonCurseUseCase = get()
        )
    }



}