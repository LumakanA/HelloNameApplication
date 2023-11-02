package com.example.hellonameapplication.presentation

import android.content.Context
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.hellonameapplication.R
import com.example.hellonameapplication.databinding.ActivityHelloBinding

class HelloActivity : AppCompatActivity() {
    private lateinit var binding: ActivityHelloBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHelloBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val name = getNameFromPreferences()
        displayHelloMessage(name)
    }

    private fun getNameFromPreferences(): String? {
        val preferences = getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE)
        return preferences.getString(PREF_NAME, "")
    }

    private fun displayHelloMessage(name: String?) {
        val helloMessage =
            getString(R.string.hello_name_default).replace(getString(R.string.name), name ?: "")
        binding.helloNameTextView.text = helloMessage
    }
}
