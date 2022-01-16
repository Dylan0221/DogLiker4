package com.example.dogliker4.presentation.ui.fragments

import android.content.ContentValues.TAG
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.view.isInvisible
import androidx.core.view.isVisible
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.example.dogliker4.databinding.FragmentHomeBinding
import com.example.dogliker4.domain.model.DogItem
import com.example.dogliker4.presentation.viewmodel.fragments_viewmodel.HomeViewModel
import com.example.dogliker4.presentation.viewmodel.sharedviewmodel.SharedViewModel
import com.squareup.picasso.Picasso
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

@AndroidEntryPoint
class HomeFragment : Fragment() {
    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!
    private val viewModel: HomeViewModel by viewModels()
    private val sharedViewModel: SharedViewModel by activityViewModels()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentHomeBinding.inflate(inflater, container, false)

        return binding.root


    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        Log.d(TAG, "onViewCreated: HomeFragment")

        loadImage()

        binding.likeButton.setOnClickListener {
            if (viewModel.dogItem != null) {
                likeDog()
                Log.d(TAG, "LikeButton: successful ")
            } else {
                Toast.makeText(context, "An error has occurred", Toast.LENGTH_SHORT).show()
                Log.d(TAG, "LikeButton: failed ")

            }
        }

        binding.changeButton.setOnClickListener {
            changeImage()
            Log.d(TAG, "ChangeButton:successful ")

        }


    }


    private fun loadImage() {
        lifecycleScope.launch {
            while (true) {
                val dogItem = viewModel.dogItem
                if (dogItem != null) {
                    withContext(Dispatchers.Main) {
                        Picasso.get().load(dogItem.image).into(binding.cardImageView)
                        binding.progressBar.isInvisible = true
                        binding.cardImageView.isVisible = true

                        Log.d(TAG, "loadImage: succesful")
                    }

                    break

                } else {
                    binding.progressBar.isVisible = true
                    binding.cardImageView.isInvisible = true
                    Log.d(TAG, "loadImage: failed")
                    delay(200)
                }
            }
        }
    }


    private fun changeImage(){
        lifecycleScope.launch {
            binding.likeImageView.isInvisible = true
            getDog()
            delay(400)
            loadImage()
            Log.d(TAG, "changeImage: Successful")
        }
    }

    private fun getDog() {
        binding.cardImageView.isInvisible = true
        binding.progressBar.isVisible = true
        viewModel.getDog()
    }

    private fun likeDog() {
        val dogItem = viewModel.dogItem
        var lastLikedDogItem: DogItem?
        lifecycleScope.launch {
            if (sharedViewModel.likedDogs != emptyList<DogItem>()) {
                lastLikedDogItem = sharedViewModel.likedDogs.last()
            } else {
                lastLikedDogItem = null
            }
            if (dogItem != null) {
                if (dogItem.image != lastLikedDogItem?.image) {
                    viewModel.addDogItem(dogItem)
                    binding.likeImageView.isVisible = true
                    sharedViewModel.getLikedDogs()
                    delay(400)

                    if (sharedViewModel.likedDogs != emptyList<DogItem>()) {
                        lastLikedDogItem = sharedViewModel.likedDogs.last()
                    }

                    Log.d(TAG, "likeDog: finished")
                    viewModel.dogItem = lastLikedDogItem
                } else if (dogItem.image == lastLikedDogItem?.image) {
                    viewModel.deleteDogItem(dogItem.image)
                    binding.likeImageView.isInvisible = true
                    delay(400)
                    sharedViewModel.getLikedDogs()
                }
            }
        }
    }


}