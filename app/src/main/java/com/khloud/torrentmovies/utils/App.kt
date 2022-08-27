package com.khloud.torrentmovies.utils

import android.app.Application
import com.khloud.torrentmovies.di.*
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin


class App : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@App)
            modules(listOf(networkModule, cacheModule, repoModule, viewModelModule, viewsModule))
        }
    }
}