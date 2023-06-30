package com.example.quest_maker.viewModel

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.data.repository.AuthorRepositoryImplementation
import com.example.data.storage.database.DatabaseAuthorStorageImplementation
import com.example.domain.repository.AuthorRepositoryInterface
import com.example.domain.usecase.GetSkillUseCase
import com.example.domain.usecase.SaveSkillUseCase

class PersonMakerViewModelFactory(context: Context) : ViewModelProvider.Factory {

    private var databaseAuthorStorageImplementation: DatabaseAuthorStorageImplementation? =
        DatabaseAuthorStorageImplementation(context)

    private val authorRepositoryInterface: AuthorRepositoryInterface =
        AuthorRepositoryImplementation(databaseAuthorStorageImplementation)

    private val getSkillUseCase =
        GetSkillUseCase(authorRepositoryInterface)

    private val saveSkillUseCase =
        SaveSkillUseCase(authorRepositoryInterface)

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        //return super.create(modelClass)
        return PersonMakerViewModel(
            getSkillUseCase = getSkillUseCase,
            saveSkillUseCase = saveSkillUseCase
        ) as T
    }

}