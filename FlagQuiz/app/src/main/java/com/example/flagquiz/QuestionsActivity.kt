//auth: Drake Hetland
//edit: David Griffith
//desc: Randomly pulls a question from the Constants object, and changes the player character's stats based on what they choose.

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
    //declare a bunch of variables
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

    //declare an empty variable of type PlayerCharacter
    var playerCharacter: PlayerCharacter? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_questions)

        username = intent.getStringExtra(Constants.USERNAME)
        //Assign empty variable to the passed PlayerCharacter instance
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
        submitBtn = findViewById(R.id.submitBtn)

        //add click listeners
        yesTV?.setOnClickListener(this)
        noTV?.setOnClickListener(this)
        submitBtn?.setOnClickListener(this)

        //populate questions list
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

        //set/update values of progress bars and text views with values from player character
        mentalPB?.progress = playerCharacter!!.getMentalHealth()
        mentalTV?.text = "${playerCharacter!!.getMentalHealth()} / ${mentalPB?.max}"
        physPB?.progress = playerCharacter!!.getPhysicalHealth()
        physTV?.text = "${playerCharacter!!.getPhysicalHealth()} / ${physPB?.max}"
        moneyPB?.progress = playerCharacter!!.getMoney()
        moneyTV?.text = "${playerCharacter!!.getMoney()} / ${moneyPB?.max}"
        karmaPB?.progress = playerCharacter!!.getKarma()
        karmaTV?.text = "${playerCharacter!!.getKarma()} / ${karmaPB?.max}"
    }

    private fun defaultOptionsView() {
        //this method exists to 'reset' the option displays
        submitBtn?.text = "SUBMIT"

        val options = ArrayList<TextView>()
        yesTV?.let {options.add(0, it)}
        noTV?.let {options.add(1, it)}

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
            R.id.submitBtn -> {

                val question = questionsList?.get(currentPosition- 1)
                if(selectedOptionPosition == 1)
                {
                    //changes player character's stats based on the "yes" stat change value of each question
                    playerCharacter!!.changeStats(question?.mentalHealthChange!!,
                        question?.physicalHealthChange!!,
                        question?.moneyChange!!,
                        question?.karmaChange!!)
                }
                else
                {
                    //decrement player character's stats by a set amount if they choose "no"
                    playerCharacter!!.changeStats(-5, -5, -5, -5)
                }

                //if player is not dead, get another question
                if(playerCharacter!!.getMentalHealth() in 1..99
                    && playerCharacter!!.getPhysicalHealth() in 1..99
                    && playerCharacter!!.getMoney() in 1..99
                    && playerCharacter!!.getKarma() in 1..99)
                {
                    setQuestion()
                }
                //else, player character is dead and should be sent to the result activity
                else
                {
                    //sets the string to be displayed to the death message for that type of death
                    if(playerCharacter!!.getMentalHealth() < 1)
                    {
                        playerCharacter!!.setDeathMessage(0)
                    }
                    else if(playerCharacter!!.getMentalHealth() > 99)
                    {
                        playerCharacter!!.setDeathMessage(1)
                    }
                    else if(playerCharacter!!.getPhysicalHealth() < 1)
                    {
                        playerCharacter!!.setDeathMessage(2)
                    }
                    else if(playerCharacter!!.getPhysicalHealth() > 99)
                    {
                        playerCharacter!!.setDeathMessage(3)
                    }
                    else if(playerCharacter!!.getMoney() < 1)
                    {
                        playerCharacter!!.setDeathMessage(4)
                    }
                    else if(playerCharacter!!.getMoney() > 99)
                    {
                        playerCharacter!!.setDeathMessage(5)
                    }
                    else if(playerCharacter!!.getKarma() < 1)
                    {
                        playerCharacter!!.setDeathMessage(6)
                    }
                    else
                    {
                        playerCharacter!!.setDeathMessage(7)
                    }

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
        }
    }
}