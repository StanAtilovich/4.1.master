package ru.stan.a41.data.repository

import ru.stan.a41.data.mapper.CharacterMapper
import ru.stan.a41.data.network.RetrofitInstance
import ru.stan.a41.domain.model.CharacterModel
import ru.stan.a41.domain.repository.CharacterRepository

object CharacterRepositoryImpl: CharacterRepository {
    private val mapper = CharacterMapper()

    override suspend fun getCharacters(): List<CharacterModel> {
        return mapper.mapListDtoToListModel(
            RetrofitInstance.searchCharacterApi.getCharacters())
    }

    override suspend fun getCharacterById(id: Int): CharacterModel {
        return mapper.mapDtoToModel(
            RetrofitInstance.searchCharacterApi.getCgaractersById(id)
        )
    }

}