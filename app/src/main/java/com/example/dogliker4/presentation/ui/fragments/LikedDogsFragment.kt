package com.example.dogliker4.presentation.ui.fragments

import android.content.ContentValues.TAG
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.dogliker4.R
import com.example.dogliker4.databinding.FragmentLikedDogsBinding
import com.example.dogliker4.presentation.ui.adapters.DogRecyclerViewAdapter
import com.example.dogliker4.presentation.viewmodel.fragments_viewmodel.LikedDogsViewModel
import com.example.dogliker4.presentation.viewmodel.sharedviewmodel.SharedViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlin.math.log

@AndroidEntryPoint
class LikedDogsFragment : Fragment() {
    private var _binding: FragmentLikedDogsBinding? = null
    private val binding get() = _binding!!
    private val viewModel: LikedDogsViewModel by viewModels()
    private val sharedViewModel: SharedViewModel by activityViewModels()




    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        Log.d(TAG, "onCreateView: likedDogdfragment before binding")
        // Inflate the layout for this fragment
        _binding = FragmentLikedDogsBinding.inflate(inflater, container, false)

        Log.d(TAG, "onCreateView: likedDogdfragment after binding")


        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initRecyclerView()
    }

    private fun initRecyclerView(){
        binding.recyclerView.apply {
            layoutManager = LinearLayoutManager(context)
            binding.recyclerView.adapter = DogRecyclerViewAdapter(sharedViewModel.likedDogs)
        }
    }
}