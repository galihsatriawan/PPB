package co.ppb

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.Toast
import co.ppb.Adapter.MahasiswaAdapter
import co.ppb.Model.Mahasiswa
import kotlinx.android.synthetic.main.activity_grid_view.*

class GridView : AppCompatActivity() {

    var adapter: MahasiswaAdapter? = null
    var mahasiswaList = ArrayList<Mahasiswa>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_grid_view)

        // load mahasiswa
        mahasiswaList.add(Mahasiswa("Galih","161111077", R.drawable.foto1))
        mahasiswaList.add(Mahasiswa("Desy","161111078", R.drawable.foto2))
        mahasiswaList.add(Mahasiswa("Nadya","161111079", R.drawable.foto2))
        mahasiswaList.add(Mahasiswa("Bibie","161111080", R.drawable.foto1))
        mahasiswaList.add(Mahasiswa("Luke","161111081", R.drawable.foto3))

        adapter = MahasiswaAdapter(this, mahasiswaList,1)

        gvMhs.adapter = adapter
        gvMhs.onItemClickListener = object : AdapterView.OnItemClickListener{
            override fun onItemClick(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                val selectedItem = mahasiswaList?.get(position)
                Toast.makeText(this@GridView,"Nama : "+selectedItem.nama+" NRP : "+selectedItem.nrp,Toast.LENGTH_SHORT).show()
            }

        }
        btnListView.setOnClickListener(View.OnClickListener {
            val intent = Intent(this@GridView,ListView::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP
            intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TASK
            startActivity(intent)
            finish()
        })
    }
}
