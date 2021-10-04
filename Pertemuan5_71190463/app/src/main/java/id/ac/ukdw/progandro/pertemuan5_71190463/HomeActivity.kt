package id.ac.ukdw.progandro.pertemuan5_71190463

import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class HomeActivity: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        val btnLogout = findViewById<Button>(R.id.btnLogout)

        val username = intent.getStringExtra("username")
        val password = intent.getStringExtra("password")

        val welcome = findViewById<TextView>(R.id.welcome)
        welcome.text = "Selamat datang  ${username}, Sandi Anda Adalah : ${password}"

        btnLogout.setOnClickListener {
            val i = Intent(this, MainActivity::class.java)
            startActivity(i)
        }
    }
}