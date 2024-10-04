package com.sonyei888.coroutinestest

import android.content.Context
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.sonyei888.coroutinestest.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
        setContentView(binding.root)

        binding.submit.setOnClickListener {
            val success = validateLogin(binding.userName.text.toString(), binding.Password.text.toString())
            toast(if (success) "Success" else "Failure")
        }
    }

    private fun validateLogin(user: String, pass: String): Boolean {
        return user.isNotEmpty() && pass.isNotEmpty()
    }
}

private fun Context.toast(message: String) {
    Toast.makeText(this, message, Toast.LENGTH_LONG).show()
}