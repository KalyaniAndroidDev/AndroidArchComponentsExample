package com.example.androidarchcomponentsexample.guesswordgame

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class GuessWordGameViewModel : ViewModel() {
    //MutableLiveData is a LiveData whose value can be changed.
    // The current word
    val word = MutableLiveData<String>()
    // The current score
    val score = MutableLiveData<Int>()

    // The list of words - the front of the list is the next word to guess
    private lateinit var wordList: MutableList<String>

    init {
//        resetList()
//        nextWord()
        word.value=""
        score.value=0
    }

    /**
     * Resets the list of words and randomizes the order
     */
    private fun resetList() {
        wordList = mutableListOf(
            "queen",
            "hospital",
            "basketball",
            "cat",
            "change",
            "snail",
            "soup",
            "calendar",
            "sad",
            "desk",
            "guitar",
            "home",
            "railway",
            "zebra",
            "jelly",
            "car",
            "crow",
            "trade",
            "bag",
            "roll",
            "bubble"
        )
        wordList.shuffle()
    }

    /**
     * Moves to the next word in the list
     */
    private fun nextWord() {
        if (!wordList.isEmpty()) {
            //Select and remove a word from the list
            word.value = wordList.removeAt(0)
        }
    }

    fun onSkip() {
        score.value= score.value?.minus(1)
        nextWord()
    }

    fun onCorrect() {
        score.value=score.value?.plus(1)
        nextWord()
    }

    override fun onCleared() {
        super.onCleared()
    }
}