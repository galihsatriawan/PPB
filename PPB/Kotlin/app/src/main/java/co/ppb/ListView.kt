package co.ppb

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import co.ppb.Adapter.MahasiswaAdapter
import co.ppb.Model.Mahasiswa
import kotlinx.android.synthetic.main.activity_list_view.*
import java.util.ArrayList

class ListView : AppCompatActivity() {
    private lateinit var listView : ListView
    var adapter : MahasiswaAdapter? = null
    var mhsList = ArrayList<Mahasiswa>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_view)
        mhsList!!.add(Mahasiswa(
                "Galih","1",R.drawable.abc_ic_go_search_api_material
        ))
        adapter = MahasiswaAdapter(this,mhsList!!,2)
        lvMahasiswa.adapter = adapter

        btnGrid.setOnClickListener(View.OnClickListener {
            val intent = Intent(this@ListView, GridView::class.java)
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK)
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
            startActivity(intent)
            finish()
        })
    }
}
