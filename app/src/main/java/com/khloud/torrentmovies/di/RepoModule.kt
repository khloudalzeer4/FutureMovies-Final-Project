package com.khloud.torrentmovies.di


import com.khloud.torrentmovies.data.source.cache.CacheSourceImpl
import com.khloud.torrentmovies.data.source.cache.ICacheSource
import com.khloud.torrentmovies.data.source.network.INetworkSource
import com.khloud.torrentmovies.data.source.network.NetworkSourceImpl
import com.khloud.torrentmovies.data.source.MainRepository
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