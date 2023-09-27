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
import coil.load
import com.google.firebase.crashlytics.FirebaseCrashlytics
import kotlinx.coroutines.launch
import ru.stan.a41.R
import ru.stan.a41.databinding.FragmentMainBinding

class MainFragment : Fragment() {
    private val viewModel: MainViewModel by viewModels {
        MainViewModelFactory()
    }

    private var _binding: FragmentMainBinding? = null
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMainBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.character.collect {
                binding.tvName.text = it.name
                binding.tvHouse.text = it.hogwartsHouse
                binding.imageCharacter.load(it.imageUrl)
            }
        }
        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.state.collect {
                binding.progressBar.isVisible = it is ProgressState.Loading
            }
        }

        binding.buttonRandomCharacter.setOnClickListener {
            //    viewModel.randomCharacter()
            FirebaseCrashlytics.getInstance().log("это метод с крашем")
            try {
                throw Exception("1 exception")
            } catch (e: Exception){
                FirebaseCrashlytics.getInstance().recordException(e)
            }

        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    companion object {
        fun newInstance() = MainFragment()
    }
}