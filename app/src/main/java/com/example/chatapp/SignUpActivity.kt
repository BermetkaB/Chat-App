package com.example.chatapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference

class SignUpActivity : AppCompatActivity() {

    private lateinit var etName:EditText

    private lateinit var etEmail: EditText
    private lateinit var etPassword: EditText
    private lateinit var btnSign: Button
    private lateinit var mAuth2: FirebaseAuth
    private lateinit var dbInfo: DatabaseReference



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)
        etName = findViewById(R.id.et_name2)
        etEmail = findViewById(R.id.et_email2)
        etPassword = findViewById(R.id.et_password2)
        btnSign = findViewById(R.id.btn_sign_in2)

        btnSign.setOnClickListener {
            val name=etName.text.toString()
            val email = etEmail.text.toString()
            val password = etPassword.text.toString()


            signUp(email, password,name)
        }


    }
    private fun  signUp(name:String, email: String, password: String){
        mAuth2.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {

                    addUserToDatabase(name,email,mAuth2.currentUser?.uid!!)
                    val intent=Intent(this@SignUpActivity,MainActivity::class.java)
                    startActivity(intent)


                } else {
                    Toast.makeText(this@SignUpActivity,"some error occurred", Toast.LENGTH_SHORT).show()


                }
            }


    }

    private fun addUserToDatabase(name: String, email: String, uid:String){

    }

    }

