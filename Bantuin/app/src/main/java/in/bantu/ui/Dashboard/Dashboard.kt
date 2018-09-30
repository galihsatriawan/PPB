package `in`.bantu.Dashboard

import `in`.bantu.Adapter.LayananAdapter
import `in`.bantu.Model.Layanan
import `in`.bantu.R
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_dashboard.*

class Dashboard : AppCompatActivity() {

    var adapter: ArrayList<LayananAdapter?> = ArrayList<LayananAdapter?>()
    var layanansLists:ArrayList<ArrayList<Layanan>> = ArrayList<ArrayList<Layanan>>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)

        // load layanans
        //1
        var layanansList1 = ArrayList<Layanan>()
        var adapter1 : LayananAdapter? = null;
        layanansList1.add(Layanan("Umum", R.drawable.ic_profile))
        layanansList1.add(Layanan("Komputer", R.drawable.ic_profile))
        layanansList1.add(Layanan("Laptop", R.drawable.ic_profile))
        layanansList1.add(Layanan("HP", R.drawable.ic_profile))
        layanansList1.add(Layanan("Mesin Cuci",R.drawable.ic_profile))
        layanansList1.add(Layanan("TV", R.drawable.ic_profile))
        layanansList1.add(Layanan("Kulkas", R.drawable.ic_profile))

        layanansLists.add(layanansList1)
        adapter1 = LayananAdapter(this, layanansLists[0])
        adapter.add(adapter1)
        gv1.visibility = View.VISIBLE
        judulGv1.text = "Elektronik"
        gvLayanan1.adapter = adapter[0]

        var layanansList2 = ArrayList<Layanan>()
        var adapter2 : LayananAdapter? = null;
        layanansList2.add(Layanan("Umum", R.drawable.ic_profile))
        layanansList2.add(Layanan("Atap", R.drawable.ic_profile))
        layanansList2.add(Layanan("Pintu", R.drawable.ic_profile))
        layanansList2.add(Layanan("Atap",R.drawable.ic_profile))
        layanansList2.add(Layanan("Taman", R.drawable.ic_profile))


        layanansLists.add(layanansList2)
        adapter2 = LayananAdapter(this, layanansLists[1])
        adapter.add(adapter2)
        gv2.visibility = View.VISIBLE
        judulGv2.text = "Bangunan & Taman"
        gvLayanan2.adapter = adapter[1]

        var layanansList3 = ArrayList<Layanan>()
        var adapter3 : LayananAdapter? = null;
        layanansList3.add(Layanan("Umum", R.drawable.ic_profile))
        layanansList3.add(Layanan("Mobil", R.drawable.ic_profile))
        layanansList3.add(Layanan("Sepeda Motor", R.drawable.ic_profile))
        layanansList3.add(Layanan("Diesel",R.drawable.ic_profile))
        layanansList3.add(Layanan("Sanyo", R.drawable.ic_profile))


        layanansLists.add(layanansList3)
        adapter3 = LayananAdapter(this, layanansLists[2])
        adapter.add(adapter3)
        gv3.visibility = View.VISIBLE
        judulGv3.text = "Transportasi & Mesin"
        gvLayanan3.adapter = adapter[2]


    }

}
