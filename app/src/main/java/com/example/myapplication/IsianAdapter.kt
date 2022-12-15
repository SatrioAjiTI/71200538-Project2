package com.example.myapplication

import android.content.ContentValues
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.firestore.FirebaseFirestore

class IsianAdapter(private val notes: ArrayList<Note>): RecyclerView.Adapter<IsianAdapter.ViewHolder>(){
    val db = FirebaseFirestore.getInstance()
    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val note = itemView.findViewById<TextView>(R.id.tvNotesJ)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): IsianAdapter.ViewHolder {
        val context = parent.context
        val inflater = LayoutInflater.from(context)
        // Inflate the custom layout
        val notesView = inflater.inflate(R.layout.list_notes, parent, false)
        // Return a new holder instance
        return ViewHolder(notesView)
    }

    override fun onBindViewHolder(viewHolder: IsianAdapter.ViewHolder, position: Int) {
        // Get the data model based on position
        val contact: Note = notes.get(position)
        // Set item views based on your views and data model
        val textView = viewHolder.note
        textView.setText(contact.Judul)

    }

    override fun getItemCount(): Int {
        return notes.size
    }
}