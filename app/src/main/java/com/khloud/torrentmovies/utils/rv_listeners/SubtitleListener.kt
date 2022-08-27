package com.khloud.torrentmovies.utils.rv_listeners

import com.masterwok.opensubtitlesandroid.models.OpenSubtitleItem

interface SubtitleListener {

    fun onSubtitleClicked(subtitle: OpenSubtitleItem)
}