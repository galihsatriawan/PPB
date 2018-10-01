package co.ppb

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.Toast
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

        mhsList!!.add(Mahasiswa("Galih","161111077", R.drawable.foto1))
        mhsList!!.add(Mahasiswa("Desy","161111078", R.drawable.foto2))
        mhsList!!.add(Mahasiswa("Nadya","161111079", R.drawable.foto2))
        mhsList!!.add(Mahasiswa("Bibie","161111080", R.drawable.foto1))
        mhsList!!.add(Mahasiswa("Luke","161111081", R.drawable.foto3))

        adapter = MahasiswaAdapter(this,mhsList!!,2)
        lvMahasiswa.adapter = adapter
        lvMahasiswa.onItemClickListener = object:AdapterView.OnItemClickListener{
            override fun onItemClick(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                var selected = mhsList?.get(position)
                Toast.makeText(this@ListView,"NRP : "+selected.nrp+" Nama : "+selected.nama,Toast.LENGTH_SHORT).show()
            }

        }
        btnGrid.setOnClickListener(View.OnClickListener {
            val intent = Intent(this@ListView, GridView::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TASK
            intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP
            startActivity(intent)
            finish()
        })
    }
}
