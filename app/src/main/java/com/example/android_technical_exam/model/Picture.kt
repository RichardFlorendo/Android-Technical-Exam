package com.example.android_technical_exam.model

import android.os.Parcel
import android.os.Parcelable
import android.os.Parcelable.Creator


class Picture protected constructor(`in`: Parcel) : Parcelable {
    var large: String? = null
    var medium: String? = null
    var thumbnail: String? = null

    init {
        large = `in`.readString()
        medium = `in`.readString()
        thumbnail = `in`.readString()
    }

    override fun writeToParcel(dest: Parcel, flags: Int) {
        dest.writeString(large)
        dest.writeString(medium)
        dest.writeString(thumbnail)
    }

    override fun describeContents(): Int {
        return 0
    }

    fun getLarge(): String {
        return large!!
    }

    fun setLarge(large: String?) {
        this.large = large
    }

    fun getMedium(): String {
        return medium!!
    }

    fun setMedium(medium: String?) {
        this.medium = medium
    }

    fun getThumbnail(): String {
        return thumbnail!!
    }

    fun setThumbnail(thumbnail: String?) {
        this.thumbnail = thumbnail
    }


    companion object {
        @JvmField
        val CREATOR: Creator<Picture?> = object : Creator<Picture?> {
            override fun createFromParcel(`in`: Parcel): Picture {
                return Picture(`in`)
            }

            override fun newArray(size: Int): Array<Picture?> {
                return arrayOfNulls(size)
            }
        }
    }
}