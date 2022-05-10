package com.example.flagquiz

import java.io.Serializable

class PlayerCharacter () : Serializable
{
    //declare fields
    private var mentalHealth: Int = 50
    private var physicalHealth: Int = 50
    private var money: Int = 50
    private var karma: Int = 50

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

    //member function
    public fun changeStats(mentalHealthChange: Int, physicalHealthChange: Int, moneyChange: Int, karmaChanged: Int)
    {
        mentalHealth = mentalHealth.plus(mentalHealthChange)
        physicalHealth = physicalHealth.plus(physicalHealthChange)
        money = money.plus(moneyChange)
        karma = karma.plus(karmaChanged)
    }
}

