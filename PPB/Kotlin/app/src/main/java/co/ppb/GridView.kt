package co.ppb

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
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
        mahasiswaList.add(Mahasiswa("Coffee","1", R.drawable.abc_ic_go_search_api_material))
        mahasiswaList.add(Mahasiswa("Coffee","2", R.drawable.abc_ic_go_search_api_material))
        mahasiswaList.add(Mahasiswa("Coffee","3", R.drawable.abc_ic_go_search_api_material))
        mahasiswaList.add(Mahasiswa("Coffee","4", R.drawable.abc_ic_go_search_api_material))

        adapter = MahasiswaAdapter(this, mahasiswaList,1)

        gvMhs.adapter = adapter
        btnListView.setOnClickListener(View.OnClickListener {
            val intent = Intent(this@GridView,ListView::class.java)
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK)
            startActivity(intent)
            finish()
        })
    }
}
