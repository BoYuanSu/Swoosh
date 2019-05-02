package com.takosu.swoosh.Controller

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.takosu.swoosh.Model.Player
import com.takosu.swoosh.R
import com.takosu.swoosh.Utilities.EXTRA_PLAYER
import kotlinx.android.synthetic.main.activity_league.*

class LeagueActivity : BaseActivity() {

//    var selectedLeague: String = ""

    var player = Player("","")

//    private val TAG = javaClass.simpleName

    override fun onSaveInstanceState(outState: Bundle?) {
        super.onSaveInstanceState(outState)
        outState?.putParcelable(EXTRA_PLAYER, player)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle?) {
        super.onRestoreInstanceState(savedInstanceState)
        if (savedInstanceState != null){
            player = savedInstanceState.getParcelable(EXTRA_PLAYER)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_league)
    }

    fun onMensClicked(view: View) {
        if (!togbtnMens.isChecked) {
            togbtnMens.isChecked = true
            return
        }
        player.league = "mens"
        togbtnWomens.isChecked = false
        togbtnCoed.isChecked = false
    }

    fun onWomensClicked(view: View) {
        if (!togbtnWomens.isChecked) {
            togbtnWomens.isChecked = true
            return
        }
        player.league = "womens"
        togbtnCoed.isChecked = false
        togbtnMens.isChecked = false

    }

    fun onCoedClicked(view: View) {
        if (!togbtnCoed.isChecked) {
            togbtnCoed.isChecked = true
            return
        }
        player.league = "co-ed"
        togbtnMens.isChecked = false
        togbtnWomens.isChecked = false

    }

    fun leagueNextClicked(view: View) {
        if (player.league != "") {
            val skillActivity = Intent(this, SkillActivity::class.java)
            skillActivity.putExtra(EXTRA_PLAYER, player)
            startActivity(skillActivity)
        } else {
            Toast.makeText(this, "Please select a league", Toast.LENGTH_SHORT).show()
        }

    }
}
