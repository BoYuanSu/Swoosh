package com.takosu.swoosh.Controller

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.takosu.swoosh.Utilities.EXTRA_LEAGUE
import com.takosu.swoosh.R
import com.takosu.swoosh.Utilities.EXTRA_SKILL
import kotlinx.android.synthetic.main.activity_skill.*

class SkillActivity : BaseActivity() {

    var league = ""
    var skill = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_skill)
        league = intent.getStringExtra(EXTRA_LEAGUE)
        println(league)
    }

    fun onSkillFinishClicked(view: View) {
        if (this.skill != "") {
            val finishActivity = Intent(this, FinishActivity::class.java)
            finishActivity.putExtra(EXTRA_SKILL, this.skill)
            finishActivity.putExtra(EXTRA_LEAGUE, this.league)
            this.startActivity(finishActivity)
        } else{
            Toast.makeText(this,"Please select skill level", Toast.LENGTH_SHORT).show()
        }
    }

    fun onBeginnerClicked(view: View) {
        if (!togbtnBeginner.isChecked) {
            togbtnBeginner.isChecked = true
            return
        }
        togbtnBaller.isChecked = false
        this.skill = "Beginner"
    }

    fun onBallerClicked(view: View) {
        if (!togbtnBaller.isChecked) {
            togbtnBaller.isChecked = true
            return
        }
        togbtnBeginner.isChecked = false
        this.skill = "Baller"
    }
}
