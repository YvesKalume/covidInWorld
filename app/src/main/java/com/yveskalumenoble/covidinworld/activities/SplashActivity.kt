package com.yveskalumenoble.covidinworld.activities

import android.content.Intent
import android.content.pm.ActivityInfo
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.Window
import android.view.WindowManager
import com.yveskalumenoble.covidinworld.R

class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //hiding title bar of this activity
        window.requestFeature(Window.FEATURE_NO_TITLE)
        //making this activity full screen
        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN)
        setContentView(R.layout.activity_splash)
        this.requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT

        //4second splash time
        Handler().postDelayed({
            //start main activity
            startActivity(Intent(this@SplashActivity, MainActivity::class.java))
            //finish this activity
            finish()
        },3000)

    }
}
