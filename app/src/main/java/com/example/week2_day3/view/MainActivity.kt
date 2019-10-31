package com.example.week2_day3.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.week2_day3.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        register_button.setOnClickListener {



            val name = name_editText.text.toString()
            val cell = phone_editText.text.toString()
            val email = email_editText.text.toString()

            val myInfo = UserInfo(name, cell, email)

            val userIntent = Intent(this, InfoActivity::class.java)
            userIntent.putExtra("user_key", myInfo)
            startActivity(userIntent)
        }
    }
}
