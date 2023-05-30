package com.sajjadio.trailers.ui.details

import android.annotation.SuppressLint
import android.view.ViewGroup
import com.sajjadio.trailers.BR
import com.sajjadio.trailers.R
import com.sajjadio.trailers.data.model.movie.actors.Actors
import com.sajjadio.trailers.data.model.movie.id.IDMovie
import com.sajjadio.trailers.data.model.movie.similar.Similar
import com.sajjadio.trailers.ui.base.BaseAdapter
import com.sajjadio.trailers.ui.base.BaseInteractListener

class DetailsAdapter(
    val listener: DetailsInteractListener
) : BaseAdapter<DetailsItem>(listOf(), listener) {

    override var layoutId: Int = 0

    @SuppressLint("NotifyDataSetChanged")
    fun addNestedItem(newItem: List<DetailsItem>) {
        setItems(newItem.sortedBy { it.rank })
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder {
        layoutId = getLayoutId(viewType)
        return super.onCreateViewHolder(parent, viewType)
    }

    private fun getLayoutId(viewType: Int): Int {
        return when (viewType) {
            LAYOUT_MOVIE -> LAYOUT_MOVIE
            LAYOUT_ACTORS -> LAYOUT_ACTORS
            LAYOUT_SIMILAR -> LAYOUT_SIMILAR
            else -> throw Exception("unknown view type")
        }
    }

    override fun onBindViewHolder(holder: BaseViewHolder, position: Int) {
        when (val currentItem = getItems()[position]) {
            is DetailsItem.MovieItem -> bindMovieItem(holder as ItemViewHolder, currentItem.movie)
            is DetailsItem.ActorItem -> bindActorItem(holder as ItemViewHolder, currentItem.actors)
            is DetailsItem.SimilarItem -> bindSimilarItem(
                holder as ItemViewHolder,
                currentItem.similar
            )
        }
    }

    private fun bindMovieItem(holder: ItemViewHolder, item: IDMovie) {
        holder.binding.setVariable(BR.item, item)
    }

    private fun bindActorItem(holder: ItemViewHolder, items: Actors) {
        holder.binding.apply {
            setVariable(BR.adapter, items.cast?.let { ActorsAdapter(it, listener) })
            setVariable(BR.listener, listener)
        }
    }

    private fun bindSimilarItem(holder: ItemViewHolder, items: Similar) {
        holder.binding.apply {
            setVariable(BR.adapter, items.results?.let { SimilarAdapter(it, listener) })
            setVariable(BR.listener, listener)
        }
    }

    override fun getItemViewType(position: Int): Int {
        return when (getItems()[position]) {
            is DetailsItem.MovieItem -> LAYOUT_MOVIE
            is DetailsItem.ActorItem -> LAYOUT_ACTORS
            is DetailsItem.SimilarItem -> LAYOUT_SIMILAR
        }
    }

    private companion object {
        const val LAYOUT_MOVIE = R.layout.layout_details_item
        const val LAYOUT_ACTORS = R.layout.layout_recycler_actor
        const val LAYOUT_SIMILAR = R.layout.layout_recycler_similar
    }
}

interface DetailsInteractListener : BaseInteractListener {
    fun onSeeAllActorsClick()
    fun onActorItemClick(id: Int)
    fun onSeeAllSimilarClick()
}