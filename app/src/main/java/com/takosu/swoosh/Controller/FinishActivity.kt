package com.takosu.swoosh.Controller

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.takosu.swoosh.Model.Player
import com.takosu.swoosh.R

import com.takosu.swoosh.Utilities.EXTRA_PLAYER

import kotlinx.android.synthetic.main.activity_finish.*

class FinishActivity : AppCompatActivity() {
//    lateinit var player: Player

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_finish)
//        val league = intent.getStringExtra(EXTRA_LEAGUE)
//        val skill = intent.getStringExtra(EXTRA_SKILL)
        val player = intent.getParcelableExtra<Player>(EXTRA_PLAYER)

        txtSearchLeague.text = "Looking for ${player.league} ${player.skill} league near you..."
    }
}
