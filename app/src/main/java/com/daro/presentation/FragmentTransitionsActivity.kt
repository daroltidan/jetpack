package com.daro.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.motion.widget.MotionLayout
import androidx.fragment.app.Fragment
import com.daro.presentation.fragments.CollapsedFragment
import com.daro.presentation.fragments.ExpandedFragment
import kotlinx.android.synthetic.main.activity_fragment_transitions.*
import kotlin.math.abs

class FragmentTransitionsActivity : AppCompatActivity(), MotionLayout.TransitionListener {

    private var lastProgress = 0f
    private var fragment: Fragment? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fragment_transitions)
        if (savedInstanceState == null) {
            showCollapsed()
        }
        motion_layout.addTransitionListener(this)
    }

    override fun onTransitionTrigger(p0: MotionLayout?, p1: Int, p2: Boolean, p3: Float) {
        //no op
    }

    override fun onTransitionStarted(p0: MotionLayout?, p1: Int, p2: Int) {
        //no op

    }

    override fun onTransitionChange(p0: MotionLayout?, p1: Int, p2: Int, p3: Float) {
        if (p3 - lastProgress > 0) {
            // from start to end
            val atEnd = abs(p3 - 1f) < 0.1f
            if (atEnd && fragment is CollapsedFragment) {
                showExpanded()
            }
        } else {
            // from end to start
            val atStart = p3 < 0.9f
            if (atStart && fragment is ExpandedFragment) {
                showCollapsed()
            }
        }
        lastProgress = p3
    }

    private fun showExpanded() {
        fragment = ExpandedFragment().also {
            val transaction = supportFragmentManager.beginTransaction()
            transaction.setCustomAnimations(android.R.anim.fade_in, 0)
            transaction.replace(R.id.bottom_container, it).commitNow()
        }
    }

    private fun showCollapsed() {
        fragment = CollapsedFragment().also {
            val transaction = supportFragmentManager.beginTransaction()
            transaction.setCustomAnimations(android.R.anim.fade_in, 0)
            transaction.replace(R.id.bottom_container, it).commitNow()
        }
    }

    override fun onTransitionCompleted(p0: MotionLayout?, p1: Int) {
        //no op
    }
}