package com.example.android_technical_exam.api

import com.example.android_technical_exam.api.ServiceFactory.createRetrofitService
import com.example.android_technical_exam.api.model.RandomUserResponse
import io.reactivex.rxjava3.core.Observable
import retrofit2.http.GET
import retrofit2.http.Query

interface PersonAPI {
    @GET("api/")
    fun getRandomUsers(@Query("results") results: Int): Observable<RandomUserResponse>

    object Factory {
        val SERVICE_ENDPOINT: String = "https://randomuser.me/"

        fun create(): PersonAPI {
            return createRetrofitService(
                PersonAPI::class.java, SERVICE_ENDPOINT
            )
        }
    }
}