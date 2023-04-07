package com.home.jsonread

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.home.jsonread.databinding.FragmentJsonBinding
import com.home.jsonread.databinding.FragmentMainBinding

class JsonFragment : Fragment() {
    private lateinit var binding: FragmentJsonBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val viewModel: JsonViewModel by viewModels()
        binding = FragmentJsonBinding.inflate(inflater, container,false)
        binding.viewModel = viewModel
        binding.lifecycleOwner = this
        return binding.root
    }
}