package com.example.android_technical_exam.model

import android.os.Parcel
import android.os.Parcelable
import android.os.Parcelable.Creator


class Location protected constructor(`in`: Parcel) : Parcelable {
    var street: String? = null
    var city: String? = null
    var state: String? = null
    var postcode: String? = null

    init {
        street = `in`.readString()
        city = `in`.readString()
        state = `in`.readString()
        postcode = `in`.readString()
    }

    override fun writeToParcel(dest: Parcel, flags: Int) {
        dest.writeString(street)
        dest.writeString(city)
        dest.writeString(state)
        dest.writeString(postcode)
    }

    override fun describeContents(): Int {
        return 0
    }

    override fun toString(): String {
        return "$street, $city, $state Postcode: $postcode"
    }

    companion object {
        @JvmField
        val CREATOR: Creator<Location?> = object : Creator<Location?> {
            override fun createFromParcel(`in`: Parcel): Location {
                return Location(`in`)
            }

            override fun newArray(size: Int): Array<Location?> {
                return arrayOfNulls(size)
            }
        }
    }
}