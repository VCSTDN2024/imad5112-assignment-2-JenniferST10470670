package com.example.flashcardsapp

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class QuestionsActivity : AppCompatActivity() {

    private lateinit var questionsTv:TextView
    private lateinit var trueBtn:Button
    private lateinit var falseBtn:Button
    private lateinit var nextBtn:Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_questions)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        questionsTv=findViewById(R.id.questionsTv)
        trueBtn=findViewById(R.id.trueBtn)
        falseBtn=findViewById(R.id.falseBtn)
        nextBtn=findViewById(R.id.nextBtn)
    }
}