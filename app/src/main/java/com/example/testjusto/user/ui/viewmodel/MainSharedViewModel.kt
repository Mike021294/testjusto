package com.example.testjusto.user.ui.viewmodel

import androidx.databinding.BindingAdapter
import androidx.lifecycle.ViewModel
import com.bumptech.glide.Glide
import com.example.testjusto.background.custom.CircleImageView
import com.example.testjusto.user.background.repository.MainRepository

class MainSharedViewModel(private val mainRepository: MainRepository) : ViewModel() {

    companion object {

        @JvmStatic
        @BindingAdapter("imageUrl")
        fun loadImage(view: CircleImageView, url: String?) {
            if (!url.isNullOrEmpty()) {
                Glide.with(view.context)
                    .load(url)
                    .into(view)
            }
        }
    }

    var user = mainRepository.getRandomUser()
}