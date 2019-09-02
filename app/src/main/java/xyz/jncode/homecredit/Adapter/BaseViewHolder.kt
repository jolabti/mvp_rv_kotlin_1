package xyz.jncode.homecredit.Adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView

//https://medium.com/@ivancse.58/android-and-kotlin-recyclerview-with-multiple-view-types-65285a254393


abstract class BaseViewHolder<T>(itemView: View) : RecyclerView.ViewHolder(itemView) {
    abstract fun bind(item: T)
}