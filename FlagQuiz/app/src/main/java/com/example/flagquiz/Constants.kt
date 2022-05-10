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
        return questionsList
    }
}