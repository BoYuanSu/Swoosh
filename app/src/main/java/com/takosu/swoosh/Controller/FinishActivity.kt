package com.takosu.swoosh.Controller

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.takosu.swoosh.R
import com.takosu.swoosh.Utilities.EXTRA_LEAGUE
import com.takosu.swoosh.Utilities.EXTRA_SKILL
import kotlinx.android.synthetic.main.activity_finish.*

class FinishActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_finish)
        val league = intent.getStringExtra(EXTRA_LEAGUE)
        val skill = intent.getStringExtra(EXTRA_SKILL)

        txtSearchLeague.text = "Looking for $league $skill league near you..."
    }
}
