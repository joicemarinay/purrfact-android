package io.rcm.purrfact.view.catfacts

import android.support.v7.widget.RecyclerView
import android.view.View
import io.rcm.purrfact.data.CatFact
import kotlinx.android.synthetic.main.catfacts_item.view.*

/**
 * Created by joicemarinay on 29/12/2017.
 */
internal class CatFactViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    private lateinit var listener: Listener

    fun bind(item: CatFact?, itemListener: Listener) = with(itemView) {
        listener = itemListener
        textviewCatfact.text = item?.fact
        setOnClickListener { listener.onFactItemClicked(item) }
    }

    interface Listener {
        fun onFactItemClicked(item: CatFact?)
    }
}