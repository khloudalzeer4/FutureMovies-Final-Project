package com.khloud.FutureMovies.di

import androidx.room.Room
import com.khloud.FutureMovies.data.source.cache.MoviesDatabase
import com.khloud.FutureMovies.utils.Constants
import org.koin.dsl.module

val cacheModule = module {

    single {
        Room.databaseBuilder(get(), MoviesDatabase::class.java, Constants.DATABASE_NAME)
            .fallbackToDestructiveMigration()
            .build()
    }


    single { get<MoviesDatabase>().getMoviesDao() }

    single { get<MoviesDatabase>().getFavoriteDao() }
}