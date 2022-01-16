package com.example.dogliker4.presentation.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.dogliker4.databinding.DogRvItemBinding
import com.example.dogliker4.domain.model.DogItem
import com.squareup.picasso.Picasso

class DogRecyclerViewAdapter(var dogs: List<DogItem>):RecyclerView.Adapter<DogRecyclerViewAdapter.DogRVViewHolder>() {

    inner class DogRVViewHolder(val itemBinding: DogRvItemBinding): RecyclerView.ViewHolder(itemBinding.root){

        fun bind(item: DogItem){
            Picasso.get().load(item.image).into(itemBinding.dogImageView)
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DogRVViewHolder {
        return DogRVViewHolder(DogRvItemBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: DogRVViewHolder, position: Int) {
        val dogItem: DogItem = dogs[position]

        holder.bind(dogItem)
    }

    override fun getItemCount(): Int = dogs.size


}