package com.khloud.FutureMovies.ui.fragments.details

import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.khloud.FutureMovies.R
import com.khloud.FutureMovies.data.model.CastItem
import com.khloud.FutureMovies.utils.downloadImage
import kotlinx.android.synthetic.main.movie_cast_rv.view.*

class MovieCastAdapter(private val castList: List<CastItem>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {

        return CastViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.movie_cast_rv,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is CastViewHolder -> {
                holder.bind(castList[position])
            }
        }
    }

    override fun getItemCount(): Int {
        return castList.size
    }


    class CastViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bind(item: CastItem) = with(itemView) {
            castImage.downloadImage(item.urlSmallImage, true)
            movieCastCard.setBackgroundResource(R.drawable.circle_shape)
            castName.text = item.name
        }
    }

}