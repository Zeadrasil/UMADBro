//auth: Drake Hetland
//edit: David Griffith
//date: 5/10/2022
//desc: class to house various information necessary to make the game function

package com.example.flagquiz

import java.io.Serializable

class PlayerCharacter () : Serializable
{
    //declare fields
    private var mentalHealth: Int = 50
    private var physicalHealth: Int = 50
    private var money: Int = 50
    private var karma: Int = 50
    private var dayDied: Int = 0

    //accessors
    public fun getMentalHealth(): Int {
        return mentalHealth
    }
    public fun getPhysicalHealth(): Int {
        return physicalHealth
    }
    public fun getMoney(): Int {
        return money
    }
    public fun getKarma(): Int {
        return karma
    }
    public fun getDayDied(): Int {
        return dayDied
    }

    //member function for altering stats
    public fun changeStats(mentalHealthChange: Int, physicalHealthChange: Int, moneyChange: Int, karmaChanged: Int)
    {
        mentalHealth = mentalHealth.plus(mentalHealthChange)
        physicalHealth = physicalHealth.plus(physicalHealthChange)
        money = money.plus(moneyChange)
        karma = karma.plus(karmaChanged)
    }

    //increments the "days" character has survived
    public fun playerSurvived()
    {
        dayDied++
    }
}

