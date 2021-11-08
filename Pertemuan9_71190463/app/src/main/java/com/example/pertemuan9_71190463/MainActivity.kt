package com.example.pertemuan9_71190463

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.*

class MainActivity : AppCompatActivity() {

    var sp : SharedPreferences? = null
    var spEdit : SharedPreferences.Editor? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        sp = getSharedPreferences("Database", MODE_PRIVATE)
        spEdit = sp?.edit()

        if (sp?.getBoolean("isLogin", false) == true) {
            //Sudah login
            setContentView(R.layout.activity_home)

            val spBahasa = findViewById<Spinner>(R.id.spinnerBahasa)
            val adapter = ArrayAdapter.createFromResource(this, R.array.bahasa_list, R.layout.support_simple_spinner_dropdown_item)
            spBahasa.adapter = adapter
            spBahasa.setSelection(sp!!.getInt("bahasa",1))
            spBahasa.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
                override fun onItemSelected( parent: AdapterView<*>, view: View, position: Int, id: Long) {
                    spEdit?.putInt("bahasa", position)
                    spEdit?.commit()
                }
                override fun onNothingSelected(parent: AdapterView<*>) {
                }
            }

            val etSize = findViewById<EditText>(R.id.size)
            etSize.setText(sp!!.getString("ukuran", "10"))
            etSize.addTextChangedListener(object : TextWatcher {
                override fun afterTextChanged(s: Editable?) {
                    spEdit?.putString("ukuran", s.toString())
                    spEdit?.commit()
                }

                override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
                }

                override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                }
            })

        }else{
            //Belum login
            setContentView(R.layout.activity_main)
            val etUser = findViewById<EditText>(R.id.User)
            val etPass = findViewById<EditText>(R.id.Pass)
            val btnlog = findViewById<Button>(R.id.lgn)
            btnlog.setOnClickListener {
                if(etUser.text.toString() == "user" && etPass.text.toString() == "123"){
                    spEdit?.putBoolean("isLogin", true)
                    spEdit?.commit()
                    val i = Intent(this, MainActivity::class.java)
                    startActivity(i)
                    finish()
                }
            }
        }
    }
}