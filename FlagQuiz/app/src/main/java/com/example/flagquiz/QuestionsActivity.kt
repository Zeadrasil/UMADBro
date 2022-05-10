package com.example.flagquiz

import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import androidx.core.content.ContextCompat

class QuestionsActivity : AppCompatActivity(), View.OnClickListener {

    private var username: String? = null

    private var currentPosition: Int = 1
    private var questionsList: ArrayList<Question>? = null
    private var selectedOptionPosition: Int = 0
    private var correctAnswers: Int = 0

    private var questionTV: TextView? = null
    private var flagTV: ImageView? = null
    private var progressPB: ProgressBar? = null
    private var progressTV: TextView? = null
    private var optionOneTV: TextView? = null
    private var optionTwoTV: TextView? = null
    private var optionThreeTV: TextView? = null
    private var optionFourTV: TextView? = null
    private var submitBtn: Button? = null

    var playerCharacter = PlayerCharacter()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_questions)

        username = intent.getStringExtra(Constants.USERNAME)

        //bind controls to the created variables
        questionTV = findViewById(R.id.questionTV)
        flagTV = findViewById(R.id.flagIV)
        progressPB = findViewById(R.id.mentalHealthPB)
        progressTV = findViewById(R.id.mentalHealthTV)
        optionOneTV = findViewById(R.id.optionOneTV)
        optionTwoTV = findViewById(R.id.optionTwoTV)
        //optionThreeTV = findViewById(R.id.optionThreeTV)
        //optionFourTV = findViewById(R.id.optionFourTV)
        submitBtn = findViewById(R.id.submitBtn)

        //add click listeners
        optionOneTV?.setOnClickListener(this)
        optionTwoTV?.setOnClickListener(this)
        optionThreeTV?.setOnClickListener(this)
        optionFourTV?.setOnClickListener(this)
        submitBtn?.setOnClickListener(this)

        questionsList = Constants.getQuestions()
        setQuestion()

    }

    private fun setQuestion() {
        defaultOptionsView()

        val question: Question = questionsList!![currentPosition - 1]

        //set up question
        questionTV?.text = question.question
        //flagTV?.setImageResource(question.image)
        progressPB?.progress = currentPosition
        progressTV?.text = "$currentPosition / ${progressPB?.max}"

        //set up the answers
        //optionOneTV?.text = question.optionOne
        //optionTwoTV?.text = question.optionTwo
        //optionThreeTV?.text = question.optionThree
        //optionFourTV?.text = question.optionFour
    }

    private fun defaultOptionsView() {
        //this method exists to 'reset' the option displays

        submitBtn?.text = "SUBMIT"

        val options = ArrayList<TextView>()
        optionOneTV?.let {options.add(0, it)}
        optionTwoTV?.let {options.add(1, it)}
        optionThreeTV?.let {options.add(2, it)}
        optionFourTV?.let {options.add(3, it)}

        for (option in options){
            option.setTextColor(Color.parseColor("#7A8089"))
            option.typeface = Typeface.DEFAULT
            option.background = ContextCompat.getDrawable(this, R.drawable.default_option_border_bg)
        }
    }

    private fun selectedOptionView(tv: TextView, selectedOptionNum: Int) {
        defaultOptionsView()
        selectedOptionPosition = selectedOptionNum
        tv.setTextColor(Color.parseColor("#363A43"))// Change the selected options text color
        tv.setTypeface(tv.typeface, Typeface.BOLD) // Make the selected option bold
        tv.background = ContextCompat.getDrawable(this, R.drawable.selected_option_border_bg) //changes the border color for the selected option
    }

    override fun onClick(view: View?) {
        when (view?.id) {
            R.id.optionOneTV ->
                optionOneTV?.let {
                    selectedOptionView(it, 1)
                }
            R.id.optionTwoTV ->
                optionTwoTV?.let {
                    selectedOptionView(it, 2)
                }
            //R.id.optionThreeTV ->
            //    optionThreeTV?.let {
            //        selectedOptionView(it, 3)
            //    }
            //R.id.optionFourTV ->
            //    optionFourTV?.let {
            //        selectedOptionView(it, 4)
            //    }
            R.id.submitBtn -> {
                if (selectedOptionPosition == 0) {
                    currentPosition++

                    when {
                        currentPosition <= questionsList!!.size -> setQuestion()
                        else -> {
                            val intent: Intent = Intent(this, ResultActivity::class.java)
                            intent.putExtra(Constants.USERNAME, username)
                            intent.putExtra(Constants.CORRECT_ANSWERS, correctAnswers)
                            intent.putExtra(Constants.TOTAL_QUESTIONS, questionsList!!.size)
                            startActivity(intent)
                            finish()
                        }
                    }
                }
                else {
                    //get the current question
                    //val question = questionsList?.get(currentPosition- 1)
//
                    //// got it wrog
                    //if (question?.correctAnswer != selectedOptionPosition) {
                    //    answerView(selectedOptionPosition, R.drawable.wrog_option_border_bg)
                    //}
                    ////got it right
                    //else {
                    //    correctAnswers++
                    //}
//
                    //answerView(question!!.correctAnswer, R.drawable.correct_option_border_bg)
//
                    //if (currentPosition == questionsList!!.size)
                    //    submitBtn?.text = "FINISH"
                    //else
                    //    submitBtn?.text = "NEXT QUESTION"
//
                    //selectedOptionPosition = 0
                }
            }
        }
    }

    private fun answerView(answer: Int, drawableView: Int) {
        when (answer) {
            1 -> optionOneTV?.background = ContextCompat.getDrawable(this, drawableView)
            2 -> optionTwoTV?.background = ContextCompat.getDrawable(this, drawableView)
            3 -> optionThreeTV?.background = ContextCompat.getDrawable(this, drawableView)
            4 -> optionFourTV?.background = ContextCompat.getDrawable(this, drawableView)
        }
    }
}