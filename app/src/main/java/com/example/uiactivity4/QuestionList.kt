package com.example.uiactivity4

class QuestionList {

    val q1 =QuestionClass("a collection of key-value pairs, where each key maps to a single value",
        listOf("Map","hashMap","List","Set"),
        0)
    val q2 =QuestionClass("an ordered collection of elements that allows duplicate elements",
        listOf("List","Set","Map","hashMap"),0)

    val q3 =QuestionClass("a collection of unique elements, with no duplicates allowed.",
        listOf("List","Set","Map","hashMap"),1)

    val q4 =QuestionClass("An interface that provides a way to sequentially access the elements of a collection, one at a time",
        listOf("List","ListIterator","Iterator","MutableIterator"),1)

    val q5 =QuestionClass("Is an expression to define a block of code that can be passed around and used as an argument to functions.",
        listOf("Iterator","Set","codeBody","Lambda"),3)


    val questionList = mutableListOf(q1,q2,q3,q4,q5)
}