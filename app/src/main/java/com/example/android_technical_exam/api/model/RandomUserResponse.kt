package com.example.android_technical_exam.api.model

import android.icu.text.IDNA.Info
import com.example.android_technical_exam.model.Person


class RandomUserResponse {
    var results: List<Person>? = null
    var info: Info? = null

    fun getResults(): List<Person> {
        return results!!
    }

    fun setResults(results: List<Person>?) {
        this.results = results
    }

    fun getInfo(): Info {
        return info!!
    }

    fun setInfo(info: Info?) {
        this.info = info
    }
}