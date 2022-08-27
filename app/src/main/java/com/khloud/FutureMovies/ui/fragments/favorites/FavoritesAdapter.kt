package com.khloud.FutureMovies.ui.fragments.favorites

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.like.LikeButton
import com.like.OnLikeListener
import com.khloud.FutureMovies.R
import com.khloud.FutureMovies.data.model.FavoriteMovie
import com.khloud.FutureMovies.utils.downloadImage
import com.khloud.FutureMovies.utils.rv_listeners.FavoriteListener
import kotlinx.android.synthetic.main.favorite_layout_rv.view.*

class FavoritesAdapter(private val favoriteListener: FavoriteListener) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private val favoritesList: MutableList<FavoriteMovie> = mutableListOf()
    var lastPosition = 0
    private set

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {

        return FavoriteViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.favorite_layout_rv,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is FavoriteViewHolder -> {
                holder.bind(favoritesList[position])
            }
        }
    }

    override fun getItemCount(): Int {
        return favoritesList.size
    }

    fun addFavList(list: List<FavoriteMovie>) {
        favoritesList.apply {
            clear()
            addAll(list)
            notifyItemRangeChanged(lastPosition, favoritesList.size)
        }
    }

    fun getMovieCover(pos: Int): String {
        return try {
            favoritesList[pos].mediumCoverImage!!
        }catch (e: IndexOutOfBoundsException){
            favoritesList[0].mediumCoverImage!!
        }
    }

    inner class FavoriteViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bind(item: FavoriteMovie) = with(itemView) {
            favMovieCover.apply {
                downloadImage(item.mediumCoverImage)
                transitionName = item.backgroundImageOriginal
            }
            favMovieName.text = item.titleEnglish
            favMovie.apply {
                isLiked = true
                setOnLikeListener(object : OnLikeListener {
                    override fun liked(likeButton: LikeButton?) {
                    }

                    override fun unLiked(likeButton: LikeButton?) {
                        lastPosition = adapterPosition
                        favoriteListener.onDeleteFavMovie(item.id!!)
                    }
                })
            }
            setOnClickListener { favoriteListener.onMovieClicked(item.id!!, favMovieCover) }
        }
    }
}


