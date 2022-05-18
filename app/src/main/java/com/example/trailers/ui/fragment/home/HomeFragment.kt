package com.example.trailers.ui.fragment.home

import android.content.Context
import android.widget.Toast
import com.example.trailers.R
import com.example.trailers.databinding.FragmentHomeBinding
import androidx.appcompat.app.AppCompatActivity
import com.example.trailers.ui.fragment.home.adapter.OnClickListener
import android.widget.ImageView
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.example.trailers.data.model.trend.Trending
import com.example.trailers.ui.base.BaseFragment
import com.example.trailers.ui.base.nestedrv.HomeAdapter
import com.example.trailers.ui.vm.MDBViewModel
import com.example.trailers.utils.setAsActionBar
import dagger.android.support.AndroidSupportInjection
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject


class HomeFragment : BaseFragment<FragmentHomeBinding>(R.layout.fragment_home), OnClickListener {

    /* Fragment doesn't know any details about how FeatureViewModel instances are created */
    @Inject
    lateinit var vm: MDBViewModel

    override fun onAttach(context: Context) {
        AndroidSupportInjection.inject(this)
        super.onAttach(context)
    }

    override fun initial() {
        (activity as AppCompatActivity?)?.setAsActionBar(binding.toolbar, false)

        binding.apply {
            viewModel = vm
            lifecycleOwner = this@HomeFragment
        }

        filterResult(resources.getString(R.string.movie))
        binding.btnSearch.setOnClickListener { view ->
            view.findNavController().navigate(R.id.action_homeFragment_to_searchFragment)
        }

        binding.btnMenu.setOnClickListener { view ->
            view.findNavController().navigate(R.id.action_homeFragment_to_bottomSheetHome)
        }

        vm.trending.observe(this) {
            val adapter = HomeAdapter(it, this)
            binding.parentRecyclerView.adapter = adapter
            binding.parentRecyclerView.setHasFixedSize(true)
        }

    }


    private fun filterResult(string: String) {
        binding.titleToolbar.text = string
    }


    override fun trendItem(trend: Trending) {
        Toast.makeText(requireContext(), "trend", Toast.LENGTH_SHORT).show()
    }

    override fun category(category: ImageView) {
        findNavController().navigate(R.id.action_homeFragment_to_moiveFragment)
    }

    override fun openItem(category: Trending) {
        Toast.makeText(requireContext(), "view more category", Toast.LENGTH_SHORT).show()
    }

    override fun popular(popular: Int) {
        findNavController().navigate(R.id.action_homeFragment_to_popularFragment)
    }

    suspend fun datas(): Flow<Int> {
        return flow {
            for (i in 1..10) {
                emit(i)
            }
        }
    }

}