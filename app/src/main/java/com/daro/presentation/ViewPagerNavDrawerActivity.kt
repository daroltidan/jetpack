package com.daro.presentation

import android.graphics.Color
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.drawerlayout.widget.DrawerLayout
import com.daro.presentation.viewpager.PageTransformer
import com.daro.presentation.viewpager.ScreenSlidePagerAdapter
import kotlinx.android.synthetic.main.activity_view_pager_nav_drawer.*

class ViewPagerNavDrawerActivity : AppCompatActivity(),
    DrawerLayout.DrawerListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_pager_nav_drawer)

        drawer_layout.addDrawerListener(this)
        drawer_layout.setScrimColor(Color.TRANSPARENT)
        view_pager.adapter = ScreenSlidePagerAdapter(this)
        view_pager.setPageTransformer(PageTransformer())
    }

    override fun onDrawerStateChanged(newState: Int) {
        //no op
    }

    override fun onDrawerSlide(drawerView: View, slideOffset: Float) {
        motion_layout.progress = slideOffset
    }

    override fun onDrawerClosed(drawerView: View) {
        //no op
    }

    override fun onDrawerOpened(drawerView: View) {
        //no op
    }
}


