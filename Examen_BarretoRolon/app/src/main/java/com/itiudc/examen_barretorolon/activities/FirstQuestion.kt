package com.itiudc.examen_barretorolon.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import com.itiudc.examen_barretorolon.R

class FirstQuestion : AppCompatActivity() {
    companion object{
        const val UserName = "user_info"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_first_question)
        val bundle: Bundle? = intent.extras

        val A1 = findViewById<Button>(R.id.Answer1)
        val A2 = findViewById<Button>(R.id.Answer2)
        val A3 = findViewById<Button>(R.id.Answer3)

        val name = bundle?.getString(UserName)

        A1.setOnClickListener(){
            val A1Next = Intent(this, SecondQuestion::class.java).apply {
                putExtra(SecondQuestion.UserName, name)
                putExtra(SecondQuestion.FirstQuestionAnswer, "Correct")
            }
            startActivity(A1Next)
        }

        A2.setOnClickListener(){
            val A2Next = Intent(this, SecondQuestion::class.java).apply {
                putExtra(SecondQuestion.UserName, name)
                putExtra(SecondQuestion.FirstQuestionAnswer, "Incorrect")
            }
            startActivity(A2Next)
        }

        A3.setOnClickListener(){
            val A3Next = Intent(this, SecondQuestion::class.java).apply {
                putExtra(SecondQuestion.UserName, name)
                putExtra(SecondQuestion.FirstQuestionAnswer, "Incorrect")
            }
            startActivity(A3Next)
        }
    }
}