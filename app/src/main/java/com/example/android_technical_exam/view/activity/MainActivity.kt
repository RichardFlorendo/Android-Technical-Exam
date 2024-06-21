package com.example.android_technical_exam.view.activity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.appcompat.widget.Toolbar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil
import com.example.android_technical_exam.R
import com.example.android_technical_exam.databinding.MainActivityBinding
import com.example.android_technical_exam.view.fragment.PeopleFragment


class MainActivity : AppCompatActivity(){

    lateinit var mMainActivityBinding: MainActivityBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mMainActivityBinding = DataBindingUtil.setContentView(this, R.layout.main_activity)
        setSupportActionBar(mMainActivityBinding.toolbar)
        mMainActivityBinding.toolbar.setTitle("People")

        getSupportFragmentManager().beginTransaction()
            .replace(R.id.fragment_content, PeopleFragment())
            .commit()
    }

}
