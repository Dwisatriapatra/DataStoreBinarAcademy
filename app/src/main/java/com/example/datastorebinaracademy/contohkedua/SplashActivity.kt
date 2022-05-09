package com.example.datastorebinaracademy.contohkedua

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.asLiveData
import com.example.datastorebinaracademy.MainActivity
import com.example.datastorebinaracademy.R

class SplashActivity : AppCompatActivity() {
    private lateinit var userLoginManager: UserLoginManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        userLoginManager = UserLoginManager(this)
        Handler(Looper.getMainLooper()).postDelayed({
            userLoginManager.boolean.asLiveData().observe(this) {
                if(it == true){
                    startActivity(Intent(this, HomeActivity::class.java))
                    finish()
                }else{
                    startActivity(Intent(this, LoginActivity::class.java))
                    finish()
                }
            }
        }, 2000)
    }
}