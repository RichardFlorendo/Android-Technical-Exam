package com.example.android_technical_exam.model

import android.os.Parcel
import android.os.Parcelable
import android.os.Parcelable.Creator


class Login protected constructor(`in`: Parcel) : Parcelable {
    var username: String? = null
    var password: String? = null
    var salt: String? = null
    var md5: String? = null
    var sha1: String? = null
    var sha256: String? = null

    init {
        username = `in`.readString()
        password = `in`.readString()
        salt = `in`.readString()
        md5 = `in`.readString()
        sha1 = `in`.readString()
        sha256 = `in`.readString()
    }


    override fun writeToParcel(dest: Parcel, flags: Int) {
        dest.writeString(username)
        dest.writeString(password)
        dest.writeString(salt)
        dest.writeString(md5)
        dest.writeString(sha1)
        dest.writeString(sha256)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object {
        @JvmField
        val CREATOR: Creator<Login?> = object : Creator<Login?> {
            override fun createFromParcel(`in`: Parcel): Login {
                return Login(`in`)
            }

            override fun newArray(size: Int): Array<Login?> {
                return arrayOfNulls(size)
            }
        }
    }
}