package com.khloud.FutureMovies.di


import com.khloud.FutureMovies.data.source.cache.CacheSourceImpl
import com.khloud.FutureMovies.data.source.cache.ICacheSource
import com.khloud.FutureMovies.data.source.network.INetworkSource
import com.khloud.FutureMovies.data.source.network.NetworkSourceImpl
import com.khloud.FutureMovies.data.source.MainRepository
import org.koin.dsl.module

val repoModule = module {

    single {
        MainRepository(
            get(),
            get()
        )
    }

    factory<INetworkSource> {
        NetworkSourceImpl(
            get()
        )
    }

    factory<ICacheSource> {
        CacheSourceImpl(
            get(),
            get()
        )
    }


}