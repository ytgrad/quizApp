package com.example.quizzapp

object Constants{

    const val USER_NAME : String = "user_name"
    const val TOTAL_QUESTIONS  : String = "total_questions"
    const val CORRECT_ANSWERS : String = "correct_answers"

    fun getQuestion():ArrayList<Question>{
        val questionList = ArrayList<Question>()
        val q1 = Question(
            1,
            "What is this game called ?",
            R.drawable.go,
            "Checkers",
            "Chess",
            "Go",
            "Chinese Checkers",
            3
        )
        questionList.add(q1)

        val q2 = Question(
            2,
            "Which country does this player play for ?",
            R.drawable.haaland,
            "Norway",
            "Brazil",
            "Argentina",
            "Portugal",
            1
        )
        questionList.add(q2)

        val q3 =Question(
            3,
            "When was the first iPhone announced ?",
            R.drawable.iphone,
            "2005",
            "2006",
            "2007",
            "2008",
            3
        )
        questionList.add(q3)

        val q4 = Question(
            4,
            "Which country does this flag belong to ?",
            R.drawable.newzealand,
            "New Zealand",
            "Australia",
            "USA",
            "United Kingdom",
            1
        )
        questionList.add(q4)

        val q5 = Question(
            5,
            "Who is this person ?",
            R.drawable.larryfink,
            "George Soros",
            "Warren Buffet",
            "Larry Fink",
            "Peter Lynch",
            3
        )
        questionList.add(q5)

        val q6 = Question(
            6,
            "Who is this person ?",
            R.drawable.sama,
            "Mark Zuckerberg",
            "Larry Page",
            "Satya Nadella",
            "Sam Altman",
            4
        )
        questionList.add(q6)

        val q7 = Question(
            7,
            "Which of these is not a member of NATO ?",
            R.drawable.nato,
            "Ukraine",
            "Poland",
            "Slovakia",
            "Czech Republic",
            1
        )
        questionList.add(q7)

        val q8 = Question(
            8,
            "Which of the following countries has the most forest cover ?",
            R.drawable.forest,
            "USA",
            "Russia",
            "Brazil",
            "India",
            2
        )
        questionList.add(q8)

        val q9 = Question(
            9,
            "Largest cricket stadium by field size ?",
            R.drawable.scg,
            "Sydney Cricket Ground",
            "Melbourne Cricket Ground",
            "Narendra Modi Cricket Stadium",
            "Eden Gardens",
            2
        )
        questionList.add(q9)

        val q10 = Question(
            10,
            "Richest country by per capita income ?",
            R.drawable.percapita,
            "Luxembourg",
            "USA",
            "Saudi Arabia",
            "Switzerland",
            1
        )
        questionList.add(q10)

        return questionList
    }

}