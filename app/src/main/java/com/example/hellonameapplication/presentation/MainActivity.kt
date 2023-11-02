package com.example.hellonameapplication.presentation

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.hellonameapplication.databinding.ActivityMainBinding

const val PREF_NAME = "PREF_NAME"

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.saveButton.setOnClickListener {
            val name = binding.enterNameEditText.text.toString()
            if (name.isNotBlank()) {
                saveNameToPreferences(name)

                val intent = Intent(this, HelloActivity::class.java)
                startActivity(intent)
            } else {
                Toast.makeText(this, "Please enter a name", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun saveNameToPreferences(name: String) {
        val preferences = getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE)
        preferences.edit().putString(PREF_NAME, name).apply()
    }
}
