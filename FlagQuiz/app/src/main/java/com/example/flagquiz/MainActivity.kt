//auth: Drake Hetland
//date: 5/10/2022
//desc: Welcome form for "Poor Life Decisions". Takes in the player designated username and passes to Constants.
//      Creates the PlayerCharacter instance that will be used for the game loop and passes to QuestionsActivity via intent.

package com.example.flagquiz

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val startBtn: Button = findViewById(R.id.startBtn)
        val nameET: EditText = findViewById(R.id.nameET)

        //create instance of player character
        var playerCharacter = PlayerCharacter()

        startBtn.setOnClickListener{
            //check if name text box is empty
            if (nameET.text.isEmpty())
                Toast.makeText(this, "Please enter your name", Toast.LENGTH_LONG).show()
            else{
                //create an instance of the questions activity
                val intent: Intent = Intent(this, QuestionsActivity::class.java)
                //send data via the intent
                intent.putExtra(Constants.USERNAME, nameET.text.toString())
                intent.putExtra("Player", playerCharacter)
                //switch to the new activity
                startActivity(intent)
                //end current activity
                finish()
            }
        }
    }
}