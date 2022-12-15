package com.example.myapplication

import android.annotation.SuppressLint
import android.content.ContentValues
import android.content.ContentValues.TAG
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import com.google.firebase.firestore.FirebaseFirestore

class Isian : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val db = FirebaseFirestore.getInstance()
        db.collection("Notes").document("Judul")
            .get()

            val btn = findViewById<Button>(R.id.button)

            btn.setOnClickListener{
                val i = Intent(this, MainActivity::class.java);
                startActivity(i)
            }

        }
}