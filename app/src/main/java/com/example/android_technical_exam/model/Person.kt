package com.example.android_technical_exam.model

import android.os.Parcel
import android.os.Parcelable
import java.util.Date


class Person protected constructor(`in`: Parcel) : Parcelable {
    var gender: String? = null
    var name: Name? = null
    var location: Location? = null
    var email: String? = null
    var login: Login? = null
    var dob: Date? = null
    var registered: Date? = null
    var phone: String? = null
    var cell: String? = null
    var id: ID? = null
    var picture: Picture? = null
    var nat: String? = null


    init {
        gender = `in`.readString()
        name = `in`.readParcelable(Name::class.java.classLoader)
        location = `in`.readParcelable(Location::class.java.classLoader)
        email = `in`.readString()
        login = `in`.readParcelable(Login::class.java.classLoader)
        phone = `in`.readString()
        cell = `in`.readString()
        id = `in`.readParcelable(ID::class.java.classLoader)
        picture = `in`.readParcelable(Picture::class.java.classLoader)
        nat = `in`.readString()
    }


    override fun writeToParcel(dest: Parcel, flags: Int) {
        dest.writeString(gender)
        dest.writeParcelable(name, flags)
        dest.writeParcelable(location, flags)
        dest.writeString(email)
        dest.writeParcelable(login, flags)
        dest.writeString(phone)
        dest.writeString(cell)
        dest.writeParcelable(id, flags)
        dest.writeParcelable(picture, flags)
        dest.writeString(nat)
    }

    override fun describeContents(): Int {
        return 0
    }


    fun getName(): Name {
        return name!!
    }

    fun setName(name: Name?) {
        this.name = name
    }

    fun getLocation(): Location {
        return location!!
    }

    fun setLocation(location: Location?) {
        this.location = location
    }

    fun getPicture(): Picture {
        return picture!!
    }

    fun setPicture(picture: Picture?) {
        this.picture = picture
    }


    companion object {
        @JvmField
        val CREATOR: Parcelable.Creator<Person?> = object : Parcelable.Creator<Person?> {
            override fun createFromParcel(`in`: Parcel): Person {
                return Person(`in`)
            }

            override fun newArray(size: Int): Array<Person?> {
                return arrayOfNulls(size)
            }
        }
    }
}