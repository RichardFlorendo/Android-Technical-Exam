package com.example.android_technical_exam.model

import android.os.Parcel
import android.os.Parcelable
import android.os.Parcelable.Creator
import java.util.Locale


class Name protected constructor(`in`: Parcel) : Parcelable {
    var title: String? = null
    var first: String? = null
    var last: String? = null


    init {
        title = `in`.readString()
        first = `in`.readString()
        last = `in`.readString()
    }


    override fun toString(): String {
        return title!![0].toString()
            .uppercase(Locale.getDefault()) + title!!.substring(1) + " " + first + " " + last
    }

    override fun writeToParcel(dest: Parcel, flags: Int) {
        dest.writeString(title)
        dest.writeString(first)
        dest.writeString(last)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object {
        @JvmField
        val CREATOR: Creator<Name?> = object : Creator<Name?> {
            override fun createFromParcel(`in`: Parcel): Name {
                return Name(`in`)
            }

            override fun newArray(size: Int): Array<Name?> {
                return arrayOfNulls(size)
            }
        }
    }
}