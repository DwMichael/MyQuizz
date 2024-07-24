package com.example.myquizz

object Constants {

    const val USER_NAME : String = "user_name"
    const val TOTAL_QUESTIONS : String = "total_questions"
    const val CORRECT_ANSWERS: String = "correct_answers"

    fun getQuestions():ArrayList<Question>{
        val questionList = ArrayList<Question>()
        val que1 = Question(
            1,
            "What country does this flag belong to?",
            R.drawable.ic_flag_of_argentina,
            "Argentina","Australia","Armenia",
            "Austria",
            1

        )
        val que2 = Question(
            2,
            "What country does this flag belong to?",
            R.drawable.ic_flag_of_fiji,
            "Argentina",
            "England",
            "Poland",
            "Fiji",
            4

        )
        val que3 = Question(
            3,
            "What country does this flag belong to?",
            R.drawable.ic_flag_of_australia,
            "Turkey",
            "Australia",
            "Armenia",
            "Austria",
            2

        )
        val que4 = Question(
            4,
            "What country does this flag belong to?",
            R.drawable.ic_flag_of_belgium,
            "Argentina",
            "Belgium",
            "Germany",
            "Russia",
            2

        )
        val que5 = Question(
            5,
            "What country does this flag belong to?",
            R.drawable.ic_flag_of_brazil,
            "USA",
            "Colombia",
            "Brazil",
            "China",
            3

        )
        val que6 = Question(
            6,
            "What country does this flag belong to?",
            R.drawable.ic_flag_of_denmark,
            "Colombia",
            "Peru",
            "Denmark",
            "Poland",
            3

        )
        val que7 = Question(
            7,
            "What country does this flag belong to?",
            R.drawable.ic_flag_of_india,
            "China",
            "Israel",
            "France",
            "India",
            4

        )

        val que8 = Question(
            8,
            "What country does this flag belong to?",
            R.drawable.ic_flag_of_kuwait,
            "Peru",
            "Kuwait",
            "Egypt",
            "Austria",
            2

        )
        val que9 = Question(
            9,
            "What country does this flag belong to?",
            R.drawable.ic_flag_of_new_zealand,
            "New Zealand",
            "Indonesia",
            "China",
            "Korea",
            1

        )
        val que10 = Question(
            10,
            "What country does this flag belong to?",
            R.drawable.ic_flag_of_germany,
            "Poland",
            "Australia",
            "Germany",
            "Austria",
            3

        )
        questionList.add(que1)
        questionList.add(que2)
        questionList.add(que3)
        questionList.add(que4)
        questionList.add(que5)
        questionList.add(que6)
        questionList.add(que7)
        questionList.add(que8)
        questionList.add(que9)
        questionList.add(que10)

        return questionList
    }
}