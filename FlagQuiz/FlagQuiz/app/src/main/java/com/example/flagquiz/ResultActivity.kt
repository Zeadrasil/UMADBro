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

        val nameTV: TextView = findViewById(R.id.nameTV)
        val scoreTV: TextView = findViewById(R.id.scoreTV)
        val finishBtn: Button = findViewById(R.id.finishBtn)

        nameTV.text = intent.getStringExtra(Constants.USERNAME)
        scoreTV.text = "Your score: ${intent.getIntExtra(Constants.CORRECT_ANSWERS, 0)} / ${intent.getIntExtra(Constants.TOTAL_QUESTIONS, 0)}"

        finishBtn.setOnClickListener{
            startActivity(Intent(this, MainActivity::class.java))
        }
    }
}