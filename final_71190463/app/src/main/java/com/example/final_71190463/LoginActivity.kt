package com.example.final_71190463

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.util.Patterns
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {
    private lateinit var firebaseAuth: FirebaseAuth
    private var email = ""
    private var password = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        setupListener()

        firebaseAuth = FirebaseAuth.getInstance()
        checkUser()
    }

    private fun checkUser() {
        val firebaseUser = firebaseAuth.currentUser
        if (firebaseUser != null){
            startActivity(Intent(this, ResultActivity::class.java))
            finish()
        }
    }

    private fun setupListener() {
        signUp_btn.setOnClickListener{
            startActivity(Intent(this, CreateAccountActivity::class.java))
        }
        login_btn.setOnClickListener{
            validateData()
        }
    }

    private fun validateData() {
        //get data
        email = user_txt.text.toString().trim()
        password = pass_txt.text.toString().trim()

        //validation
        if(!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            user_txt.error = "Invalid Format"
        }
        else if (TextUtils.isEmpty(password)){
            pass_txt.error = "Please Enter Password"
        }
        else{
            firebaseLogin()
        }
    }

    private fun firebaseLogin() {
        firebaseAuth.signInWithEmailAndPassword(email, password)
            .addOnSuccessListener {
                val firebaseUser = firebaseAuth.currentUser
                val email = firebaseUser!!.email
                Toast.makeText(this,"Logged as $email", Toast.LENGTH_SHORT).show()
                startActivity(Intent(this, ResultActivity::class.java))
                finish()
            }
            .addOnFailureListener {

            }
    }
}