package ru.stan.a41.domain.usecase

import ru.stan.a41.domain.model.CharacterModel
import ru.stan.a41.domain.repository.CharacterRepository

class GetCharacterListUseCase(
    private val repo: CharacterRepository
) {
    suspend fun getCharacterList(): List<CharacterModel> {
        return repo.getCharacters()
    }
}