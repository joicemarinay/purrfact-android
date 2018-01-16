package io.rcm.purrfact.view.catfacts

import android.arch.paging.PagedListAdapter
import android.support.v7.recyclerview.extensions.DiffCallback
import android.view.ViewGroup
import io.rcm.purrfact.R
import io.rcm.purrfact.common.util.inflate
import io.rcm.purrfact.data.CatFact

/**
 * Created by joicemarinay on 29/12/2017.
 */
internal class CatFactsAdapter(private val listener: CatFactViewHolder.Listener) :
        PagedListAdapter<CatFact, CatFactViewHolder>(DIFF_CALLBACK) {

    override fun onBindViewHolder(holder: CatFactViewHolder, position: Int) {
        holder.bind(getItem(position), listener)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CatFactViewHolder
            = CatFactViewHolder(parent.inflate(R.layout.catfacts_item))

    companion object {
        private val DIFF_CALLBACK = object : DiffCallback<CatFact>() {
            override fun areContentsTheSame(oldItem: CatFact, newItem: CatFact): Boolean
                    = oldItem.fact == newItem.fact

            override fun areItemsTheSame(oldItem: CatFact, newItem: CatFact): Boolean
                    = oldItem == newItem
        }
    }
}