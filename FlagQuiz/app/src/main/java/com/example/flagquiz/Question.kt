//Author: David Griffith
//Date: 5/10/2022
//Description: Data class for storing information about the different choices that the user can make
package com.example.flagquiz

data class Question(
    val id: Int,
    val question: String,
    val mentalHealthChange: Int,
    val physicalHealthChange: Int,
    val moneyChange: Int,
    val karmaChange: Int
)
