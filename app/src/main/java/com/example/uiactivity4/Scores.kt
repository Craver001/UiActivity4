package com.example.uiactivity4

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class Scores : AppCompatActivity() {

    lateinit var Score : TextView
    lateinit var PlayAgain : Button
    lateinit var Exit : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_scores)


        Score = findViewById(R.id.textViewFinalScore)
        PlayAgain = findViewById(R.id.buttonPlayAgain)
        Exit = findViewById(R.id.buttonExit)

        val score = intent.getIntExtra("Score",0)
        Score.text = score.toString()


        PlayAgain.setOnClickListener{

            val intent = Intent(this@Scores,MainActivity::class.java)
            startActivity(intent)

        }

        Exit.setOnClickListener{

            exitApp()
        }

    }

    private fun exitApp() {
        finishAffinity() // Closes all open activities
        System.exit(0) // Shuts down the process
    }
}