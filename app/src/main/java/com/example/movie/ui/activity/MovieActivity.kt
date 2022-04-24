package com.example.movie.ui.activity

import android.content.Context
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.NavHostFragment
import com.example.movie.R
import com.example.movie.databinding.ActivityMovieBinding
import com.example.movie.utils.NetworkHelper
import com.example.movie.utils.setSnackbar

class MovieActivity : AppCompatActivity() {

    private var _binding: ActivityMovieBinding? = null
    private val binding: ActivityMovieBinding get() = _binding!!


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = DataBindingUtil.setContentView(this, R.layout.activity_movie)
        supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment

        NetworkHelper(context = this).observe(this){ state ->
            binding.root.setSnackbar(state)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}