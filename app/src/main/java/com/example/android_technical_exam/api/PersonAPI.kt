package com.example.android_technical_exam.api

import com.example.android_technical_exam.model.PersonResponse
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

private val retrofit = Retrofit.Builder().baseUrl("https://randomuser.me/") //baseURL
    .addConverterFactory(GsonConverterFactory.create())
    .build()

val personservice = retrofit.create(PersonAPI::class.java)

interface PersonAPI{
    @GET("api") //appended to the end of baseURL
    suspend fun getCategories():PersonResponse //Adds to the Category.kt list

}