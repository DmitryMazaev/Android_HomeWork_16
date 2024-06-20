package com.example.homework_15.presentation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.viewModelScope
import com.example.homework_15.data.RetrofitHelepr
import com.example.homework_15.data.UsefulActivitiesRepository
import com.example.homework_15.databinding.FragmentFirstBinding
import com.example.homework_15.domain.GetUsefulActivityUseCase
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class FirstFragment : Fragment() {

    private var _binding: FragmentFirstBinding? = null
    private val binding get() = _binding!!
    private val usefulActivitiesRepository = UsefulActivitiesRepository(RetrofitHelepr.retrofitEngine)
    private val getUsefulActivityUseCase = GetUsefulActivityUseCase(usefulActivitiesRepository)
    private val vm = MainViewModel(getUsefulActivityUseCase)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        vm.state.onEach {
            when(it) {
                is State.Success -> {
                    //vm.start().toString()
                    binding.secondText.text = vm.getExercise(getUsefulActivityUseCase)
                    binding.buttonFirst.setOnClickListener {
                        vm.start().toString()
                    }
                }
                else -> Unit
            }
        }.launchIn(vm.viewModelScope)

        vm.start()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}