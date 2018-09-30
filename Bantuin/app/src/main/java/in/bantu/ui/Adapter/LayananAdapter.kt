package `in`.bantu.Adapter

import `in`.bantu.Model.Layanan
import `in`.bantu.R
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import kotlinx.android.synthetic.main.layanan_item.view.*

/**
 * Created by root on 9/24/18.
 */
class LayananAdapter : BaseAdapter {
    var layanansList = ArrayList<Layanan>()
    var context: Context? = null

    constructor(context: Context, layanansList: ArrayList<Layanan>) : super() {
        this.context = context
        this.layanansList = layanansList
    }

    override fun getCount(): Int {
        return layanansList.size
    }

    override fun getItem(position: Int): Any {
        return layanansList[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val layanan = this.layanansList[position]

        var inflator = context!!.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        var layananView = inflator.inflate(R.layout.layanan_item, null)
        layananView.imgLayanan.setImageResource(layanan.image!!)
        layananView.tvName.text = layanan.name!!

        return layananView
    }
}