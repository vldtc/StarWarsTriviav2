package com.example.starwarstrivia.ui.starships

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.starwarstrivia.R
import com.example.starwarstrivia.data.model.starships.StarshipsResultModel
import com.example.starwarstrivia.databinding.ItemStarshipBinding

class StarshipsAdapter(val starships: MutableList<StarshipsResultModel>?) :
    RecyclerView.Adapter<StarshipsAdapter.ViewHolder>() {

    var onItemClick: ((StarshipsResultModel) -> Unit)? = null

    // ITEM/ROW all the settings/UI of individual items
    class ViewHolder(val view: View) : RecyclerView.ViewHolder(view) {
        private val binding = ItemStarshipBinding.bind(view)

        fun handleData(item: StarshipsResultModel?) {
            binding.tvName.text = "${item?.name}"
            binding.tvRank.text = "#${adapterPosition+1}"

        }

    }

    // Creates the ITEM/ROW for the UI
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StarshipsAdapter.ViewHolder {

        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_people, parent, false)

        return ViewHolder(view)
    }

    // Size of the list
    override fun getItemCount(): Int = starships?.size ?: 0

    // Handle the CURRENT item you are on
    override fun onBindViewHolder(holder: StarshipsAdapter.ViewHolder, position: Int) {
        holder.handleData(starships?.get(position))
        holder.itemView.setOnClickListener{
            starships?.get(position)?.let {
                onItemClick?.invoke(it)
            }
        }
    }

    fun addMoreItems(results: List<StarshipsResultModel>) {
        starships?.addAll(results)
        notifyDataSetChanged()
    }

}
