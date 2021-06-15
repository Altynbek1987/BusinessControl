package com.example.businesscontrol.models

import com.example.businesscontrol.R

object LocalData {

    var arr = listOf(
        R.drawable.engine, R.drawable.akkp, R.drawable.hodovoj,R.drawable.electronics,R.drawable.kuzov,
        R.drawable.salon)

    var stringList = listOf(
        "Мотор","АККП", "Ходовая часть", "Электроника", "Кузов", "Салон"
    )

    val dataCategory = listOf(
        Category(0,R.drawable.engine, "Мотор", mutableListOf("1","2","3","4","5")),
        Category(1,R.drawable.akkp,"АККП", mutableListOf("6","7","8","9","10")),
        Category(2,R.drawable.hodovoj,"Ходовая часть", mutableListOf("11","12","13","14","15")),
        Category(3,R.drawable.electronics,"Электроника", mutableListOf("16","17","18","19","20")),
        Category(4,R.drawable.kuzov,"Кузов", mutableListOf("21","22","23","24","25")),
        Category(5,R.drawable.salon,"Салон", mutableListOf("26","27","28","29","30"))
    )
}

data class Category(
    var id: Int,
    var imageId: Int? = null,
    var name: String? = null,
    var listData : MutableList<String>? = null
)