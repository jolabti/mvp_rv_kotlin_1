package xyz.jncode.homecredit.Adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatImageView
import androidx.appcompat.widget.AppCompatTextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import xyz.jncode.homecredit.Model.NewsModel
import xyz.jncode.homecredit.R

class NewsViewHolder(inflater: LayoutInflater, parent: ViewGroup) :
    RecyclerView.ViewHolder(inflater.inflate(R.layout.item_section_news, parent, false)) {
    private var imageNews: AppCompatImageView? = null
    private var imageText: AppCompatTextView? = null


    init {
        imageNews = itemView.findViewById(R.id.image_news_id)
        imageText = itemView.findViewById(R.id.text_news_id)
    }

    fun bind(productModel: NewsModel) {
            //        mTitleView?.text = movie.title
            //        mYearView?.text = movie.year.toString()

          imageText?.text= productModel.name
          Picasso.get().load(productModel.image).into(imageNews)
    }

}