package com.takosu.swoosh

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_league.*

class LeagueActivity : BaseActivity() {

    var selectedLeague: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_league)
    }

    fun onMensClicked(view: View) {
        selectedLeague = "Mens"
        togbtnWomens.isChecked = false
        togbtnCoed.isChecked = false
    }

    fun onWomensClicked(view: View) {
        selectedLeague = "Womens"
        togbtnCoed.isChecked = false
        togbtnMens.isChecked = false

    }

    fun onCoedClicked(view: View) {
        selectedLeague = "Co-ed"
        togbtnMens.isChecked = false
        togbtnWomens.isChecked = false

    }

    fun leagueNextClicked(view: View) {
        if (selectedLeague != "") {
            val skillActivity = Intent(this, SkillActivity::class.java)
            skillActivity.putExtra(EXTRA_LEAGUE, selectedLeague)
            startActivity(skillActivity)
        } else{
            Toast.makeText(this, "Please select a league", Toast.LENGTH_SHORT).show()
        }

    }
}
