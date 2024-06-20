package com.example.android_technical_exam.view.activity

import android.os.Bundle
import android.view.View
import androidx.activity.ComponentActivity
import androidx.activity.enableEdgeToEdge
import com.example.android_technical_exam.R


class MainActivity : ComponentActivity(), View.OnClickListener{

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_screen_layout)

        enableEdgeToEdge()
    }

    override fun onClick(v: View?) {

    }

}
