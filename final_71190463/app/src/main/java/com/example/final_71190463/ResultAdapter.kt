package com.example.final_71190463

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.adapter_main.view.*

class MainAdapter (private val data: ArrayList<Buku>, var listener: OnAdapterListener) : RecyclerView.Adapter<MainHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainHolder {
        return MainHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.adapter_main, parent, false)
        )
    }

    override fun onBindViewHolder(holder: MainHolder, position: Int) {
        holder.bindBuku(data[position])
        val buku = data[position]
        holder.view.btn_edit.setOnClickListener{
            listener.OnEdit(buku)
        }
        holder.view.btn_delete.setOnClickListener{
            listener.OnDelete(buku)
        }
    }

    override fun getItemCount(): Int = data.size

    interface OnAdapterListener{
        fun OnEdit(buku: Buku)
        fun OnDelete(buku: Buku)
    }

}

class MainHolder (val view: View): RecyclerView.ViewHolder(view){

    private val judulBuku = view.title_book
    private val tahunBuku = view.year_book
    private val genreBuku = view.genre_book

    fun bindBuku(databuku: Buku){
        judulBuku.text = databuku.judul
        tahunBuku.text = databuku.tahun
        genreBuku.text = databuku.genre

    }
}