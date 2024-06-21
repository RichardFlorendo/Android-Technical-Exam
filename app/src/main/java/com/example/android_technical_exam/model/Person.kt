package com.example.android_technical_exam.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Person( //Needed to be set up to adhere to the JSON list source
    val idCategory: String,
    val strCategory: String,
    val strCategoryThumb: String,
    val strCategoryDescription: String): Parcelable //Added to make objects parcelable


data class PersonResponse(val categories : List<Person>)
//the entire JSON list from the URL, stored in the Category list