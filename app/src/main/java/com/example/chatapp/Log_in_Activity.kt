package com.example.chatapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth

class Log_in_Activity : AppCompatActivity() {

    private lateinit var etEmail:EditText
    private lateinit var etPassword:EditText
    private lateinit var btnLog:Button
    private lateinit var btnSign:Button


    private lateinit var mAuth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_log_in)
     mAuth= FirebaseAuth.getInstance()
        etEmail=findViewById(R.id.et_email)
        etPassword=findViewById(R.id.et_password)
        btnLog=findViewById(R.id.btn_log_in)
        btnSign=findViewById(R.id.btn_sign_in)


        btnSign.setOnClickListener {
val intent=Intent(this,SignUpActivity::class.java)
        startActivity(intent)

        }

     btnLog.setOnClickListener {
         val email = etEmail.text.toString()
         val password =etPassword.text.toString()


         login(email,password)
     }

    }
    private  fun login(email:String, password:String){
        mAuth.signInWithEmailAndPassword(email, password)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    val intent=Intent(this@Log_in_Activity,MainActivity::class.java)
                    startActivity(intent)

                } else {
                    Toast.makeText(this@Log_in_Activity, "User does not exist", Toast.LENGTH_LONG).show()

                }
            }

    }
}