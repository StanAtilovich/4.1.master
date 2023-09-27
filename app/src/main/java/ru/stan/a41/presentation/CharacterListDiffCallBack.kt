package ru.stan.a41.presentation

import androidx.recyclerview.widget.DiffUtil
import ru.stan.a41.domain.model.CharacterModel

val callBack = object : DiffUtil.ItemCallback<CharacterModel>(){
    override fun areItemsTheSame(oldItem: CharacterModel, newItem: CharacterModel): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: CharacterModel, newItem: CharacterModel): Boolean {
        return oldItem == newItem
    }

}