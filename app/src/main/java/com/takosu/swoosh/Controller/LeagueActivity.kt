package com.takosu.swoosh.Controller

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import com.takosu.swoosh.Utilities.EXTRA_LEAGUE
import com.takosu.swoosh.R
import kotlinx.android.synthetic.main.activity_league.*

class LeagueActivity : BaseActivity() {

    var selectedLeague: String = ""

    private val TAG = javaClass.simpleName

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_league)
    }

    fun onMensClicked(view: View) {
        if (!togbtnMens.isChecked) {
            togbtnMens.isChecked = true
            return
        }
        selectedLeague = "Mens"
        togbtnWomens.isChecked = false
        togbtnCoed.isChecked = false
    }

    fun onWomensClicked(view: View) {
        if (!togbtnWomens.isChecked) {
            togbtnWomens.isChecked = true
            return
        }
        selectedLeague = "Womens"
        togbtnCoed.isChecked = false
        togbtnMens.isChecked = false

    }

    fun onCoedClicked(view: View) {
        if (!togbtnCoed.isChecked) {
            togbtnCoed.isChecked = true
            return
        }
        selectedLeague = "Co-ed"
        togbtnMens.isChecked = false
        togbtnWomens.isChecked = false

    }

    fun leagueNextClicked(view: View) {
        if (selectedLeague != "") {
            val skillActivity = Intent(this, SkillActivity::class.java)
            skillActivity.putExtra(EXTRA_LEAGUE, selectedLeague)
            startActivity(skillActivity)
        } else {
            Toast.makeText(this, "Please select a league", Toast.LENGTH_SHORT).show()
        }

    }
}
