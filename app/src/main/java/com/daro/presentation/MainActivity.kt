package com.daro.presentation

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        basic_transition.setOnClickListener {
            navigationToActivity(BasicTransitionActivity::class.java)
        }

        view_pager_with_nav_drawer.setOnClickListener {
            navigationToActivity(ViewPagerNavDrawerActivity::class.java)
        }

        fragment_transitions.setOnClickListener {
            navigationToActivity(FragmentTransitionsActivity::class.java)
        }
    }


    private fun navigationToActivity(javaClass: Class<out AppCompatActivity>) {
        startActivity(Intent(this, javaClass))
    }
}