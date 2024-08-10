package com.aungpaing.test.activity

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import android.view.Window
import android.view.WindowManager
import androidx.core.content.ContextCompat
import com.aungpaing.test.R
import kotlinx.android.synthetic.main.activity_launch.btn_start

@SuppressLint("CustomSplashScreen")
class LaunchActivity: BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_launch)
        listener()
    }

    private fun listener() {
        btn_start.setOnClickListener {
            startActivity(MainActivity.newIntent(this))
            finish()
        }
    }
}