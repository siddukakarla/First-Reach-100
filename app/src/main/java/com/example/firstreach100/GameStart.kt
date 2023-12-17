package com.example.firstreach100

import android.icu.lang.UCharacter.GraphemeClusterBreak.T
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.example.firstreach100.databinding.ActivityGameStartBinding
import com.example.firstreach100.databinding.ActivityMainBinding
import com.google.android.material.dialog.MaterialAlertDialogBuilder

class GameStart : AppCompatActivity() {
    private lateinit var builder: AlertDialog.Builder
    lateinit var binding: ActivityGameStartBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityGameStartBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val text = intent.getStringExtra("check-btn")
        var flag = 1
        var sum = 0
        var count = 0
        if (text == "typed computer") {
            MaterialAlertDialogBuilder(this)
                .setTitle("Info")
                .setMessage("Computer Is Going To Start The Game!!!")
                .setNeutralButton(
                    "Ok"
                ) { _, _ ->  Toast.makeText(this,"Let's Start The Game",Toast.LENGTH_SHORT).show() }.show()

        } else {
            MaterialAlertDialogBuilder(this)
                .setMessage("User Is Going To Start The Game!!!")
                .setNeutralButton(
                    "Ok"
                ) { _, _ ->  Toast.makeText(this,"Let's Start The Game",Toast.LENGTH_SHORT).show() }.show()
            flag = 0;
        }

        val addbtn = binding.button3
        if (flag == 1) {
            sum = (1..9).random()
            binding.textView7.text = sum.toString()
        }
        addbtn.setOnClickListener()
        {
            var presum:Int=0
            var isvalid=1
            val value = binding.edittext
            if (value.getText().toString().trim().isEmpty())
            {
                isvalid=0
                MaterialAlertDialogBuilder(this)
                    .setTitle("Empty input !!!")
                .setMessage("Please Enter The Value")
                .setNeutralButton(
                    "Ok"
                ) { _, _ ->  }.show()
            }
            else if((Integer.parseInt(value.text.toString())==0))
            {
                isvalid=0
                MaterialAlertDialogBuilder(this)
                    .setTitle("Wrong input !!!")
                    .setMessage("Please Enter The Correct Value ")
                    .setNeutralButton(
                        "Ok"
                    ) { _, _ ->  }.show()
            }
            else if((Integer.parseInt(value.text.toString())>=10) && (flag==0))
            {
                isvalid=0
                MaterialAlertDialogBuilder(this)
                    .setTitle("Wrong input !!!")
                    .setMessage("Please Enter The Correct Value (i.e [1,9])")
                    .setNeutralButton(
                        "Ok"
                    ) { _, _ ->  }.show()
            }
            else if((Integer.parseInt(value.text.toString())>=8) && (flag==1))
            {
                isvalid=0
                MaterialAlertDialogBuilder(this)
                    .setTitle("Wrong input !!!")
                    .setMessage("Please Enter The Correct Value (i.e [1,7])")
                    .setNeutralButton(
                        "Ok"
                    ) { _, _ ->   }.show()
            }
            else {
                flag=1
                sum += Integer.parseInt(value.text.toString())
            }
            if (sum >= 100) {
                presum=sum
                MaterialAlertDialogBuilder(this)
                    .setTitle("Congratulations")
                    .setMessage("You Won The Game \uD83C\uDF89\uD83C\uDF89\uD83D\uDC4F")

                    .setPositiveButton("continue") {dialogueInterface,it->
                        finish()
                    }
                    .setNegativeButton("exit") {dialogueInterface,it->
                        finish()
                    }.show()
            }
            val p=(0..2).random()
            var keyval:Int=-1
            if(sum>=40 && p==0)
              keyval=getvalue(sum)
            else if(sum>=50 && p==1)
                keyval=getvalue(sum)
            else if(sum>=60 && p==2)
                keyval=getvalue(sum)
            else
                keyval=(1..7).random()
            if(isvalid==1) {
                if (keyval == -1)
                    sum += (1..7).random()
                else
                    sum += keyval
                if (sum >= 100 && presum < 100) {
                    MaterialAlertDialogBuilder(this)
                        .setTitle("OOPS!!!")
                        .setMessage("You Lost The Game " +
                                "Better Luck Next Time\uD83D\uDC4E\uD83D\uDE29")
                        .setPositiveButton("continue") {dialogueInterface,it->
                            finish()
                        }
                        .setNegativeButton("exit") {dialogueInterface,it->
                            finish()
                        }.show()
                }
            }
            binding.edittext.text.clear()
            if(isvalid==1)
            binding.textView7.text = sum.toString()
        }


    }
    private fun getvalue(x: Int): Int {
        if(x in 40..43)return 44-x;
        if(x in 45..51)return 52-x;
        if(x in 53..59)return 60-x;
        if(x in 61..67)return 68-x;
        if(x in 69..75)return 76-x;
        if(x in 77..83)return 84-x;
        if(x in 85..91)return 92-x;
        if(x in 93..99)return 100-x;
        return -1;
    }
}

