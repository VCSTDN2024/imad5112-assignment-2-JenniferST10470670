package com.example.flashcardsapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import kotlinx.coroutines.selects.select

class QuestionsActivity : AppCompatActivity() {

    private lateinit var questionsTv: TextView
    private lateinit var trueBtn: Button
    private lateinit var falseBtn: Button
    private lateinit var nextBtn: Button
    private lateinit var feedBackTv: TextView
    private val QuestionsARR = arrayOf(

        "The Great Wall of China is the only structure that is visible from space", // Arrays questions
        "World War I began in 1914. Answer",
        "Cleopatra was the last ruler of the Ptolemaic dynasty in Egypt.",
        "Nelson Mandela died in 2015",
        "The Nazis invaded Greece during WWII"
    )
    private val AnswersARR = arrayOf(
        false, true, true, false, true  // Array answer
    )

    private var currentQuestions = 0  // declare variable for the current question number
    private var ScoreCount = 0
    private var answer: Boolean? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_questions)

        // initialise UI elements
        questionsTv = findViewById(R.id.questionsTv)
        trueBtn = findViewById(R.id.trueBtn)
        falseBtn = findViewById(R.id.falseBtn)
        nextBtn = findViewById(R.id.nextBtn)
        feedBackTv = findViewById(R.id.feedBackTv)

        showQuestion() // method being called to show first question
        falseBtn.setOnClickListener() {
            answer = false
            checkAnswer()
            falseBtn.isEnabled = false
            trueBtn.isEnabled = false

        }
        trueBtn.setOnClickListener() {
            answer = true
            trueBtn.isEnabled = false
            falseBtn.isEnabled = false
            checkAnswer()
        }
        nextBtn.setOnClickListener() {
            trueBtn.isEnabled = true
            falseBtn.isEnabled = true
            currentQuestions++
            if (currentQuestions < QuestionsARR.size) {
                showQuestion()
            } else {
                val intent = Intent(this, ScoreActivity::class.java)
                intent.putExtra("scoreCount", ScoreCount)
                startActivity(intent) // holding the value of question Activity
                finish()

            }
        }


    }

    fun showQuestion() {
        questionsTv.text = QuestionsARR[currentQuestions]
        feedBackTv.text = ""
        answer = null
    }

    fun checkAnswer() {
        for (i in QuestionsARR.indices) {
            if (i == currentQuestions) {
                val correctAnswer = AnswersARR[i]
                if (answer == correctAnswer) {
                    feedBackTv.text = "correctAnswer "
                    ScoreCount++
                } else {
                    feedBackTv.text = "incorrectAnswer"
                }
            }
        }

    }

}




