package com.example.firstreach100

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.RadioButton
import android.widget.RadioGroup

class HomeScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home_screen)
        val start=findViewById<Button>(R.id.button)
        start.setOnClickListener()
        {
            Intent(this,GameStart::class.java)
            val grp=findViewById<RadioGroup>(R.id.RadioGrp).checkedRadioButtonId
            if(grp==R.id.radioButton3)
            {
                startActivity( Intent(this,GameStart::class.java)
                    .putExtra("check-btn","typed computer"))

            }
            else
            {
                startActivity( Intent(this,GameStart::class.java)
                    .putExtra("check-btn","typed user"))
            }
        }
    }
}