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

        for(i in questionsList){
            Log.e("question", i.question)
        }

        var currentPosition = 1
        val question: Question = questionsList[currentPosition - 1]
        binding.ivImage.setImageResource(question.image)
        binding.progressBar.progress = currentPosition
        binding.tvProgress.text = "${currentPosition}/${binding.progressBar.max}"
        binding.tvQuestion.text = question.question
        binding.tvOption1.text = question.optionOne
        binding.tvOption2.text = question.optionTwo
        binding.tvOption3.text = question.optionThree
        binding.tvOption4.text = question.optionFour


    }
}