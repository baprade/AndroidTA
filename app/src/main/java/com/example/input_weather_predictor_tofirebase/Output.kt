package com.example.input_weather_predictor_tofirebase

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class Output : AppCompatActivity() {

    lateinit var o1 : TextView
    lateinit var o2 : TextView
    lateinit var init1 : TextView
    lateinit var init2 : TextView
    lateinit var init3 : TextView
    lateinit var init4 : TextView
    lateinit var btnProses : Button
    var database = FirebaseDatabase.getInstance()
    var myRef = database.getReference("Uji")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_output)
        o1 = findViewById<View>(R.id.O1) as TextView
        o2 = findViewById<View>(R.id.O2) as TextView
        init1 = findViewById<View>(R.id.init1) as TextView
        init2 = findViewById<View>(R.id.init2) as TextView
        init3 = findViewById<View>(R.id.init3) as TextView
        init4 = findViewById<View>(R.id.init4) as TextView
        btnProses = findViewById<View>(R.id.button3) as Button

        btnProses.setOnClickListener{

            val intent = Intent(this@Output, Predictor::class.java)
            startActivity(intent)
        }


        myRef.child("Mamdani").get().addOnSuccessListener {
            o1.setText(it.value.toString())
        }.addOnFailureListener{
            Log.e("firebase", "Error getting data", it)
        }
        myRef.child("Sugeno").get().addOnSuccessListener {
            o2.setText(it.value.toString())
        }.addOnFailureListener{
            Log.e("firebase", "Error getting data", it)
        }
        myRef.child("Air").get().addOnSuccessListener {
            init1.setText("Air             :"+it.value.toString())
        }.addOnFailureListener{
            Log.e("firebase", "Error getting data", it)
        }
        myRef.child("Cloud").get().addOnSuccessListener {
            init2.setText("Cloud        : "+it.value.toString())
        }.addOnFailureListener{
            Log.e("firebase", "Error getting data", it)
        }
        myRef.child("Vapor").get().addOnSuccessListener {
            init3.setText("Vapor        : " +it.value.toString())
        }.addOnFailureListener{
            Log.e("firebase", "Error getting data", it)
        }
        myRef.child("Wind").get().addOnSuccessListener {
            init4.setText("Wind          : " + it.value.toString())
        }.addOnFailureListener{
            Log.e("firebase", "Error getting data", it)
        }
    }
}