package com.example.androidarchcomponentsexample.guesswordgame

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders

import androidx.navigation.fragment.findNavController
import com.example.androidarchcomponentsexample.R
import com.example.androidarchcomponentsexample.databinding.FragmentGuessWordBinding


class GuessWordGameFragment : Fragment() {


    private lateinit var binding: FragmentGuessWordBinding

    private lateinit var viewModel: GuessWordGameViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        // Inflate view and obtain an instance of the binding class
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_guess_word,
            container,
            false
        )

        /*Always use ViewModelProvider to create ViewModel objects rather than
         directly instantiating an instance of ViewModel, because you create the ViewModel instance
          using the ViewModel class, a new object is created every time the fragment is re-created */
        Log.i("GameFragment", "Called ViewModelProviders.of")
        viewModel = ViewModelProviders.of(this).get(GuessWordGameViewModel::class.java)


        binding.correctButton.setOnClickListener { onCorrect() }
        binding.skipButton.setOnClickListener { onSkip() }
        binding.endGameButton.setOnClickListener(View.OnClickListener {
            findNavController().navigate(
                GuessWordGameFragmentDirections.actionGameToScore().setScore(viewModel.score)
            )
        })
        updateScoreText()
        updateWordText()
        return binding.root

    }

    private fun onSkip() {
        viewModel.onSkip()
        updateWordText()
        updateScoreText()
    }

    private fun onCorrect() {
        viewModel.onCorrect()
        updateScoreText()
        updateWordText()
    }

    /** Methods for updating the UI **/

    private fun updateWordText() {
        binding.wordText.text = viewModel.word
    }

    private fun updateScoreText() {
        binding.scoreText.text = viewModel.score.toString()
    }
}