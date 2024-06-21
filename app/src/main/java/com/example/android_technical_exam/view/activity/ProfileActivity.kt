package com.example.android_technical_exam.view.activity

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.android_technical_exam.R
import com.example.android_technical_exam.api.model.RandomUserResponse
import com.example.android_technical_exam.databinding.ProfileActivityBinding
import com.example.android_technical_exam.model.Person
import com.example.android_technical_exam.viewmodel.UserViewModel
import java.util.concurrent.Flow


class ProfileActivity : AppCompatActivity() {
    lateinit var mProfileActivityBinding: ProfileActivityBinding
    var mUser: Person? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        mProfileActivityBinding = DataBindingUtil.setContentView(this, R.layout.profile_activity)
        if (mProfileActivityBinding.toolbar != null) {
            setSupportActionBar(mProfileActivityBinding.toolbar)
            getSupportActionBar()?.setDisplayHomeAsUpEnabled(true)
        }

        mUser = getIntent().getParcelableExtra(EXTRA_USER)
        mProfileActivityBinding.setUser(mUser?.let { UserViewModel(this, it) })
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val id = item.itemId
        when (id) {
            android.R.id.home-> {
                finish()
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }

    companion object {
        const val EXTRA_USER: String =
            "com.example.android_technical_exam.view.activity.ProfileActivity.EXTRA_USER"

        fun getStartIntent(context: Context, user: Person?): Intent {
            val intent = Intent(context, ProfileActivity::class.java)
            intent.putExtra(EXTRA_USER, user)
            return intent
        }
    }
}