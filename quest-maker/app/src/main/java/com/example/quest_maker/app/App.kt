package com.example.quest_maker.app

import android.app.Application
import com.example.quest_maker.di.appModule
import com.example.quest_maker.di.dataModule
import com.example.quest_maker.di.domainModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class App : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            // (?) - androidLogger(Level.DEBUG) выдаёт ошибку, а ERROR Работает без проблем
            androidLogger(Level.ERROR)
            androidContext(this@App)
            modules(listOf(appModule, domainModule, dataModule))
        }

    }

}