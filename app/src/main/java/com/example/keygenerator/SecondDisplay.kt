package com.example.keygenerator

import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.content.Intent

class SecondDisplay : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second_display)
        val btnn_back = findViewById<Button>(R.id.bt_return)
        btnn_back.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)

        }



        }
    }
