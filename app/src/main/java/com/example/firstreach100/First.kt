package com.example.firstreach100

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class First: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_first)
        val btn=findViewById<Button>(R.id.button4)
        btn.setOnClickListener()
        {
            val intentf=Intent(this,HomeScreen::class.java)
            startActivity(intentf)

        }
    }
}