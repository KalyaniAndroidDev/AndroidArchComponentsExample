package com.example.androidarchcomponentsexample.score

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import com.example.androidarchcomponentsexample.R
import com.example.androidarchcomponentsexample.databinding.FragmentScoreBinding

class ScoreFragment : Fragment() {
    private lateinit var binding: FragmentScoreBinding
    private lateinit var viewModel: ScoreViewModel
    private lateinit var viewModelFactory: ScoreViewModelFactory
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate view and obtain an instance of the binding class.
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_score,
            container,
            false
        )

        //using normal safe args
       /* val args = ScoreFragmentArgs.fromBundle(requireArguments())
        Toast.makeText(context, "NumCorrect: ${args.score}", Toast.LENGTH_LONG).show()
        binding.scoreText.text = args.score.toString()*/

        //using factory method
        viewModelFactory = ScoreViewModelFactory(ScoreFragmentArgs.fromBundle(requireArguments()).score)
        viewModel = ViewModelProviders.of(this, viewModelFactory)
            .get(ScoreViewModel::class.java)
        binding.scoreText.text = viewModel.score.toString()
        return binding.root
    }
}