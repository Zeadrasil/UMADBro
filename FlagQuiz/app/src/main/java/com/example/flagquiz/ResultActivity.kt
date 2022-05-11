//auth: Drake Hetland
//date: 5/10/2022
//desc: Result activity for the "Poor Life Decisions" game. Displays how many "days" the player's character survived for.
//skull resource: https://images.vexels.com/media/users/3/224217/isolated/preview/21599e451fbada6bc54b7dd3b23f1998-laughing-skull-cartoon-logo.png
//grim reaper resource: https://wallpaperaccess.com/cute-grim-reaper

package com.example.flagquiz

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        //get score text view and finish button
        val scoreTV: TextView = findViewById(R.id.scoreTV)
        val finishBtn: Button = findViewById(R.id.finishBtn)

        //create empty PlayerCharacter variable
        var playerCharacter: PlayerCharacter? = null

        //assign empty variable tp passed PlayerCharacter instance
        playerCharacter = intent.getSerializableExtra("Player") as? PlayerCharacter

        //display the player character's user name and how many "days" they survived for
        scoreTV.text = "${intent.getStringExtra(Constants.USERNAME)} survived: ${playerCharacter!!.getDayDied()} days before ${playerCharacter.getCauseOfDeath()}!"

        //return player to welcome screen
        finishBtn.setOnClickListener{
            startActivity(Intent(this, MainActivity::class.java))
        }
    }
}