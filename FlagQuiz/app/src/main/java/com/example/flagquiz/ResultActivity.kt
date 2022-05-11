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

        val scoreTV: TextView = findViewById(R.id.scoreTV)
        val finishBtn: Button = findViewById(R.id.finishBtn)
        var playerCharacter: PlayerCharacter? = null

        playerCharacter = intent.getSerializableExtra("Player") as? PlayerCharacter

        scoreTV.text = "${intent.getStringExtra(Constants.USERNAME)} survived: ${playerCharacter!!.getDayDied()} days!"

        finishBtn.setOnClickListener{
            startActivity(Intent(this, MainActivity::class.java))
        }
    }
}