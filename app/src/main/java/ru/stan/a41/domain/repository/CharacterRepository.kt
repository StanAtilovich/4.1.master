package ru.stan.a41.domain.repository

import ru.stan.a41.domain.model.CharacterModel

interface CharacterRepository {
    suspend fun getCharacters(): List<CharacterModel>
    suspend fun getCharacterById(id: Int): CharacterModel
}