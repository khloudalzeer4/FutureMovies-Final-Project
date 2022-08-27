package com.khloud.FutureMovies.di

import com.khloud.FutureMovies.ui.fragments.explore.ExploreViewModel
import com.khloud.FutureMovies.ui.fragments.details.DetailsViewModel
import com.khloud.FutureMovies.ui.fragments.favorites.FavoriteViewModel
import com.khloud.FutureMovies.ui.fragments.rank.RankViewModel
import com.khloud.FutureMovies.ui.fragments.stream.StreamViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {

    viewModel { ExploreViewModel(get()) }
    viewModel { DetailsViewModel(get()) }
    viewModel { StreamViewModel(get(), get()) }
    viewModel { RankViewModel(get()) }
    viewModel { FavoriteViewModel(get()) }
}