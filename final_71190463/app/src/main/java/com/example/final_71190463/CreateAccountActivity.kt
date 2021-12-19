package com.example.final_71190463

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.util.Patterns
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_create_account.*
import kotlinx.android.synthetic.main.activity_create_account.pass_txt
import kotlinx.android.synthetic.main.activity_create_account.user_txt
import kotlinx.android.synthetic.main.activity_login.*

class CreateAccountActivity : AppCompatActivity() {
    private lateinit var firebaseAuth: FirebaseAuth
    private var email = ""
    private var password = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_account)
        setupListener()
    }

    private fun setupListener() {
        reg_btn.setOnClickListener{
            validateData()
        }
    }

    private fun validateData() {
        email = user_txt.text.toString().trim()
        password = pass_txt.text.toString().trim()

        if(!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            user_txt.error = "Invalid Format"
        }
        else if (TextUtils.isEmpty(password)){
            pass_txt.error = "Please Enter Password"
        }
        else if (password.length < 6){
            pass_txt.error = "Password at least 6 Char"
        }
        else{
            firebaseSignUp()
        }
    }

    private fun firebaseSignUp() {
        firebaseAuth.createUserWithEmailAndPassword(email, password)
            .addOnSuccessListener {
                val firebaseUser = firebaseAuth.currentUser
                val email = firebaseUser!!.email
                Toast.makeText(this,"Account $email was Created", Toast.LENGTH_SHORT).show()
                startActivity(Intent(this, ResultActivity::class.java))
                finish()
            }
            .addOnFailureListener {

            }
    }
}