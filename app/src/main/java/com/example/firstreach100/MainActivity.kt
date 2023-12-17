package com.example.firstreach100

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val btn=findViewById<Button>(R.id.button6)
        btn.setOnClickListener()
        {
            val intent=Intent(this,First::class.java)
            startActivity(intent)
        }
    }
}