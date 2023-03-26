package com.example.uiactivity4

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import com.example.uiactivity4.databinding.UserActivityBinding
import kotlin.random.Random

class UserPanel : AppCompatActivity() {
    private var selectedAnswer: TextView? = null
    private lateinit var qQuestionList: MutableList<QuestionClass>

    private var userScore = 0

    private lateinit var binding: UserActivityBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = UserActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)

        qQuestionList = QuestionList().questionList

        randomQuestion()

        binding.optionA.setOnClickListener {
            selectAnswer(binding.optionA)
        }
        binding.optionB.setOnClickListener {
            selectAnswer(binding.optionB)
        }
        binding.optionC.setOnClickListener {
            selectAnswer(binding.optionC)
        }
        binding.optionD.setOnClickListener {
            selectAnswer(binding.optionD)
        }

        binding.next.setOnClickListener {
            if (selectedAnswer == null) {
                Toast.makeText(this, "Please select an answer", Toast.LENGTH_LONG).show()
                return@setOnClickListener
            }

            val question = qQuestionList.removeAt(Random.nextInt(qQuestionList.size))

            if (question.correctAnswer == getSelectedAnswerIndex()) {
                Toast.makeText(this, "You got the answer right!", Toast.LENGTH_LONG).show()

                userScore += 1
            } else {
                Toast.makeText(this, "Sorry, the correct answer is ${question.answers[question.correctAnswer]}", Toast.LENGTH_LONG).show()
            }

            // clear the selection
            selectedAnswer?.setBackgroundColor(Color.TRANSPARENT)
            selectedAnswer = null

            //set new question
            randomQuestion()
        }
    }

    private fun selectAnswer(answer: TextView) {
        selectedAnswer?.setBackgroundColor(Color.TRANSPARENT)
        answer.setBackgroundColor(Color.GREEN)
        selectedAnswer = answer
    }

    private fun getSelectedAnswerIndex(): Int {
        return when (selectedAnswer) {
            binding.optionA -> 0
            binding.optionB -> 1
            binding.optionC -> 2
            binding.optionD -> 3
            else -> -1
        }
    }

    private fun randomQuestion() {

        if (qQuestionList.isEmpty()) {
            val intent = Intent(this@UserPanel,Scores::class.java)
            intent.putExtra("Score", userScore)
            startActivity(intent)


        } else {
            // show a random question
            val randomIndex = Random.nextInt(qQuestionList.size)
            val question = qQuestionList[randomIndex]

            binding.questionTextView.text = question.question
            binding.optionA.text = question.answers[0]
            binding.optionB.text = question.answers[1]
            binding.optionC.text = question.answers[2]
            binding.optionD.text = question.answers[3]
        }
    }

}
