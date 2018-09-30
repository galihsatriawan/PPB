package co.ppb.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import co.ppb.Model.Mahasiswa
import co.ppb.R
import kotlinx.android.synthetic.main.mahasiswa_item.view.*

/**
 * Created by root on 9/27/18.
 */
class MahasiswaAdapter : BaseAdapter {
    var mahasiswaList = ArrayList<Mahasiswa>()
    var context: Context? = null
    var jenis : Int =1
    constructor(context: Context, mahasiswaList: ArrayList<Mahasiswa>,jenis:Int) : super() {
        this.context = context
        this.mahasiswaList = mahasiswaList
        this.jenis = jenis;
    }

    override fun getCount(): Int {
        return mahasiswaList.size
    }

    override fun getItem(position: Int): Any {
        return mahasiswaList[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val mahasiswa = this.mahasiswaList[position]

        var inflator = context!!.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        var mahasiswaView:Any
                if(jenis == 1) mahasiswaView= inflator.inflate(R.layout.mahasiswa_item, null)
                else mahasiswaView= inflator.inflate(R.layout.mahasiswa_item, null)
        mahasiswaView.imgMhs.setImageResource(mahasiswa.image!!)
        mahasiswaView.namaMhs.setText(mahasiswa.nama!!)
        mahasiswaView.nrpMhs.setText(mahasiswa.nrp!!)

        return mahasiswaView
    }
}