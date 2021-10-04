package id.ac.ukdw.progandro.pertemuan5_71190463

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val username = findViewById<EditText>(R.id.username)
        val password = findViewById<EditText>(R.id.password)
        val btnLogin = findViewById<Button>(R.id.btnLogin)

        btnLogin.setOnClickListener {
            val i = Intent(this, HomeActivity::class.java)
            i.putExtra("username", username.text.toString())
            i.putExtra("password", password.text.toString())
            startActivity(i)
        }
    }
}