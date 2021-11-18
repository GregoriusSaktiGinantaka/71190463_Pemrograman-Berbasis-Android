package com.example.pertemuan10_71190463

import android.database.sqlite.SQLiteDatabase
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class PendudukAdapter(var listPenduduk: ArrayList<String>, var db: SQLiteDatabase?): RecyclerView.Adapter<PendudukAdapter.PendudukHolder>() {
    class PendudukHolder(val v: View, val db: SQLiteDatabase?): RecyclerView.ViewHolder(v){
        fun bindView(data: String){
            val txtinfo = v.findViewById<TextView>(R.id.txtinfo)
            txtinfo.setText(data)

            val btnhapus = v.findViewById<Button>(R.id.btnhapus)
            btnhapus.setOnClickListener{
                val selection = "${DatabaseContact.Penduduk.COLUMN_NAME_NAMA} Like ?"
                val dataArray = data.split( " (")
                val selectionArgs = arrayOf(dataArray[0])
                db!!.delete(DatabaseContact.Penduduk.TABLE_NAME, selection, selectionArgs)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PendudukHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_penduduk, parent, false)
        return PendudukHolder(view, db)
    }

    override fun onBindViewHolder(holder: PendudukHolder, position: Int) {
        holder.bindView(listPenduduk.get(position))
    }

    override fun getItemCount(): Int = listPenduduk.size
}