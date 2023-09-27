package ru.stan.a41.presentation

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.launch
import ru.stan.a41.R
import ru.stan.a41.databinding.FragmentListCharactersBinding

class ListCharacters : Fragment() {
    private var _binding: FragmentListCharactersBinding? = null
    private val binding get() = _binding!!
    private val viewModel: ListCharactersViewModel by viewModels {
        ListViewModelFactory()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentListCharactersBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val rcAdapter = CharacterListAdapter()
        binding.recyclerCharacterList.adapter = rcAdapter

        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.characterList.collect {
                rcAdapter.submitList(it)
            }
        }
        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.state.collect{
                binding.progressBar.isVisible = it is ProgressState.Loading
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    companion object {
        fun newInstance() = ListCharacters()
    }
}