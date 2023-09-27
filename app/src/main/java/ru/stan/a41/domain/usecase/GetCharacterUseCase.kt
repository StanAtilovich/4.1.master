package ru.stan.a41.domain.usecase

import ru.stan.a41.domain.model.CharacterModel
import ru.stan.a41.domain.repository.CharacterRepository

class GetCharacterUseCase(
    private val repo: CharacterRepository
) {
    suspend fun getCharacter(id: Int = 1): CharacterModel {
        return repo.getCharacterById(id)
    }
}