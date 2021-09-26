package com.itiudc.proyecto_breakingbad_rolonbarreto.adapters


import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.itiudc.proyecto_breakingbad_rolonbarreto.R
import com.itiudc.proyecto_breakingbad_rolonbarreto.databinding.ActivityDetailBinding
import com.itiudc.proyecto_breakingbad_rolonbarreto.models.character

class DetailAdapter (private val characterList: List<character>) : RecyclerView.Adapter<DetailAdapter.ViewHolder>(){
    inner class ViewHolder(private val binding: ActivityDetailBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(character: character){
            Glide.with(binding.root)
                .load(character.img)
                .centerCrop()
                .placeholder(R.drawable.ic_launcher_foreground)
                .into(binding.characterImage)
            binding.characterName.text = character.name

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ActivityDetailBinding.inflate(LayoutInflater.from(parent.context))
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(characterList[position])
    }

    override fun getItemCount(): Int {
        return characterList.count()
    }

}
