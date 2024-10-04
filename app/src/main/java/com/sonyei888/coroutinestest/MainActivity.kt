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
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import kotlin.coroutines.CoroutineContext

class MainActivity : AppCompatActivity(), CoroutineScope {

    private lateinit var binding: ActivityMainBinding

    override val coroutineContext: CoroutineContext
        get() = TODO("Not yet implemented")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
        setContentView(binding.root)

        binding.submit.setOnClickListener {
            GlobalScope.launch(Dispatchers.Main) {
                val success = withContext(Dispatchers.IO) {
                    validateLogin(
                        binding.userName.text.toString(),
                        binding.Password.text.toString()
                    )
                }
                toast(if (success) "Success" else "Failure")
            }
        }
    }

    private fun validateLogin(user: String, pass: String): Boolean {
        Thread.sleep(2000)
        return user.isNotEmpty() && pass.isNotEmpty()
    }


}

private fun Context.toast(message: String) {
    Toast.makeText(this, message, Toast.LENGTH_LONG).show()
}