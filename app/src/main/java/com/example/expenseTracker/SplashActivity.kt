package com.example.expenseTracker

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.animation.AnimationUtils
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.example.expenseTracker.auth.AuthManager
import com.example.expenseTracker.onboarding.OnboardingActivity

class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        supportActionBar?.hide()

        val splashLogo = findViewById<ImageView>(R.id.splashLogo)
        val appName = findViewById<TextView>(R.id.appName)
        val progressBar = findViewById<ProgressBar>(R.id.progressBar)

        Glide.with(this)
            .asGif()
            .load(R.drawable.expo)
            .into(splashLogo)

        val topAnim = AnimationUtils.loadAnimation(this, R.anim.top_animation)
        val bottomAnim = AnimationUtils.loadAnimation(this, R.anim.bottom_animation)
        val fadeIn = AnimationUtils.loadAnimation(this, R.anim.fade_in)

        splashLogo.startAnimation(topAnim)
        appName.startAnimation(bottomAnim)
        progressBar.startAnimation(fadeIn)

        Handler(Looper.getMainLooper()).postDelayed({
            val nextActivity = if (AuthManager.isLoggedIn(this)) {
                MainActivity::class.java
            } else {
                OnboardingActivity::class.java
            }
            startActivity(Intent(this, nextActivity))
            finish()
        }, 3000)
    }
}
