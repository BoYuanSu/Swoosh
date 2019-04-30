package com.takosu.swoosh

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnGetStarted.setOnClickListener {
            val leagueIntent = Intent(this, LeagueActivity::class.java)
            this.startActivity(leagueIntent)
        }
    }
}
