package com.saugatrai.runningtracker.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.saugatrai.runningtracker.R
import com.saugatrai.runningtracker.db.RunDAO
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var runDAO: RunDAO

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}