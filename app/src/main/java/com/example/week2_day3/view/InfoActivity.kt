package com.example.week2_day3.view

import android.app.Activity
import android.content.Intent
import android.graphics.Bitmap
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import com.example.week2_day3.R
import kotlinx.android.synthetic.main.activity_info.*

class InfoActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_info)


        val userIn  = intent?.getParcelableExtra("user_key") as UserInfo

        userIn.let {user ->


            val user_string = "Your name is ${user.name}."
            username_textView.text = user_string

            val cell_string = "${user.name}'s number is ${user.cell}."
            usercell_textView.text = cell_string

            val email_string = "${user.name}'s email is ${user.email}"
            useremail_textView.text = email_string

        }

        addpic_button.setOnClickListener {
            var i= Intent(MediaStore.ACTION_IMAGE_CAPTURE)
            startActivityForResult(i, 123)

        }


    }


    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if(requestCode==123 && resultCode == Activity.RESULT_OK)
        {
            var bmp = data?.extras?.get("data") as Bitmap
            profilepic_imageView.setImageBitmap(bmp)
        }
    }
}
