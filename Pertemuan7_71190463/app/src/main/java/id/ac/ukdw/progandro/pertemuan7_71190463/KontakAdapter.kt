package id.ac.ukdw.progandro.pertemuan7_71190463

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView

class KontakAdapter (val listKontak: ArrayList<Kontak>, var context: Context): RecyclerView.Adapter<KontakAdapter.KontakHolder>() {
    class KontakHolder(val view: View): RecyclerView.ViewHolder(view){
        fun bind(kontak: Kontak, context: Context){
            view.findViewById<ImageView>(R.id.imgkontak).setImageResource(kontak.img)
            view.findViewById<TextView>(R.id.txtname).setText(kontak.name)
            view.findViewById<TextView>(R.id.txtnomer).setText(kontak.nomor)
            view.setOnClickListener{
                Toast.makeText(context, "${kontak.name}: ${kontak.nomor}",Toast.LENGTH_SHORT).show()
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): KontakHolder {
        TODO("Not yet implemented")
        val v = LayoutInflater.from(parent.context).inflate(R.layout.item_kontak, parent, false)
        return KontakHolder(v)
    }

    override fun onBindViewHolder(holder: KontakHolder, position: Int) {
        TODO("Not yet implemented")
        holder.bind(listKontak[position], context)
    }

    override fun getItemCount(): Int {
        TODO("Not yet implemented")
        return listKontak.size
    }
}