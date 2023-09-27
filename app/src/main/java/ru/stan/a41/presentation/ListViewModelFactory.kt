package ru.stan.a41.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import ru.stan.a41.data.repository.CharacterRepositoryImpl
import ru.stan.a41.domain.usecase.GetCharacterListUseCase

class ListViewModelFactory: ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ListCharactersViewModel::class.java)){
            return ListCharactersViewModel(GetCharacterListUseCase(CharacterRepositoryImpl)) as T
        }
        throw java.lang.IllegalAccessException("неизвестный класс 2")
    }
}