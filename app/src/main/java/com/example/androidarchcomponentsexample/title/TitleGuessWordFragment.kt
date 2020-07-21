package com.example.androidarchcomponentsexample.title

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil

import androidx.navigation.Navigation.findNavController
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.example.androidarchcomponentsexample.R
import com.example.androidarchcomponentsexample.databinding.FragmentTitleGuessWordBinding

class TitleGuessWordFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        val binding: FragmentTitleGuessWordBinding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_title_guess_word, container, false
        )

        binding.playGameButton.setOnClickListener {
            findNavController().navigate(TitleGuessWordFragmentDirections.actionTitleToGame())
        }
        return binding.root
    }
}