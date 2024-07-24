package com.example.myquizz

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity



class ResultActivity : AppCompatActivity() {

    private var score : Int = 0;

    private var tvUserName: TextView? = null;
    private var tvScore: TextView? = null;
    private var buttonFinish: Button? = null;


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d("ResultActivity", "onCreate called")
        setContentView(R.layout.activity_result)

        tvUserName = findViewById(R.id.user_name_tv)
        tvScore = findViewById(R.id.tv_score)
        buttonFinish = findViewById(R.id.finish_btn)

        tvUserName?.text = intent.getStringExtra(Constants.USER_NAME)

        val totalQuestions =intent.getIntExtra(Constants.TOTAL_QUESTIONS, 0 )
        val correctAnswers =intent.getIntExtra(Constants.CORRECT_ANSWERS,0)

        tvScore?.text = "Your Score is $correctAnswers out of $totalQuestions"
        buttonFinish?.setOnClickListener{
            startActivity(Intent(this,MainActivity::class.java))
        }

    }

}