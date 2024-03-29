package com.example.quizzapp

import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView
import android.widget.Toast
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
        binding.btnSubmit.setOnClickListener(this)

    }

    private fun selectedOptionView(tv:TextView, selectedOption: Int){
        defaultOptionView()
        this.selectedOption = selectedOption

        tv.background = ContextCompat.getDrawable(this, R.drawable.rectangleblue)
        tv.setTypeface(tv.typeface, Typeface.BOLD)
    }
    private fun defaultOptionView(){  // sets all the options to default style
        val options = ArrayList<TextView>()
        if(currentPosition < questionsList!!.size){
            binding.btnSubmit.text = "S U B M I T"
        }
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

    private fun setOptionsColor(clickedOption: Int, drawable: Int){
        when(clickedOption){
            1 -> binding.tvOption1.background = ContextCompat.getDrawable(this, drawable)
            4 -> binding.tvOption4.background = ContextCompat.getDrawable(this, drawable)
            3 -> binding.tvOption3.background = ContextCompat.getDrawable(this, drawable)
            2 -> binding.tvOption2.background = ContextCompat.getDrawable(this, drawable)
        }
    }
    override fun onClick(view: View?) {
        when(view?.id){
            R.id.tvOption1 -> selectedOptionView(binding.tvOption1, 1)
            R.id.tvOption2 -> selectedOptionView(binding.tvOption2, 2)
            R.id.tvOption3 -> selectedOptionView(binding.tvOption3, 3)
            R.id.tvOption4 -> selectedOptionView(binding.tvOption4, 4)
            R.id.btnSubmit -> {
                    if(selectedOption == 0){
                        defaultOptionView()
                        currentPosition++
                        when{
                            currentPosition <= questionsList!!.size -> {
                                    selectQuestion()
                            }
                            else -> {
                                Toast.makeText(this, "finished", Toast.LENGTH_SHORT).show()
                            }
                        }
                    }else{
                        val question = questionsList?.get(currentPosition - 1)
                        if(question!!.correctAns != selectedOption){
                            setOptionsColor(selectedOption, R.drawable.rectangle_incorrect)
                        }
                        setOptionsColor(question.correctAns, R.drawable.rectangle_correct)
                        selectedOption = 0
                        if(currentPosition == questionsList!!.size){
                            binding.btnSubmit.text = "F I N I S H"
                        }else{
                            binding.btnSubmit.text = "N E X T"
                        }
                    }
            }
        }
    }

}