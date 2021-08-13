package com.example.input_weather_predictor_tofirebase

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.database.*


class Predictor : AppCompatActivity() {
    lateinit var btnProses : Button
    lateinit var btnProsesx : Button
    var database = FirebaseDatabase.getInstance()

    lateinit var txtNilaiGejala1 : EditText
    lateinit var txtNilaiGejala2 : EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_predictor)
        var myRef = database.getReference("Uji")
        btnProses = findViewById<View>(R.id.buttonx) as Button
        btnProsesx = findViewById<View>(R.id.button) as Button
        txtNilaiGejala1 = findViewById<View>(R.id.editTextNumberDecimal) as EditText
        txtNilaiGejala2 = findViewById<View>(R.id.editTextNumberDecimal2) as EditText
        btnProses.setOnClickListener{
            if (txtNilaiGejala1.text.toString().isEmpty() or txtNilaiGejala2.text.toString().isEmpty()){
                Toast.makeText(this@Predictor, "Please input all data", Toast.LENGTH_SHORT).show()
            }
            else {
                Toast.makeText(this, "Successs, please wait 10 seconds then tap 'Show Data' :)",Toast.LENGTH_SHORT).show()
                myRef.child("Air").setValue(txtNilaiGejala1.text.toString());
                myRef.child("Wind").setValue(txtNilaiGejala2.text.toString());
            }
        }
        btnProsesx.setOnClickListener{
                    val intent = Intent(this@Predictor, Output::class.java)
                    startActivity(intent)
        }
    }
}

