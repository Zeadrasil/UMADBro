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
import kotlin.random.Random

class QuestionsActivity : AppCompatActivity(), View.OnClickListener {

    private var username: String? = null

    private var currentPosition: Int = 1
    private var lastPosition: Int = 1
    private var questionsList: ArrayList<Question>? = null
    private var selectedOptionPosition: Int = 0

    private var questionTV: TextView? = null
    private var mentalPB: ProgressBar? = null
    private var mentalTV: TextView? = null
    private var physPB: ProgressBar? = null
    private var physTV: TextView? = null
    private var moneyPB: ProgressBar? = null
    private var moneyTV: TextView? = null
    private var karmaPB: ProgressBar? = null
    private var karmaTV: TextView? = null


    private var yesTV: TextView? = null
    private var noTV: TextView? = null
    private var submitBtn: Button? = null

    var playerCharacter: PlayerCharacter? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_questions)

        username = intent.getStringExtra(Constants.USERNAME)
        playerCharacter = intent.getSerializableExtra("Player") as? PlayerCharacter

        //bind controls to the created variables
        questionTV = findViewById(R.id.questionTV)
        mentalPB = findViewById(R.id.mentalHealthPB)
        mentalTV = findViewById(R.id.mentalHealthTV)
        physPB = findViewById(R.id.physicalHealthPB)
        physTV = findViewById(R.id.physicalHealthTV)
        moneyPB = findViewById(R.id.moneyPB)
        moneyTV = findViewById(R.id.moneyTV)
        karmaPB = findViewById(R.id.karmaPB)
        karmaTV = findViewById(R.id.karmaTV)
        yesTV = findViewById(R.id.optionOneTV)
        noTV = findViewById(R.id.optionTwoTV)
        //optionThreeTV = findViewById(R.id.optionThreeTV)
        //optionFourTV = findViewById(R.id.optionFourTV)
        submitBtn = findViewById(R.id.submitBtn)

        //add click listeners
        yesTV?.setOnClickListener(this)
        noTV?.setOnClickListener(this)
        //optionThreeTV?.setOnClickListener(this)
        //optionFourTV?.setOnClickListener(this)
        submitBtn?.setOnClickListener(this)

        questionsList = Constants.getQuestions()
        setQuestion()

    }

    private fun setQuestion() {
        defaultOptionsView()
        lastPosition = currentPosition

        while(currentPosition == lastPosition)
        {
            currentPosition = Random.nextInt(questionsList!!.size + 1)
        }
        val question: Question = questionsList!![currentPosition - 1]

        //set up question
        questionTV?.text = question.question
        //flagTV?.setImageResource(question.image)
        mentalPB?.progress = playerCharacter!!.getMentalHealth()
        mentalTV?.text = "${playerCharacter!!.getMentalHealth()} / ${mentalPB?.max}"
        physPB?.progress = playerCharacter!!.getPhysicalHealth()
        physTV?.text = "${playerCharacter!!.getPhysicalHealth()} / ${physPB?.max}"
        moneyPB?.progress = playerCharacter!!.getMoney()
        moneyTV?.text = "${playerCharacter!!.getMoney()} / ${moneyPB?.max}"
        karmaPB?.progress = playerCharacter!!.getKarma()
        karmaTV?.text = "${playerCharacter!!.getKarma()} / ${karmaPB?.max}"

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
        yesTV?.let {options.add(0, it)}
        noTV?.let {options.add(1, it)}
        //optionThreeTV?.let {options.add(2, it)}
        //optionFourTV?.let {options.add(3, it)}

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
                yesTV?.let {
                    selectedOptionView(it, 1)
                }
            R.id.optionTwoTV ->
                noTV?.let {
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

                val question = questionsList?.get(currentPosition- 1)
                if(selectedOptionPosition == 1)
                {
                    playerCharacter!!.changeStats(question?.mentalHealthChange!!,
                        question?.physicalHealthChange!!,
                        question?.moneyChange!!,
                        question?.karmaChange!!)
                }
                else
                {
                    playerCharacter!!.changeStats(-1, -1, -1, -1)
                }

                if(playerCharacter!!.getMentalHealth() in 1..99
                    && playerCharacter!!.getPhysicalHealth() in 1..99
                    && playerCharacter!!.getMoney() in 1..99
                    && playerCharacter!!.getKarma() in 1..99)
                {
                    setQuestion()
                }
                else
                {
                    val intent: Intent = Intent(this, ResultActivity::class.java)
                    intent.putExtra("Player", playerCharacter)
                    intent.putExtra("Death", playerCharacter?.getDayDied())
                    startActivity(intent)
                    finish()
                }
            }
        }
    }

    private fun answerView(answer: Int, drawableView: Int) {
        when (answer) {
            1 -> yesTV?.background = ContextCompat.getDrawable(this, drawableView)
            2 -> noTV?.background = ContextCompat.getDrawable(this, drawableView)
            //3 -> optionThreeTV?.background = ContextCompat.getDrawable(this, drawableView)
            //4 -> optionFourTV?.background = ContextCompat.getDrawable(this, drawableView)
        }
    }
}