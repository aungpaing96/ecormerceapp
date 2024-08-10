package com.aungpaing.test.activity

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.aungpaing.test.R
import com.aungpaing.test.fragment.HomeFragment
import kotlinx.android.synthetic.main.activity_main.frame

class MainActivity: BaseActivity() {

    companion object {
        fun newIntent(context: Context): Intent {
            return Intent(context, MainActivity::class.java)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        init()
        loadFragment(HomeFragment.newFragment())
    }

    private fun init() {

    }

    private fun loadFragment(newFragment: Fragment) {
        supportFragmentManager.beginTransaction().replace(R.id.frame, newFragment).commit()
    }
}