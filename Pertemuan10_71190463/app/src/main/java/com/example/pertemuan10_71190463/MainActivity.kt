package com.example.pertemuan10_71190463

import android.content.ContentValues
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.BaseColumns
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.LinearLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.pertemuan10_71190463.DatabaseContact.*

class MainActivity : AppCompatActivity() {
    var dbHelper: SQLiteOpenHelper? = null
    var db: SQLiteDatabase? = null
    var listPenduduk = ArrayList<String>()
    var adapter: PendudukAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        dbHelper = DatabaseHelper(this)
        db = dbHelper?.writableDatabase

        val txtnama = findViewById<EditText>(R.id.txtname)
        val txtpekerjaan = findViewById<EditText>(R.id.txtpekerjaan)
        val txtumur = findViewById<EditText>(R.id.txtumur)
        val btnsimpan = findViewById<Button>(R.id.btnsimpan)

        btnsimpan.setOnClickListener{
            val values = ContentValues().apply {
                put(Penduduk.COLUMN_NAME_NAMA, txtnama.text.toString())
                put(Penduduk.COLUMN_NAME_PEKERJAAN, txtpekerjaan.text.toString())
                put(Penduduk.COLUMN_NAME_UMUR, txtumur.text.toString())
            }
            db?.insert(DatabaseContact.Penduduk.TABLE_NAME,null,values)
            txtnama.setText("")
            txtpekerjaan.setText("")
            txtumur.setText("")
            reloadData()
        }

        val cyclePenduduk = findViewById<RecyclerView>(R.id.cyclePenduduk)
        cyclePenduduk.layoutManager = LinearLayoutManager(this)
        adapter = PendudukAdapter(listPenduduk, db)
        cyclePenduduk.adapter = adapter

        reloadData()
    }

    fun reloadData(){
        listPenduduk.clear()

        val columns = arrayOf(
            BaseColumns._ID,
            Penduduk.COLUMN_NAME_NAMA,
            Penduduk.COLUMN_NAME_PEKERJAAN,
            Penduduk.COLUMN_NAME_UMUR
        )

        val cursor = db?.query(
            DatabaseContact.Penduduk.TABLE_NAME,
            columns,
            null,
            null,
            null,
            null,
            null
        )

        with(cursor!!){
            while (moveToNext()){
                val name = getString(getColumnIndex(DatabaseContact.Penduduk.COLUMN_NAME_NAMA))
                val pekerjaan = getString(getColumnIndex(DatabaseContact.Penduduk.COLUMN_NAME_PEKERJAAN))
                val umur = getString(getColumnIndex(DatabaseContact.Penduduk.COLUMN_NAME_UMUR))
                listPenduduk.add("${name} , ${pekerjaan} , ${umur}")
            }
            adapter?.notifyDataSetChanged()
        }
    }
}