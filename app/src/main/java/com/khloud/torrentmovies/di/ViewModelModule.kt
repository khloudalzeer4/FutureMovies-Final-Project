package com.khloud.torrentmovies.di

import com.khloud.torrentmovies.ui.fragments.explore.ExploreViewModel
import com.khloud.torrentmovies.ui.fragments.details.DetailsViewModel
import com.khloud.torrentmovies.ui.fragments.favorites.FavoriteViewModel
import com.khloud.torrentmovies.ui.fragments.rank.RankViewModel
import com.khloud.torrentmovies.ui.fragments.stream.StreamViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {

    viewModel { ExploreViewModel(get()) }
    viewModel { DetailsViewModel(get()) }
    viewModel { StreamViewModel(get(), get()) }
    viewModel { RankViewModel(get()) }
    viewModel { FavoriteViewModel(get()) }
}