package com.example.android_technical_exam.viewmodel

import android.content.Context
import android.content.Intent
import android.os.Build
import android.widget.ImageView
import androidx.annotation.RequiresApi
import androidx.core.content.ContextCompat.startActivity
import androidx.databinding.BaseObservable
import androidx.databinding.BindingAdapter
import com.example.android_technical_exam.R
import com.example.android_technical_exam.model.Person
import com.example.android_technical_exam.view.activity.ProfileActivity
import com.squareup.picasso.Picasso


class UserViewModel(private val mContext: Context, user: Person) : BaseObservable() {
    private val mUser: Person = user

    val fullName: String
        get() = mUser.getName().toString()

    val pictureURL: String
        get() = mUser.getPicture().getLarge()

    val location: String
        get() = mUser.getLocation().toString()

    @RequiresApi(Build.VERSION_CODES.R)
    fun showUserProfile() {
        val intent = Intent(mContext, ProfileActivity::class.java)
        startActivity(mContext, intent, null)
    }

    companion object {
        @BindingAdapter("imageUrl")
        fun loadImage(view: ImageView, imageUrl: String?) {
            Picasso.with(view.context)
                .load(imageUrl)
                .placeholder(R.drawable.user_photo)
                .into(view)
        }
    }
}