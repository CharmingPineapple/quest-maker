package com.example.quest_maker.viewModel

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.data.repository.AuthorRepositoryImplementation
import com.example.data.storage.database.DatabaseAuthorStorageImplementation
import com.example.domain.repository.AuthorRepositoryInterface
import com.example.domain.usecase.GetCharacteristicUseCase
import com.example.domain.usecase.SaveCharacteristicUseCase

class PersonMakerViewModelFactory(context: Context) : ViewModelProvider.Factory {

    private var databaseAuthorStorageImplementation: DatabaseAuthorStorageImplementation? =
        DatabaseAuthorStorageImplementation(context)

    private val authorRepositoryInterface: AuthorRepositoryInterface =
        AuthorRepositoryImplementation(databaseAuthorStorageImplementation)

    private val getCharacteristicUseCase = GetCharacteristicUseCase(authorRepositoryInterface)

    private val saveCharacteristicUseCase = SaveCharacteristicUseCase(authorRepositoryInterface)

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        //return super.create(modelClass)
        return PersonMakerViewModel(
            getCharacteristicUseCase = getCharacteristicUseCase,
            saveCharacteristicUseCase = saveCharacteristicUseCase
        ) as T
    }

}