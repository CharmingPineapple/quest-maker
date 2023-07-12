package com.example.quest_maker.di

import com.example.data.repository.AuthorRepositoryImplementation
import com.example.data.repository.ViewerRepositoryImplementation
import com.example.data.storage.AuthorStorageInterface
import com.example.data.storage.ViewerStorageInterface
import com.example.data.storage.database.DatabaseAuthorStorageImplementation
import com.example.data.storage.database.DatabaseViewerStorageImplementation
import com.example.domain.repository.AuthorRepositoryInterface
import com.example.domain.repository.ViewerRepositoryInterface
import org.koin.dsl.module


/*private var databaseAuthorStorageImplementation: DatabaseAuthorStorageImplementation? =
    DatabaseAuthorStorageImplementation(context)

private val authorRepositoryInterface: AuthorRepositoryInterface =
    AuthorRepositoryImplementation(databaseAuthorStorageImplementation)*/

val dataModule = module {

    single<AuthorStorageInterface> {
        DatabaseAuthorStorageImplementation(get())
    }

    single<AuthorRepositoryInterface> {
        AuthorRepositoryImplementation(get())
    }

    single<ViewerStorageInterface>{
        DatabaseViewerStorageImplementation(get())
    }

    single<ViewerRepositoryInterface>{
        ViewerRepositoryImplementation(get())
    }

}