package com.example.movie.ui.fragment.popular.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.movie.R
import com.example.movie.data.model.Category
import com.example.movie.databinding.LayoutItemCardPopularBinding
import com.example.movie.ui.fragment.home.adapter.OnClickListener
import com.example.movie.utils.loadImage

class PopularAdapter(
    private val list: List<Category>,
    private val listener: OnClickListener,
) : RecyclerView.Adapter<PopularAdapter.PopularViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PopularViewHolder {
        return PopularViewHolder(
            DataBindingUtil.inflate(
                LayoutInflater.from(parent.context),
                R.layout.layout_item_card_popular, parent, false
            )
        )
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: PopularViewHolder, position: Int) {
        val popular = list[position]
        holder.binder.apply {

//            if (position == list.size - 1)
//                showMore.visibility = View.VISIBLE

            posterPopular.loadImage(popular.posterId)
            titleMS.text = popular.title
            popular.type.type.forEach {
                type.text = "${it}, "
            }
            rating.rating = popular.rate
            date.text = "2022"

        }
    }

    override fun getItemCount() = list.size


    inner class PopularViewHolder(val binder: LayoutItemCardPopularBinding) :
        RecyclerView.ViewHolder(binder.root) {
    }
}