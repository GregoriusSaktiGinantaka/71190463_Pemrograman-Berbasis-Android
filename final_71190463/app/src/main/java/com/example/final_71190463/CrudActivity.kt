package com.example.final_71190463

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import kotlinx.android.synthetic.main.activity_crud.*

class CrudActivity : AppCompatActivity() {
    var db = Firebase.firestore
    private var idBuku: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_crud)
        db = Firebase.firestore

        setupView()

        //Attribute Buku
        val judulBuku = findViewById<EditText>(R.id.jdl_book)
        val tahunTerbit = findViewById<EditText>(R.id.th_book)
        val genreBuku = findViewById<EditText>(R.id.gen_book)

        //Button
        val submitBtn = findViewById<Button>(R.id.sub_btn)
        val updateBtn = findViewById<Button>(R.id.upd_btn)

        //Set button
        submitBtn.setOnClickListener{
            val databuku = Buku( judulBuku.text.toString(), tahunTerbit.text.toString(), genreBuku.text.toString())
            judulBuku.setText("")
            tahunTerbit.setText("")
            genreBuku.setText("")
            db.collection("databuku").document(databuku.judul).set(databuku)
            startActivity(Intent(this, ResultActivity::class.java))
        }

        //Update Button
        updateBtn.setOnClickListener{
//            val databuku = Buku( judulBuku.text.toString(), tahunTerbit.text.toString(), genreBuku.text.toString())
//            db.collection("databuku").document(databuku.judul).get()
//                .addOnSuccessListener {
//                    val listBuku:ArrayList<Buku> = ArrayList()
//                    listBuku.clear()
//
//                    for (document in it){
//                        listBuku.add(Buku(
//                            judulBuku.setText(databuku.judul),
//                            tahunTerbit.setText(databuku.tahun),
//                            genreBuku.setText(databuku.genre)
//                        ))
//                    }
//                }
//            startActivity(Intent(this, MainActivity::class.java))
        }
    }

    fun setupView() {
        val intentType = intent.getIntExtra("intentType", 0)
        when (intentType){
            Constant.Type_Add -> {
                supportActionBar!!.title = "Add Data Buku"
                upd_btn.visibility = View.GONE
            }
            Constant.Type_Edit -> {
                supportActionBar!!.title = "Update Data Buku"
                sub_btn.visibility = View.GONE
            }
        }
    }
//    fun getBuku() {
//        idBuku = intent.getStringExtra("",Constant.Type_Edit)
//        db.collection("databuku").document(idBuku).get()
//    }
}