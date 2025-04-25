package com.example.flashcardsapp

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ScoreActivity : AppCompatActivity() {

    private lateinit var scoreTxt: TextView
    private lateinit var feedbackTx:TextView
    private lateinit var reviewBtn: Button
    private lateinit var exitBtn: Button

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

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_score_acativity)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        scoreTxt=findViewById(R.id.scoreTxt)
        feedbackTx=findViewById(R.id.feedbackTxt)
        reviewBtn=findViewById(R.id.reviewBtn)
        exitBtn=findViewById(R.id.exitBtn)

        val ScoreCount=intent.getIntExtra("scoreCount",0)
        scoreTxt.text="your score:$ScoreCount/5 "

       var feedbackMsg=""
        if (ScoreCount >=3){
            feedbackMsg="Fantastic job keep it up !"
        }
        else{
            feedbackMsg="Keep practicing "
        }
        feedbackTx.text= feedbackMsg

        reviewBtn.setOnClickListener(){
           val builder = AlertDialog.Builder(this)
            val reviewTxt = StringBuilder()
            for (i in QuestionsARR.indices){
                reviewTxt.append("${i + 1}. ${ QuestionsARR[i]}\nAnswer: ${if (AnswersARR[i]) "True" else "False"}\n\n")

            }
            exitBtn.setOnClickListener(){

            }
            builder.setTitle("Review FlashCards")
                .setMessage(reviewTxt.toString())
                .setPositiveButton("okay",null)
                .show()

        }


    }
}