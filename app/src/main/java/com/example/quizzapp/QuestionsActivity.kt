package com.example.quizzapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.quizzapp.databinding.ActivityQuestionsBinding

class QuestionsActivity : AppCompatActivity() {
    private lateinit var binding : ActivityQuestionsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityQuestionsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val questionsList = Constants.getQuestion()
        Log.i("questionList size: ","${questionsList.size}")
    }
}