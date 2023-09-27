package ru.stan.a41.presentation

sealed class ProgressState{
    object Loading: ProgressState()
    object Success: ProgressState()
}