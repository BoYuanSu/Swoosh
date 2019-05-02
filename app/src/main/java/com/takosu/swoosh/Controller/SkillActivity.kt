package com.takosu.swoosh.Controller

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.takosu.swoosh.Model.Player
import com.takosu.swoosh.R
import com.takosu.swoosh.Utilities.EXTRA_PLAYER
import kotlinx.android.synthetic.main.activity_skill.*

class SkillActivity : BaseActivity() {

//    var league = ""
//    var skill = ""

    lateinit var player: Player

    override fun onSaveInstanceState(outState: Bundle?) {
        super.onSaveInstanceState(outState)
        outState?.putParcelable(EXTRA_PLAYER, player)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle?) {
        super.onRestoreInstanceState(savedInstanceState)
        if (savedInstanceState != null) {
            player = savedInstanceState.getParcelable<Player>(EXTRA_PLAYER)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_skill)
//        league = intent.getStringExtra(EXTRA_LEAGUE)
        this.player = intent.getParcelableExtra(EXTRA_PLAYER)
        println(this.player.league)
    }

    fun onSkillFinishClicked(view: View) {
        if (this.player.skill != "") {
            val finishActivity = Intent(this, FinishActivity::class.java)
//            finishActivity.putExtra(EXTRA_SKILL, this.skill)
//            finishActivity.putExtra(EXTRA_LEAGUE, this.league)
            finishActivity.putExtra(EXTRA_PLAYER, this.player)
            this.startActivity(finishActivity)
        } else {
            Toast.makeText(this, "Please select skill level", Toast.LENGTH_SHORT).show()
        }
    }

    fun onBeginnerClicked(view: View) {
        if (!togbtnBeginner.isChecked) {
            togbtnBeginner.isChecked = true
            return
        }
        togbtnBaller.isChecked = false
        this.player.skill = "beginner"
    }

    fun onBallerClicked(view: View) {
        if (!togbtnBaller.isChecked) {
            togbtnBaller.isChecked = true
            return
        }
        togbtnBeginner.isChecked = false
        this.player.skill = "baller"
    }
}
