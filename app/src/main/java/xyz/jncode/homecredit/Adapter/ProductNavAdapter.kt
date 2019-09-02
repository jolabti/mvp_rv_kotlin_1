package xyz.jncode.homecredit.Adapter

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import androidx.core.view.isVisible
import com.squareup.picasso.Picasso

import kotlinx.android.synthetic.main.item_nav.view.*
import xyz.jncode.homecredit.Model.ProductModel
import xyz.jncode.homecredit.R

class ProductNavAdapter(var navList: ArrayList<ProductModel>, context: Context) : BaseAdapter() {


    var context: Context? = null


    init {
        this.context = context;
    }


    override fun getView(position: Int, itemView: View?, parent: ViewGroup?): View {

        val navPoint = this.navList[position]

        var inflator = context!!.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        var navView = inflator.inflate(R.layout.item_nav, null)

        navView.image_nav_id.setImageResource(R.mipmap.ic_launcher)
        navView.textview_nav_id.setText(navPoint.name!!)
        navView.ll_item_nav_id.isVisible=true

        Picasso.get().load(navPoint.image).into(navView.image_nav_id)



        return navView

    }

    override fun getItem(position: Int): Any {

        return navList[position]

    }

    override fun getItemId(p0: Int): Long {

        return p0.toLong()
    }

    override fun getCount(): Int {


        Log.d("trace_getcount", navList.size.toString())
        return navList.size




    }
}