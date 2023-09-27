package ru.stan.a41.data.mapper

import ru.stan.a41.data.dto.CharacterDto
import ru.stan.a41.domain.model.CharacterModel

class CharacterMapper {
    fun mapDtoToModel(characterDto: CharacterDto)= CharacterModel(
        id = characterDto.id,
        name = characterDto.name,
        hogwartsHouse = characterDto.hogwartsHouse,
        imageUrl = characterDto.imageUrl
    )

    fun mapListDtoToListModel(dtoList:List<CharacterDto>): List<CharacterModel>{
        var resList = mutableListOf<CharacterModel>()
        dtoList.forEach { resList.add(mapDtoToModel(it)) }
        return resList
    }
}