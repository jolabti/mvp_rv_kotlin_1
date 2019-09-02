package xyz.jncode.homecredit.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import xyz.jncode.homecredit.Model.NewsModel
import xyz.jncode.homecredit.Model.ProductModel

class RvAdapter(private val list: ArrayList<NewsModel>,  context:Context)
    : RecyclerView.Adapter<NewsViewHolder>() {

    var context: Context? = null


    init {

        this.context = context

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return NewsViewHolder(inflater, parent)
    }

    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {
        val news: NewsModel = list[position]
        holder.bind(news)
    }

    override fun getItemCount(): Int = list.size

}