package com.itiudc.examen_barretorolon.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.itiudc.examen_barretorolon.R

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val UserName = findViewById<EditText>(R.id.user_name)
        val Login = findViewById<Button>(R.id.LoginButton)

        Login.setOnClickListener(){
            if(UserName.text.isEmpty())
            {
                Toast.makeText(this, "Please enter your name", Toast.LENGTH_SHORT).show()
            }
            else
            {
                val start = Intent(this, FirstQuestion::class.java).apply {
                    putExtra(FirstQuestion.UserName, UserName.text.toString())
                }
                startActivity(start)
            }
        }
    }
}