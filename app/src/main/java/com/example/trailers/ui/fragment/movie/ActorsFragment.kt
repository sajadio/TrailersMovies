package com.example.trailers.ui.fragment.movie

import android.os.Bundle
import android.util.Log
import android.view.*
import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.GridLayoutManager
import com.example.trailers.R
import com.example.trailers.data.model.movie.actorsmovie.ActorsMovie
import com.example.trailers.databinding.FragmentActorsBinding
import com.example.trailers.ui.base.BaseFragment
import com.example.trailers.ui.fragment.movie.adapter.ActorsMovieAdapter
import com.example.trailers.ui.fragment.movie.viewModel.MovieViewModel
import com.example.trailers.utils.Constant.TAG
import com.example.trailers.utils.NetworkStatus
import com.example.trailers.utils.movieToDestination
import com.example.trailers.utils.setAsActionBar
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ActorsFragment : BaseFragment<FragmentActorsBinding>(R.layout.fragment_actors) {


    private val viewModel: MovieViewModel by viewModels()

    private val args: ActorsFragmentArgs by navArgs()


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.apply {

            activity?.setAsActionBar(
                toolbar = toolbar,
                isBack = true,
                title = args.info.original_name.toString())

            swiperefreshlayout.setOnRefreshListener {
                initialAdapter()
                swiperefreshlayout.isRefreshing = false
            }
        }

        initialAdapter()
    }

    private fun initialAdapter() {
        viewModel.getMovieOfActor(args.info.id)
        viewModel.actorsOfMovie.observe(viewLifecycleOwner) {
                stateManagement(it)
                it.data()?.cast?.let { cast ->
                    val adapter = ActorsMovieAdapter(cast)

                    binding.rvActors.layoutManager = GridLayoutManager(context, 3)
                    binding.rvActors.adapter = adapter
                    binding.rvActors.hasFixedSize()

                    adapter.onItemClickListener { id ->
                        id?.let {
                            val action =
                                ActorsFragmentDirections.actionActorsFragmentToMoiveFragment(
                                    id)
                            action.movieToDestination(view)
                        }
                    }
                }
        }
    }

    private fun stateManagement(state: NetworkStatus<ActorsMovie>) {
        binding.apply {
            if (state is NetworkStatus.Loading)
                shimmer.startShimmer()
            else
                shimmer.stopShimmer()

            shimmer.isVisible = (state is NetworkStatus.Loading)
            rvActors.isVisible = (state is NetworkStatus.Success)
        }
    }
}