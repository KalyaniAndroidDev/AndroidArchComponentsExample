package com.example.androidarchcomponentsexample.score

import android.util.Log
import androidx.lifecycle.ViewModel

class ScoreViewModel(finalScore: Int) : ViewModel() {
    var score: Int = finalScore
    init {
        Log.i("ScoreViewModel", "Final score is $finalScore")
    }
}