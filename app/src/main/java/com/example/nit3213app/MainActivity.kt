package com.example.nit3213app.ui

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.nit3213app.R
import com.example.nit3213app.utils.PreferenceHelper

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Check if the user is logged in using shared preferences
        val isLoggedIn = PreferenceHelper.isLoggedIn(this)

        if (isLoggedIn) {
            // Navigate to DashboardActivity if the user is already logged in
            val intent = Intent(this, DashboardActivity::class.java)
            startActivity(intent)
        } else {
            // Navigate to LoginActivity if the user is not logged in
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }

        // Finish MainActivity to remove it from the back stack
        finish()
    }
}