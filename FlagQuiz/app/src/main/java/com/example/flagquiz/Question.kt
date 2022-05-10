package com.example.flagquiz

data class Question(
    val id: Int,
    val question: String,
    val mentalHealthChange: Int,
    val physicalHealthChange: Int,
    val moneyChange: Int,
    val karmaChange: Int
)
