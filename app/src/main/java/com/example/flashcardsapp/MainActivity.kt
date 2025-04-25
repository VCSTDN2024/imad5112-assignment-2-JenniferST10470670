package com.example.flashcardsapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {


    private lateinit var startBtn: Button
    private lateinit var exitBtn: Button
    private lateinit var imageView: ImageView



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        startBtn = findViewById(R.id.startBtn)
        exitBtn = findViewById(R.id.exitBtn)
        imageView = findViewById(R.id.welcomeImg)



        startBtn.setOnClickListener {

            val intent = Intent(this, QuestionsActivity::class.java)
            startActivity(intent)   // holding the value of question Activity
            finish()


        }
    exitBtn.setOnClickListener(){

    }
    }


}