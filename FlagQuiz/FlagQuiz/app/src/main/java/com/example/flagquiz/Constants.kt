package com.example.flagquiz

object Constants {
    const val USERNAME: String = "username"
    const val TOTAL_QUESTIONS: String = "total_questions"
    const val CORRECT_ANSWERS: String = "correct_answers"

    fun getQuestions(): ArrayList<Question>{
        val questionsList = ArrayList<Question>()

        //Argentina Flag
        var que = Question(
            0,
            "Which country does this flag represent?",
            R.drawable.ic_flag_argentina,
            "Argentina",
            "Australia",
            "Fiji",
            "India",
            1
        )
        questionsList.add(que)

        //Aus Flag
        que = Question(
            1,
            "Which country does this flag represent?",
            R.drawable.ic_flag_australia,
            "Great Britain",
            "Kuwait",
            "Australia",
            "Argentina",
            3
        )
        questionsList.add(que)

        //Belgium Flag
        que = Question(
            2,
            "Which country does this flag represent?",
            R.drawable.ic_flag_belgium,
            "Germany",
            "Australia",
            "Fiji",
            "Belgium",
            4
        )
        questionsList.add(que)

        //Brazil Flag
        que = Question(
            1,
            "Which country does this flag represent?",
            R.drawable.ic_flag_brazil,
            "Argentina",
            "Kuwait",
            "India",
            "Brazil",
            4
        )
        questionsList.add(que)

        //Denmark Flag
        que = Question(
            1,
            "Which country does this flag represent?",
            R.drawable.ic_flag_denmark,
            "Switzerland",
            "Denmark",
            "Germany",
            "New Zealand",
            2
        )
        questionsList.add(que)

        //fiji Flag
        que = Question(
            1,
            "Which country does this flag represent?",
            R.drawable.ic_flag_fiji,
            "Fiji",
            "Australia",
            "England",
            "New Zealand",
            1
        )
        questionsList.add(que)

        //Germany Flag
        que = Question(
            1,
            "Which country does this flag represent?",
            R.drawable.ic_flag_germany,
            "Switzerland",
            "Belgium",
            "Germany",
            "Australia",
            3
        )
        questionsList.add(que)

        //India Flag
        que = Question(
            1,
            "Which country does this flag represent?",
            R.drawable.ic_flag_india,
            "Fiji",
            "India",
            "Kuwait",
            "Philippines",
            2
        )
        questionsList.add(que)

        //Kuwait Flag
        que = Question(
            1,
            "Which country does this flag represent?",
            R.drawable.ic_flag_kuwait,
            "Kuwait",
            "Italy",
            "Greece",
            "Turkey",
            1
        )
        questionsList.add(que)

        //NZ Flag
        que = Question(
            1,
            "Which country does this flag represent?",
            R.drawable.ic_flag_new_zealand,
            "South Africa",
            "Australia",
            "New Zealand",
            "England",
            3
        )
        questionsList.add(que)

            return questionsList
    }
}