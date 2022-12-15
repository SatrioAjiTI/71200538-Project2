package com.example.myapplication

import android.annotation.SuppressLint
import android.content.ContentValues.TAG
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.textfield.TextInputEditText
import com.google.firebase.firestore.FirebaseFirestore

import com.google.firebase.ktx.Firebase




class MainActivity : AppCompatActivity() {

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_isian)
        val firestore = FirebaseFirestore.getInstance()

        val judul = findViewById<EditText>(R.id.edtJudul)
        val tanggal = findViewById<EditText>(R.id.edtTanggal)
        val isi = findViewById<EditText>(R.id.edtngsi)
        val btnEdt = findViewById<Button>(R.id.btnEdt)
        val btnDel = findViewById<Button>(R.id.btnDel)

        btnEdt.setOnClickListener{
            val N = Note(judul.text.toString(), tanggal.text.toString() , isi.text.toString())
            firestore.collection( "Notes").document(judul.text.toString()).set(N).addOnSuccessListener {
                val i = Intent(this, Isian::class.java);
                startActivity(i)
            }

        }
        btnDel.setOnClickListener{
            val N = Note(judul.text.toString(), tanggal.text.toString() , isi.text.toString())
            firestore.collection("Notes").document(judul.text.toString()).delete()
            val i = Intent(this, Isian::class.java);
            startActivity(i)
        }
//        val listNote = ArrayList<Note>()
//        listNote.add(Note(judul.text.toString(),tanggal.text.toString(),isi.text.toString()))
//
//        val rvNote = findViewById<RecyclerView>(R.id.rvListData)
//        rvNote.layoutManager =LinearLayoutManager(this)
//        val adapter = IsianAdapter(listNote)
//        rvNote.adapter = adapter
    }
}