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
    private lateinit var feedBackTv:TextView
    private val QuestionsARR = arrayOf(

        "The Great Wall of China is the only structure that is visible from space", // Arrays questions
        "World War I began in 1914. Answer",
        "Cleopatra was the last ruler of the Ptolemaic dynasty in Egypt.",
        "Nelson Mandela died in 2015",
        "The Nazis invaded Greece during WWII"
    )
    private  val AnswersARR = arrayOf(
        false,true,true,false,true  // Array answer
    )

    private var currentQuestions = 0  // declare variable for the current question number
    private var scoreCount = 0
    private var answer: Boolean? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        // initialise UI elements
        questionsTv=findViewById(R.id.questionsTv)
        trueBtn=findViewById(R.id.trueBtn)
        falseBtn=findViewById(R.id.falseBtn)
        nextBtn=findViewById(R.id.nextBtn)
        feedBackTv=findViewById(R.id.feedBackTv)

        showQuestion() // method being called to show first question
        falseBtn.setOnClickListener(){

        }
        trueBtn.setOnClickListener(){

        }
      nextBtn.setOnClickListener() {

      }


    }
    fun showQuestion (){
        questionsTv.text = QuestionsARR [currentQuestions]
        feedBackTv.text = ""
        answer = null
    }
}