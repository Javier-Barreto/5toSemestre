package com.itiudc.examen_barretorolon.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import com.itiudc.examen_barretorolon.R

class SecondQuestion : AppCompatActivity() {
    companion object{
        var UserName = "user_info"
        var FirstQuestionAnswer = "First_answer"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second_question)
        val bundle: Bundle? = intent.extras

        val A1 = findViewById<Button>(R.id.Answer1)
        val A2 = findViewById<Button>(R.id.Answer2)
        val A3 = findViewById<Button>(R.id.Answer3)

        val name = bundle?.getString(UserName)
        val FA = bundle?.getString(FirstQuestionAnswer)

        A1.setOnClickListener(){
            val A1Next = Intent(this, ThirdQuestion::class.java).apply {
                putExtra(ThirdQuestion.UserName, name)
                putExtra(ThirdQuestion.FirstQuestionAnswer, FA)
                putExtra(ThirdQuestion.SecondQuestionAnswer, "Incorrect")
            }
            startActivity(A1Next)
        }

        A2.setOnClickListener(){
            val A2Next = Intent(this, ThirdQuestion::class.java).apply {
                putExtra(ThirdQuestion.UserName, name)
                putExtra(ThirdQuestion.FirstQuestionAnswer, FA)
                putExtra(ThirdQuestion.SecondQuestionAnswer, "Incorrect")
            }
            startActivity(A2Next)
        }

        A3.setOnClickListener(){
            val A3Next = Intent(this, ThirdQuestion::class.java).apply {
                putExtra(ThirdQuestion.UserName, name)
                putExtra(ThirdQuestion.FirstQuestionAnswer, FA)
                putExtra(ThirdQuestion.SecondQuestionAnswer, "Correct")
            }
            startActivity(A3Next)
        }
    }
}