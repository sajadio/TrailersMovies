package com.example.movie.ui.fragment.details.tv

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.*
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.movie.R
import com.example.movie.data.m.Season
import com.example.movie.databinding.FragmentTvBinding
import com.example.movie.databinding.LayoutBottomSheetBinding
import com.example.movie.ui.base.adapter.BaseOnClickItem
import com.example.movie.ui.fragment.details.tv.adapter.SeasonAdapter
import com.example.movie.utils.favoriteItem
import com.example.movie.utils.listChips
import com.google.android.material.chip.Chip
import kotlinx.android.synthetic.main.fragment_tv.*


class TVFragment : Fragment() {

    private var _binding: FragmentTvBinding? = null
    private val binding: FragmentTvBinding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = DataBindingUtil.inflate(inflater, R.layout.fragment_tv, container, false)
        binding.toolbar.title = ""
        binding.toolbar.subtitle = ""
        return _binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        (activity as AppCompatActivity?)!!.setSupportActionBar(binding.toolbar)
        setHasOptionsMenu(true)

        binding.btnFavorite.setOnClickListener {
            binding.btnFavorite.favoriteItem(isFavorite = false)
            binding.btnNotFavorite.favoriteItem(isFavorite = true)
        }
        binding.btnNotFavorite.setOnClickListener {
            binding.btnFavorite.favoriteItem(isFavorite = true)
            binding.btnNotFavorite.favoriteItem(isFavorite = false)
        }


        addChipEpisodeView(listChips)

        binding.btnSheet.setOnClickListener {
            (activity)?.supportFragmentManager.let {
                OptionsBottomSheetFragment.newInstance(Bundle()).apply {
                    it?.let { it1 -> show(it1, tag) }
                }
            }
        }
    }

    @SuppressLint("ResourceAsColor")
    private fun addChipEpisodeView(chipText: MutableList<String>) {
        val chipGroup = binding.include.chipGroupEpisode
        chipText.forEach { type ->
            val chip =
                layoutInflater.inflate(R.layout.layout_chips_eposidoe, chipGroup, false) as Chip
            chip.text = type
            chipGroup.addView(chip)
        }
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        binding.toolbar.setNavigationIcon(R.drawable.ic_baseline_arrow_back_ios_24_white)
        binding.toolbar.setNavigationOnClickListener { activity!!.onBackPressed() }
        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        // for prevent memory leaks
        _binding = null
    }

}