package id.ac.ukdw.progandro.pertemuan6_71190463

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment

class FragmentA: Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val it = inflater.inflate(R.layout.a_fragment, container, false)
        val btnNext = it.findViewById<Button>(R.id.btnA)
        btnNext.setOnClickListener {
            val a = Intent(context, HalamanDua::class.java)
            startActivity(a)
        }
        return it
    }
}