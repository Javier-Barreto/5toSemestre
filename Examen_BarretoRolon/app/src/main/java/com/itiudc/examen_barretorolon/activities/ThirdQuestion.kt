package com.itiudc.examen_barretorolon.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.itiudc.examen_barretorolon.R

class ThirdQuestion : AppCompatActivity() {
    companion object{
        const val UserName = "user_info"
        const val FirstQuestionAnswer = "First_answer"
        const val SecondQuestionAnswer = "Second_answer"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_third_question)

        val bundle: Bundle? = intent.extras

        val A1 = findViewById<Button>(R.id.Answer1)
        val A2 = findViewById<Button>(R.id.Answer2)
        val A3 = findViewById<Button>(R.id.Answer3)

        val name = bundle?.getString(UserName)
        val FA = bundle?.getString(FirstQuestionAnswer)
        val SA = bundle?.getString(SecondQuestionAnswer)

        A1.setOnClickListener(){
            val A1Next = Intent(this, ResultsActivity::class.java).apply {
                putExtra(ResultsActivity.UserName, name)
                putExtra(ResultsActivity.FirstQuestionAnswer, FA)
                putExtra(ResultsActivity.SecondQuestionAnswer, SA)
                putExtra(ResultsActivity.ThirdQuestionAnswer, "Incorrect")
            }
            startActivity(A1Next)
        }

        A2.setOnClickListener(){
            val A2Next = Intent(this, ResultsActivity::class.java).apply {
                putExtra(ResultsActivity.UserName, name)
                putExtra(ResultsActivity.FirstQuestionAnswer, FA)
                putExtra(ResultsActivity.SecondQuestionAnswer, SA)
                putExtra(ResultsActivity.ThirdQuestionAnswer, "Correct")
            }
            startActivity(A2Next)
        }

        A3.setOnClickListener(){
            val A3Next = Intent(this, ResultsActivity::class.java).apply {
                putExtra(ResultsActivity.UserName, name)
                putExtra(ResultsActivity.FirstQuestionAnswer, FA)
                putExtra(ResultsActivity.SecondQuestionAnswer, SA)
                putExtra(ResultsActivity.ThirdQuestionAnswer, "Incorrect")
            }

            startActivity(A3Next)
        }
    }
}