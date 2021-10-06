package com.itiudc.examen_barretorolon.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import com.itiudc.examen_barretorolon.R
import com.itiudc.examen_barretorolon.databinding.ActivityResultsBinding

class ResultsActivity : AppCompatActivity() {
    companion object{
        const val UserName = "user_info"
        const val FirstQuestionAnswer = "First_answer"
        const val SecondQuestionAnswer = "Second_answer"
        const val ThirdQuestionAnswer = "Third_answer"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_results)

        val binding = DataBindingUtil.setContentView<ActivityResultsBinding>(this, R.layout.activity_results)

        val bundle: Bundle? = intent.extras

        val name = bundle?.getString(UserName)
        val FA = bundle?.getString(FirstQuestionAnswer)
        val SA = bundle?.getString(SecondQuestionAnswer)
        val TA = bundle?.getString(ThirdQuestionAnswer)

        var total = 0


        if (FA == "Correct") {
            total++
        }

        if (SA == "Correct") {
            total++
        }

        if (TA == "Correct") {
            total++
        }

        binding.user.text = name
        val texto = findViewById<TextView>(R.id.result)
        binding.result.text = texto.text.toString() + " $total/3"

        binding.PlayAgain.setOnClickListener(){
            val playagain = Intent(this, MainActivity::class.java)
            startActivity(playagain)
        }

        binding.root
    }
}