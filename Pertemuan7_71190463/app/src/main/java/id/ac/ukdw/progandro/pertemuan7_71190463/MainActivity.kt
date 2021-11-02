package id.ac.ukdw.progandro.pertemuan7_71190463

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val listKontak = arrayListOf<Kontak>()
        listKontak.add(Kontak(R.mipmap.test, "Gregorius Sakti Ginantaka", "08213124122"))
        listKontak.add(Kontak(R.mipmap.test2, "Sakti Ginantaka Gregorius", "01828736232"))

        val rcyKontak = findViewById<RecyclerView>(R.id.recyclekontak)
        rcyKontak.layoutManager = LinearLayoutManager (this)
        val adapter = KontakAdapter(listKontak, this)
        rcyKontak.adapter = adapter
    }
}