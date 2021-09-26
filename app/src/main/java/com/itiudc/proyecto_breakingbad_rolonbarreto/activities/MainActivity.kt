package com.itiudc.proyecto_breakingbad_rolonbarreto.activities

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Switch
import android.widget.Toast
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import com.itiudc.proyecto_breakingbad_rolonbarreto.R
import com.itiudc.proyecto_breakingbad_rolonbarreto.adapters.ViewpageAdapter
import com.itiudc.proyecto_breakingbad_rolonbarreto.fragments.CharactersFragment
import com.itiudc.proyecto_breakingbad_rolonbarreto.fragments.DetailActivity
import com.itiudc.proyecto_breakingbad_rolonbarreto.models.character
import java.lang.ClassCastException
import java.lang.reflect.Type

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        Thread.sleep(3000)//Segundos en los que se muestra la splash screen para la splash screen

        setTheme(R.style.SplashTheme)//Llama el tema de la splashscreen

        super.onCreate(savedInstanceState)

        setContentView(R.layout.login_screen)

        //Llama e inicializa la función de validación
        login_validation()

    }


    public fun login_validation() {
        val LoginEmail = findViewById<EditText>(R.id.login_email)
        val LoginPassword = findViewById<EditText>(R.id.login_password)
        val LoginButton = findViewById<Button>(R.id.login_button)

        LoginButton.setOnClickListener() {
            if (LoginEmail.text.isEmpty() || LoginPassword.text.isEmpty()) {
                Toast.makeText(this, "Make sure to fill in all the fields!", Toast.LENGTH_SHORT)
                    .show()
            } else if(LoginEmail.text.contains("@")){
                Toast.makeText(this, "Welcome!", Toast.LENGTH_SHORT)
                    .show()
                setContentView(R.layout.activity_main)
                lateinit var movieSelectListener: CharactersFragment.MovieSelectListener

                //Llamando los fragments despues de que el usuario inicie seison y se cree la actividad
                calling_fragments()

            }else{

                Toast.makeText(this, "Invalid email", Toast.LENGTH_SHORT).show()
            }
        }
    }

    public fun calling_fragments(){
        val tabLayout = findViewById<TabLayout>(R.id.tab_layout)
        val viewPager2 = findViewById<ViewPager2>(R.id.view_pager_2)

        val adapter = ViewpageAdapter(supportFragmentManager, lifecycle)

        viewPager2.adapter=adapter
        TabLayoutMediator(tabLayout, viewPager2){tab, position->
            when(position){
                0->{
                    tab.text = "CHARACTERS"
                }
                1->{
                    tab.text = "PHRASE"
                }
                2->{
                    tab.text = "SETTINGS"
                }
            }
        }.attach()
    }
}