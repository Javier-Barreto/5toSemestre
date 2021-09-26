package com.itiudc.proyecto_breakingbad_rolonbarreto.adapters
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.itiudc.proyecto_breakingbad_rolonbarreto.R
import com.itiudc.proyecto_breakingbad_rolonbarreto.databinding.CharacterListItemBinding
import com.itiudc.proyecto_breakingbad_rolonbarreto.models.character

class CharacterListFragmentAdapter(private val characterList: List<character>) : RecyclerView.Adapter<CharacterListFragmentAdapter.ViewHolder>(){
    lateinit var onClickItem: (character) -> Unit
    inner class ViewHolder(private val binding: CharacterListItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(character: character){
            Glide.with(binding.root)
                .load(character.img)
                .centerCrop()
                .placeholder(R.drawable.ic_launcher_foreground)
                .into(binding.characterImage)

            binding.characterName.text = character.name
            binding.characterAlias.text = character.nickname

            when(character.status){
                "Alive" -> {
                    Glide.with(binding.root)
                        .load("https://upload.wikimedia.org/wikipedia/commons/thumb/f/f1/Heart_coraz%C3%B3n.svg/1200px-Heart_coraz%C3%B3n.svg.png")
                        .centerCrop()
                        .placeholder(R.drawable.ic_launcher_foreground)
                        .into(binding.characterStatus)
                }
                "Deceased" ->{
                    Glide.with(binding.root)
                        .load("https://w7.pngwing.com/pngs/239/20/png-transparent-blue-background-with-rip-text-overlay-youtube-bangalore-journalist-hindi-death-rip-text-india-murder.png")
                        .centerCrop()
                        .placeholder(R.drawable.ic_launcher_foreground)
                        .into(binding.characterStatus)

                }
                "Presumed dead" ->{
                    Glide.with(binding.root)
                        .load("https://toppng.com/uploads/preview/red-question-mark-png-11552331287sr3mry9fkk.png")
                        .centerCrop()
                        .placeholder(R.drawable.ic_launcher_foreground)
                        .into(binding.characterStatus)

                }
            }
            binding.root.setOnClickListener(){
                if(::onClickItem.isInitialized)
                    onClickItem(character)
                else
                    Log.i("jav", "onMovieClick event is not initialized")
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = CharacterListItemBinding.inflate(LayoutInflater.from(parent.context))

        return  ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(characterList[position])
    }

    override fun getItemCount(): Int {
        return characterList.count()
    }
}
