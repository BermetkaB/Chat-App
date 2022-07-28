package com.example.chatapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText

class Log_in_Activity : AppCompatActivity() {

    private lateinit var etEmail:EditText
    private lateinit var etPassword:EditText
    private lateinit var btnLog:EditText
    private lateinit var btnSign:EditText
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_log_in)

        etEmail=findViewById(R.id.et_email)
        etPassword=findViewById(R.id.et_password)
        btnLog=findViewById(R.id.btn_log_in)
        btnSign=findViewById(R.id.btn_sign_in)


        btnSign.setOnClickListener {
val intent=Intent(this,SignUpActivity::class.java)
        startActivity(intent)

        }



    }
}