package com.example.trailers.ui.fragment.favorite

import android.view.*
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.trailers.R
import com.example.trailers.databinding.FragmentFavoriteBinding
import com.example.trailers.ui.base.BaseFragment
import com.example.trailers.utils.setAsActionBar

class FavoriteFragment : BaseFragment<FragmentFavoriteBinding>(R.layout.fragment_favorite) {

    override fun initial() {
        (activity as AppCompatActivity?)?.setAsActionBar(binding.toolbar, true)

//        binding.rcFavorite.adapter = FavoriteAdapter(MDBRepo.getCategory())

    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.top_app_bar, menu)
        menu.findItem(R.id.search).isVisible = false
        menu.findItem(R.id.setting).isVisible = false
        menu.findItem(R.id.tv).isVisible = false
        menu.findItem(R.id.movie).isVisible = false
        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.delete) {
            Toast.makeText(context, "Deleted me", Toast.LENGTH_LONG).show()
        }
        return super.onOptionsItemSelected(item)
    }
}