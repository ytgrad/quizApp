package com.example.quizzapp

import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView
import androidx.core.content.ContextCompat
import com.example.quizzapp.databinding.ActivityQuestionsBinding

class QuestionsActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var binding : ActivityQuestionsBinding
    private var currentPosition = 1
    private var questionsList:ArrayList<Question>? = null
    private var selectedOption = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityQuestionsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        questionsList = Constants.getQuestion()

        selectQuestion()

        binding.tvOption1.setOnClickListener(this)
        binding.tvOption2.setOnClickListener(this)
        binding.tvOption3.setOnClickListener(this)
        binding.tvOption4.setOnClickListener(this)

    }

    private fun selectedOptionView(tv:TextView, selectedOption: Int){
        defaultOptionView()
        this.selectedOption = selectedOption

        tv.background = ContextCompat.getDrawable(this, R.drawable.rectangleblue)
        tv.setTypeface(tv.typeface, Typeface.BOLD)
    }
    private fun defaultOptionView(){  // sets all the options to default style
        val options = ArrayList<TextView>()
        options.add(0, binding.tvOption1)
        options.add(1, binding.tvOption2)
        options.add(2, binding.tvOption3)
        options.add(3, binding.tvOption4)

        for(i in options){
            i.background = ContextCompat.getDrawable(this, R.drawable.rectangle)
            i.typeface = Typeface.DEFAULT
        }
    }
    private fun selectQuestion(){
        val question: Question = questionsList!![currentPosition - 1]
        binding.ivImage.setImageResource(question.image)
        binding.progressBar.progress = currentPosition
        binding.tvProgress.text = "${currentPosition}/${binding.progressBar.max}"
        binding.tvQuestion.text = question.question
        binding.tvOption1.text = question.optionOne
        binding.tvOption2.text = question.optionTwo
        binding.tvOption3.text = question.optionThree
        binding.tvOption4.text = question.optionFour
    }
    override fun onClick(view: View?) {
        when(view?.id){
            R.id.tvOption1 -> selectedOptionView(binding.tvOption1, 1)
            R.id.tvOption2 -> selectedOptionView(binding.tvOption2, 2)
            R.id.tvOption3 -> selectedOptionView(binding.tvOption3, 3)
            R.id.tvOption4 -> selectedOptionView(binding.tvOption4, 4)
        }
    }

}