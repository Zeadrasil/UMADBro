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
    private var causeOfDeath: String = ""

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
    public fun getCauseOfDeath(): String {
        return causeOfDeath
    }

    //member function for altering stats
    public fun changeStats(mentalHealthChange: Int, physicalHealthChange: Int, moneyChange: Int, karmaChanged: Int)
    {
        mentalHealth = mentalHealth.plus(mentalHealthChange)
        physicalHealth = physicalHealth.plus(physicalHealthChange)
        money = money.plus(moneyChange)
        karma = karma.plus(karmaChanged)
    }

    //sets message based on how player died
    public fun setDeathMessage(cause: Int)
    {
        when(cause)
        {
            0-> causeOfDeath = "slipped on a pencil while contemplating how terrible their life is and fell off of their balcony"
            1-> causeOfDeath = "trying to stop a train with their bare hands in order to save a butterfly that was on the rails"
            2-> causeOfDeath = "getting dysentery while walking along the Oregon Trail and following the footsteps of so many before them"
            3-> causeOfDeath = "accidentally throwing an anvil straight up instead of forward during a competition"
            4-> causeOfDeath = "getting into a fight with a hobo over a $100 bill and getting a fatal infection from his dirty nails"
            5-> causeOfDeath = "a group of fanatics disobeyed Bill Wurtz and made a religion out of using the guillotine"
            6-> causeOfDeath = "a magnetic meteorite fell on your house and caused an electromagnetic imbalance in" +
                    " the Earth's magnetosphere and exploding their phone while they were talking on it"
            7-> causeOfDeath = "finding a giant pile of extremely rare gold coins and suffocating while attempting to swim in them"
        }
    }

    //increments the "days" character has survived
    public fun playerSurvived()
    {
        dayDied++
    }
}

