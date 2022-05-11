package com.example.flagquiz

object Constants {
    const val USERNAME: String = "username"
    const val TOTAL_QUESTIONS: String = "total_questions"
    const val CORRECT_ANSWERS: String = "correct_answers"

    fun getQuestions(): ArrayList<Question>{
        val questionsList = ArrayList<Question>()

        var que = Question(0, "Use food for stress relief?", 10, -5, -1, -1)
        questionsList.add(que)

        que = Question(1, "Get into a brawl with the person stalking you?", 20, -10, -1, -1)
        questionsList.add(que)

        que = Question(2, "Take the day off work?", 10, -1, -5, -1)
        questionsList.add(que)

        que = Question(3, "Get therapy?", 20, -1, -10, -1)
        questionsList.add(que)

        que = Question(4, "Yarhar a self help book?", 10, -1, -1, -5)
        questionsList.add(que)

        que = Question(5, "Use magic to transfer your negative emotions to another person?",
            20, -1, -1, -10)
        questionsList.add(que)

        que = Question(6, "Work out instead of going out with friends?", -5, 10, -1, -1)
        questionsList.add(que)

        que = Question(7, "Go through boot camp?", -10, 20, -1, -1)
        questionsList.add(que)

        que = Question(8, "Get a checkup at the doctor?", -1, 10, -5, -1)
        questionsList.add(que)

        que = Question(9, "Go to the hospital?", -1, 20, -10, -1)
        questionsList.add(que)

        que = Question(10, "Steal medicine from an old lady?", -1, 10, -1, -5)
        questionsList.add(que)

        que = Question(11, "Use magic to steal the life force of another person?",
            -1, 20, -1, -10)
        questionsList.add(que)

        que = Question(12, "Work overtime?", -5, -1, 10, -1)
        questionsList.add(que)

        que = Question(13, "Get a part-time customer service job?", -10, -1, 20, -1)
        questionsList.add(que)

        que = Question(14, "Move some heavy boxes for a friend that is moving?", -1, -5, 10, -1)
        questionsList.add(que)

        que = Question(15, "Sell one of your unnecessary organs?", -1, -10, 20, -1)
        questionsList.add(que)

        que = Question(16, "Mug somebody?", -1, -1, 10, -5)
        questionsList.add(que)

        que = Question(17, "Sell an NFT?", -1, -1, 20, -10)
        questionsList.add(que)

        que = Question(18, "Go on jury duty?", -5, -1, -1, 10)
        questionsList.add(que)

        que = Question(19, "Use magic to absorb negative emotions from others?", -10, -1, -1, 20)
        questionsList.add(que)

        que = Question(20, "Go fight some bad guys?", -1, -5, -1, 10)
        questionsList.add(que)

        que = Question(21, "Donate an unnecessary organ?", -1, -10, -1, 20)
        questionsList.add(que)

        que = Question(22, "Donate to a charity?", -1, -1, -5, 10)
        questionsList.add(que)

        que = Question(23, "Spend a workday doing nothing but volunteer work?", -1, -1, -10, 20)
        questionsList.add(que)

        que = Question(24, "Do push-ups during your break during work?", -10, 5, -1, -1)
        questionsList.add(que)

        que = Question(25, "Eat exclusively health food?", -20, 10, -1, -1)
        questionsList.add(que)

        que = Question(26, "Sell your mind as memory storage space using magic?", -10, -1, 5, -1)
        questionsList.add(que)

        que = Question(27, "Sell an old family heirloom?", -20, -1, 10, -1)
        questionsList.add(que)

        que = Question(28, "Volunteer at the local homeless shelter?", -10, -1, -1, 5)
        questionsList.add(que)

        que = Question(29, "Convince some terrorists to let go of some people they have taken as hostages?",
        -20, -1, -1, 10)
        questionsList.add(que)

        que = Question(30, "Drink your problems away?", 5, -10, -1, -1)
        questionsList.add(que)

        que = Question(31, "Go and win a hot-dog eating contest?", 10, -20, -1, -1)
        questionsList.add(que)

        que = Question(32, "Mine in the coal mines for a day to get a bit of pocket cash?",
            -1, -10, 5, -1)
        questionsList.add(que)

        que = Question(33, "Pick up and sell a piece of uranium you found on the ground?",
            -1, -20, 10, -1)
        questionsList.add(que)

        que = Question(34,"Stop a bank robbery by proving that the guns the robbers have are fake?",
            -1, -10, -1, 5)
        questionsList.add(que)

        que = Question(35, "Take a bullet for somebody?", -1, -20, -1, 10)
        questionsList.add(que)

        que = Question(36, "Impulse buy a useless item?", 5, -1, -10, -1)
        questionsList.add(que)

        que = Question(37, "Go on a massive shopping spree?", 10, -1, -20, -1)
        questionsList.add(que)

        que = Question(38, "Get a gym membership?", -1, 5, -10, -1)
        questionsList.add(que)

        que = Question(39, "Get cybernetic implants?", -1, 10, -20, -1)
        questionsList.add(que)

        que = Question(40, "Give a bunch of money to some local beggars?", -1, -1, -10, 5)
        questionsList.add(que)

        que = Question(41, "Buy a homeless man a comfy tent?", -1, -1, -20, 10)
        questionsList.add(que)

        que = Question(42, "Steal some cool rocks from a cool rock store?", 5, -1, -1, -10)
        questionsList.add(que)

        que = Question(43, "Go and kick some people you dislike in the \"sensitive area\"?",
            10, -1, -1, -20)
        questionsList.add(que)

        que = Question(44, "Steal some medical supplies from an ambulance you are walking by?",
            -1, 5,-1, -10)
        questionsList.add(que)

        que = Question(45, "Clean out a drugstore in the middle of the night when everybody is gone?",
            -1, 10, -1, -20)
        questionsList.add(que)

        que = Question(46, "Burglarize some poor people?", -1, -1, 5, -10)
        questionsList.add(que)

        que = Question(47, "Accept an assassination request on a climate change activist?",
            -1, -1, 10, -20)
        questionsList.add(que)

        que = Question(48, "Realize that you are a god?", 75, -1, -1, -1)
        questionsList.add(que)

        que = Question(49, "Realize that you are useless?", -75, -1, -1, -1)
        questionsList.add(que)

        que = Question(50, "Allow a wizard to test his UltraHeal™ spell on you?", -1, 75, -1, -1)
        questionsList.add(que)

        que = Question(51, "Allow a wizard to test his UltraUnHeal™ spell on you?",
            -1, -75, -1, -1)
        questionsList.add(que)

        que = Question(52, "Take the shiny yellow rock the size of a horse?", -1, -1, 75, -1)
        questionsList.add(que)

        que = Question(53, "Brag about successfully committing tax evasion in front of a large group of people, many of whom you do not know?",
            -1, -1, -75, -1)
        questionsList.add(que)

        que = Question(54, "Knock out the terrorist threatening to blow up a nuke in Tokyo?",
            -1, -1, -1, 75)
        questionsList.add(que)

        que = Question(55, "Commit genocide on the people of Ireland by traveling back to the year 1845 and convincing the British to force Ireland " +
         "to maintain a net export of food even as a massive famine is killing a quarter of the population?",
            -1, -1, -1, -75)
        questionsList.add(que)
        return questionsList
    }
}