package ru.stan.a41.presentation

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import ru.stan.a41.domain.model.CharacterModel
import ru.stan.a41.domain.usecase.GetCharacterListUseCase

private const val TAG = "CharacterListViewModel55555"
class ListCharactersViewModel(
    private val getCharacterListUseCase : GetCharacterListUseCase
) : ViewModel() {

    private var _state = MutableStateFlow<ProgressState>(ProgressState.Success)
    var state = _state.asStateFlow()

    private var _characterList = MutableStateFlow<List<CharacterModel>>(mutableListOf())
    val characterList = _characterList.asStateFlow()

    init {
        viewModelScope.launch {
            _state.value = ProgressState.Loading
            try {
                _characterList.value = getCharacterListUseCase.getCharacterList()
            } catch (t: Throwable) {
                Log.e(TAG, "${t.message}", t)
            }
            _state.value = ProgressState.Success
        }
    }
}