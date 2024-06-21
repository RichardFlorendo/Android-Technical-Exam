package com.example.android_technical_exam.model

import android.os.Parcel
import android.os.Parcelable
import android.os.Parcelable.Creator


class ID protected constructor(`in`: Parcel) : Parcelable {
    var name: String? = null
    var value: String? = null

    init {
        name = `in`.readString()
        value = `in`.readString()
    }

    override fun writeToParcel(dest: Parcel, flags: Int) {
        dest.writeString(name)
        dest.writeString(value)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object {
        @JvmField
        val CREATOR: Creator<ID?> = object : Creator<ID?> {
            override fun createFromParcel(`in`: Parcel): ID {
                return ID(`in`)
            }

            override fun newArray(size: Int): Array<ID?> {
                return arrayOfNulls(size)
            }
        }
    }
}