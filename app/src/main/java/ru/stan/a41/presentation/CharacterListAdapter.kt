package ru.stan.a41.presentation

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import coil.load
import ru.stan.a41.R
import ru.stan.a41.databinding.CharacterItemBinding
import ru.stan.a41.domain.model.CharacterModel

class CharacterListAdapter
    :  androidx.recyclerview.widget.ListAdapter<CharacterModel, CharacterListAdapter.CharacterListViewHolder>(callBack) {
    class CharacterListViewHolder(val binding: CharacterItemBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharacterListViewHolder {
        val binding =CharacterItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return CharacterListViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CharacterListViewHolder, position: Int) {
        val characterItem = getItem(position)
        holder.binding.imageCharacter.load(characterItem.imageUrl)
        holder.binding.tvname.text = characterItem.name
        holder.binding.tvHouse.text = characterItem.hogwartsHouse
    }
}