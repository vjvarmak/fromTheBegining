package com.App.Activity

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.App.Booking.FragmentBooking
import com.App.FragmentNotification
import com.App.FragmentResort
import com.App.FragmentSettings
import com.App.Home.TabLayout.Home.FragmentHome
import com.App.test.R
import com.App.test.databinding.MainActivityBinding

class MainActivity : AppCompatActivity() {
    private var mainActivityBinding: MainActivityBinding? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainActivityBinding = MainActivityBinding.inflate(layoutInflater)
        val view: View = mainActivityBinding!!.root
        setContentView(view)
        supportFragmentManager.beginTransaction().replace(R.id.container, FragmentBooking()).commitAllowingStateLoss()
        setTitle("Booking")

//        tabLayoutBinding.topPanel.setText("Dashboard");
        mainActivityBinding!!.bottomNavigation.setOnNavigationItemSelectedListener { item ->
            var selectedFragment: Fragment? = null
            when (item.itemId) {
                R.id.home -> {
                    selectedFragment = FragmentHome.newInstance()
                    setTitle("Dashboard")
                }
                R.id.resorts -> {
                    selectedFragment = FragmentResort.newInstance()
                    setTitle("Resorts")
                }
                R.id.booking -> {
                    selectedFragment = FragmentBooking.newInstance()
                    setTitle("Booking")
                }
                R.id.notification -> {
                    selectedFragment = FragmentNotification.newInstance()
                    setTitle("Notification")
                }
                R.id.settings -> {
                    selectedFragment = FragmentSettings.newInstance()
                    setTitle("Settings")
                }
            }
            supportFragmentManager.beginTransaction().replace(R.id.container, selectedFragment!!).commitAllowingStateLoss()
            true
        }
    }

    private fun setTitle(title: String) {
        supportActionBar!!.title = title
    }
}