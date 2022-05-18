package com.example.movie.ui.fragment.popular

import android.annotation.SuppressLint
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.findNavController
import com.example.movie.R
import com.example.movie.data.model.trend.Trending
import com.example.movie.databinding.FragmentPopularBinding
import com.example.movie.ui.base.BaseFragment
import com.example.movie.ui.base.adapter.BaseOnClickItem
import com.example.movie.utils.setAsActionBar
import com.google.android.material.tabs.TabLayout

class PopularFragment : BaseFragment<FragmentPopularBinding>(R.layout.fragment_popular),
    TabLayout.OnTabSelectedListener ,BaseOnClickItem<Trending> {


    @SuppressLint("ResourceAsColor")
    override fun initial() {
        (activity as AppCompatActivity?)?.setAsActionBar(binding.toolbar, true)

//        val adapter = PopularAdapter(MDBRepo.getCategory(),this)
//        binding.rcPopular.adapter = adapter

//        binding.rcPopular.adapter = FavoriteAdapter(MDBRepo.getCategory())
        if (binding.tabLayout.getTabAt(0)?.isSelected == true) {
            Log.d("sajjadio", "nnnnnnnn")

        }
        binding.tabLayout.addOnTabSelectedListener(this)
    }

    override fun onTabSelected(tab: TabLayout.Tab?) {
        when (tab?.position) {
            0 -> {
                Log.d("sajjadio", "${tab.text}")
            }

            1 -> {
                Log.d("sajjadio", "${tab.text}")
            }
            2 -> {
                Log.d("sajjadio", "${tab.text}")
            }
        }
    }

    override fun onTabUnselected(tab: TabLayout.Tab?) {
        //TODO("Not yet implemented")
    }

    override fun onTabReselected(tab: TabLayout.Tab?) {
        // TODO("Not yet implemented")
    }

    override fun clickedItem(item: Trending) {
       findNavController().navigate(R.id.action_popularFragment_to_tvFragment)
    }

}
