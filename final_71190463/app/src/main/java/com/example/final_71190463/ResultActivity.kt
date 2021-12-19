package com.example.final_71190463

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import kotlinx.android.synthetic.main.activity_result.*

class ResultActivity : AppCompatActivity() {
    lateinit var mainAdapter: MainAdapter
    private lateinit var firebaseAuth: FirebaseAuth
    var db = Firebase.firestore

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)
        firebaseAuth = FirebaseAuth.getInstance()
        setupListener()
        setupRecycle()
    }

    private fun setupRecycle() {
        db.collection("databuku")
            .get()
            .addOnSuccessListener {
                val listBuku:ArrayList<Buku> = ArrayList()
                listBuku.clear()

                for (document in it){
                    listBuku.add(Buku(
                        document.data.get("judul") as String,
                        document.data.get("tahun") as String,
                        document.data.get("genre") as String
                    ))
                }

                val mainAdapter = MainAdapter(listBuku, object : MainAdapter.OnAdapterListener{
                    override fun OnEdit(buku: Buku) {
                        Toast.makeText(applicationContext,buku.judul, Toast.LENGTH_SHORT).show()
                        intentEdit ("", Constant.Type_Edit)
                    }

                    override fun OnDelete(buku: Buku) {
                        deleteAlert(buku)
                    }
                })

                list_buku.apply {
                    layoutManager = LinearLayoutManager(context)
                    adapter = mainAdapter
                }
            }
            .addOnFailureListener {
                Log.v("Hasil", "Gagal Ambil Data")
            }
    }

    private fun loadData(){
        return setupRecycle()
    }

    fun intentEdit(idBuku: String, intentType: Int){
        startActivity(
            Intent(applicationContext, CrudActivity::class.java)
                .putExtra("idBuku", idBuku)
                .putExtra("intentType", intentType)
        )
    }

    private fun deleteAlert(buku: Buku) {
        val dialog = AlertDialog.Builder(this)
        dialog.apply {
            setTitle("Konfirmasi Hapus")
            setMessage("Yakin hapus ${buku.judul}?")
            setNegativeButton("Batal") { dialogInterface, i ->
                dialogInterface.dismiss()
            }
            setPositiveButton("Hapus") { dialogInterface, i ->
                db.collection("databuku").document(buku.judul).delete()
                loadData()
            }
        }
        dialog.show()
    }


    fun setupListener() {
        add_btn.setOnClickListener{
            intentEdit("",Constant.Type_Add)
        }
        logOut_btn.setOnClickListener{
            firebaseAuth.signOut()
            startActivity(Intent(this, LoginActivity::class.java))
        }
    }
}

class Constant {
    companion object{
        const val  Type_Add = 1
        const val  Type_Edit = 2
    }
}