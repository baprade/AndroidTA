package com.example.input_weather_predictor_tofirebase

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageButton
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var predictKlik = findViewById<ImageButton>(R.id.button1)
        predictKlik.setOnClickListener(View.OnClickListener {
            Toast.makeText(this, "Let's Prediction the weather today", Toast.LENGTH_SHORT).show()
            var intent = Intent(this, Predictor ::class.java)
            startActivity(intent)
        })
    }
}