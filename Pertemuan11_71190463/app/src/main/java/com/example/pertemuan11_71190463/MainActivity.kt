package com.example.pertemuan11_71190463

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.TextView
import com.google.firebase.firestore.FirebaseFirestore

class MainActivity : AppCompatActivity() {
    var firestore: FirebaseFirestore? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        firestore = FirebaseFirestore.getInstance()

        val namaMahasiswa = findViewById<EditText>(R.id.nama_maha)
        val nimMahasiswa = findViewById<EditText>(R.id.nim_maha)
        val ipkMahasiswa = findViewById<EditText>(R.id.ipk_maha)
        val submit = findViewById<Button>(R.id.sub_btn)
        val cariMahasiswa = findViewById<EditText>(R.id.scr_maha)
        val search = findViewById<Button>(R.id.scr_btn)
        val result = findViewById<TextView>(R.id.res_txt)
        val assen = findViewById<RadioButton>(R.id.asc_ding)
        val desen = findViewById<RadioButton>(R.id.dsc_ding)

        submit.setOnClickListener{
            val mahasiswa = Mahasiswa(namaMahasiswa.toString(), nimMahasiswa.text.toString().toInt(), ipkMahasiswa.text.toString().toInt())
            namaMahasiswa.setText("")
            nimMahasiswa.setText("")
            ipkMahasiswa.setText("")
            firestore?.collection("mahasiswa")?.document(mahasiswa.nama)?.set(mahasiswa)
        }

        search.setOnClickListener{
            firestore?.collection("mahasiswa")?.document(result.text.toString())?.get()!!
                .addOnSuccessListener {doc ->
                    result.setText(doc.data.toString())
                }
        }
    }
}