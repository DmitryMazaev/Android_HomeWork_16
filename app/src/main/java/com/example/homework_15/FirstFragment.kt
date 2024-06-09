package com.example.homework_15

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.viewModelScope
import androidx.navigation.fragment.findNavController
import com.bumptech.glide.Glide
import com.example.homework_15.databinding.FragmentFirstBinding
import kotlinx.coroutines.flow.filterIsInstance
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class FirstFragment : Fragment() {

    private var _binding: FragmentFirstBinding? = null
    private val binding get() = _binding!!

    val vm = MainViewModel()

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
                    binding.firstName.text = it.users.firstOrNull()?.name?.first
                    binding.lastName.text = it.users.firstOrNull()?.name?.last
                    binding.title.text = it.users.firstOrNull()?.name?.title
                    Glide.with(this)
                        .load(it.users.firstOrNull()?.picture?.medium)
                        .into(binding.imageView)

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