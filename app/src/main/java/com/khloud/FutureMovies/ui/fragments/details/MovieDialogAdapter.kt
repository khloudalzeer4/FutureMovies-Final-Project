package com.khloud.FutureMovies.ui.fragments.details

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.khloud.FutureMovies.R
import com.khloud.FutureMovies.data.model.TorrentsDetails
import com.khloud.FutureMovies.utils.rv_listeners.QualityListener
import com.khloud.FutureMovies.utils.formatText
import kotlinx.android.synthetic.main.movie_quality_dialog_rv.view.*

class MovieDialogAdapter(private val qualityList: List<TorrentsDetails>,
                         private val movieName: String,
                         private val adapterListener: QualityListener
)
    : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {

        return DialogViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.movie_quality_dialog_rv,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is DialogViewHolder -> {
                holder.bind(qualityList[position])
            }
        }
    }

    override fun getItemCount(): Int {
        return qualityList.size
    }

    inner class DialogViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bind(item: TorrentsDetails) = with(itemView) {
            firstQualityTxt.formatText(R.string.movieQualityType,item.type, item.quality)
            qualityCard.setBackgroundResource(R.drawable.quality_card_view_shape)
            setOnClickListener { adapterListener.selectQuality(item.url!!, movieName)}
        }

    }


}