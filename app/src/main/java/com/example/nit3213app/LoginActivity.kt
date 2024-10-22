package com.example.nit3213app.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.viewModels
import com.example.nit3213app.R
import com.example.nit3213app.viewmodel.LoginViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LoginActivity : AppCompatActivity() {
    private val viewModel: LoginViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val username = findViewById<EditText>(R.id.username)
        val password = findViewById<EditText>(R.id.password)
        val loginButton = findViewById<Button>(R.id.loginButton)

        loginButton.setOnClickListener {
            val user = username.text.toString()
            val pass = password.text.toString()
            if (user.isNotEmpty() && pass.isNotEmpty()) {
                viewModel.login(user, pass)
            } else {
                Toast.makeText(this, "Please enter your username and password", Toast.LENGTH_SHORT).show()
            }
        }

        viewModel.loginResponse.observe(this) { response ->
            if (response != null) {
                val intent = Intent(this, DashboardActivity::class.java)
                intent.putExtra("keypass", keypass)
                startActivity(intent)

            } else {
                Toast.makeText(this, "Login failed. Check your credentials.", Toast.LENGTH_SHORT).show()
            }
        }
    }
}