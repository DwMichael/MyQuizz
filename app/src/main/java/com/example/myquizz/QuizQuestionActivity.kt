package com.example.myquizz

import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat

class QuizQuestionActivity : AppCompatActivity(),  View.OnClickListener {

    private var mCurrentPosition : Int = 1
    private var mQuestionsList: ArrayList<Question>? = null
    private var mSelectedOptionPosition: Int = 0
    private var mUserName: String? = null
    private var mCorrectAnswers: Int = 0

    private var tvQuestion : TextView? = null
    private var imgFlag : ImageView? = null
    private var progressBar: ProgressBar? = null
    private var tvProgress: TextView? = null
    private var questionOptionFirst: TextView? = null
    private var questionOptionSecond: TextView? = null
    private var questionOptionThird: TextView? = null
    private var questionOptionFourth: TextView? = null
    private var submitBtn: Button? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quizz_question)

        mUserName = intent.getStringExtra(Constants.USER_NAME)


        tvQuestion = findViewById(R.id.tv_title)
        imgFlag = findViewById(R.id.img_flag)
        progressBar = findViewById(R.id.progressBar)
        tvProgress = findViewById(R.id.tv_progress)
        questionOptionFirst = findViewById(R.id.tv_option_first)
        questionOptionSecond = findViewById(R.id.tv_option_second)
        questionOptionThird = findViewById(R.id.tv_option_third)
        questionOptionFourth = findViewById(R.id.tv_option_fourth)
        submitBtn = findViewById(R.id.submit_btn)
        mQuestionsList = Constants.getQuestions()
        questionOptionFirst?.setOnClickListener(this)
        questionOptionSecond?.setOnClickListener(this)
        questionOptionThird?.setOnClickListener(this)
        questionOptionFourth?.setOnClickListener(this)
        submitBtn?.setOnClickListener(this)

        setQuestion()

    }

    private fun setQuestion() {
        defaultOptionsView()
        val question: Question = mQuestionsList!![mCurrentPosition - 1]
        tvQuestion?.text = question.question
        imgFlag?.setImageResource(question.image)
        progressBar?.progress = mCurrentPosition
        tvProgress?.text = "$mCurrentPosition/${progressBar?.max}"
        questionOptionFirst?.text = question.optionOne
        questionOptionSecond?.text = question.optionTwo
        questionOptionThird?.text = question.optionThree
        questionOptionFourth?.text = question.optionFour

        if(mCurrentPosition == mQuestionsList!!.size){
            submitBtn?.text = "FINISH"
        }else{
            submitBtn?.text = "SUBMIT"
        }
    }

    private fun defaultOptionsView(){
        val options = ArrayList<TextView>()
        questionOptionFirst?.let{
            options.add(0, it)
        }
        questionOptionSecond?.let{
            options.add(1, it)
        }
        questionOptionThird?.let{
            options.add(2, it)
        }
        questionOptionFourth?.let{
            options.add(3, it)
        }

        for(option in options){
            option.setTextColor(Color.parseColor("#7A8089"))
            option.typeface = Typeface.DEFAULT
            option.background = ContextCompat.getDrawable(this,R.drawable.default_option_border_bg)
        }
    }

    private fun selectedOptionView(tv: TextView, selectedOptionNum: Int) {
        defaultOptionsView()
        mSelectedOptionPosition = selectedOptionNum

        tv.setTextColor(Color.parseColor("#363A43"))
        tv.setTypeface(tv.typeface, Typeface.BOLD)
        tv.background = ContextCompat.getDrawable(this,R.drawable.selected_border_bg)
    }

    override fun onClick(view: View?) {
        when(view?.id){
            R.id.tv_option_first ->{
                questionOptionFirst?.let{
                    selectedOptionView(it,1)
                }

            }
            R.id.tv_option_second ->{
                questionOptionSecond?.let{
                    selectedOptionView(it,2)
                }

            }
            R.id.tv_option_third ->{
                questionOptionThird?.let{
                    selectedOptionView(it,3)
                }

            }
            R.id.tv_option_fourth ->{
                questionOptionFourth?.let{
                    selectedOptionView(it,4)
                }

            }
            R.id.submit_btn -> {
                if(mSelectedOptionPosition == 0 ){
                    mCurrentPosition++

                    when{
                        mCurrentPosition < mQuestionsList!!.size -> {
                            setQuestion()
                        }
                        else -> {
                            val intent = Intent(this, ResultActivity::class.java)
                            intent.putExtra(Constants.USER_NAME, mUserName)
                            intent.putExtra(Constants.CORRECT_ANSWERS, mCorrectAnswers) // Corrected this line
                            intent.putExtra(Constants.TOTAL_QUESTIONS, mQuestionsList?.size)
                            startActivity(intent)
                            finish()

                        }
                    }
                }else{
                    val question = mQuestionsList?.get(mCurrentPosition - 1)
                    if(question!!.correctAnswer != mSelectedOptionPosition ){
                          answerView(mSelectedOptionPosition, R.drawable.incorrect_option_border_bg)
                    }else{
                        mCorrectAnswers++
                    }
                    answerView(question.correctAnswer, R.drawable.correct_option_border_bg)
                    if(mCurrentPosition == mQuestionsList!!.size)
                    {
                        submitBtn?.text = "FINISH"
                    }else{
                        submitBtn?.text = "GO TO THE NEXT QUESTION"
                    }
                    mSelectedOptionPosition = 0
                }
            }

        }

    }
    private fun answerView(answer: Int ,drawableView: Int){
        when(answer){
            1-> {
                questionOptionFirst?.background = ContextCompat.getDrawable(this,
                    drawableView )
            }
            2-> {
                questionOptionSecond?.background = ContextCompat.getDrawable(this,
                    drawableView )
            }

            3-> {
                questionOptionThird?.background = ContextCompat.getDrawable(this,
                    drawableView )
            }

            4-> {
                questionOptionFourth?.background = ContextCompat.getDrawable(this,
                    drawableView )
            }


        }
    }


}