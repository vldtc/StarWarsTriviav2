package com.example.starwarstrivia.ui.planets

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.starwarstrivia.R
import com.example.starwarstrivia.data.model.planets.PlanetsResultModel
import com.example.starwarstrivia.databinding.ItemPlanetBinding

class PlanetsAdapter(val planets: MutableList<PlanetsResultModel>?) :
    RecyclerView.Adapter<PlanetsAdapter.ViewHolder>() {

    var onItemClick: ((PlanetsResultModel) -> Unit)? = null

    // ITEM/ROW all the settings/UI of individual items
    class ViewHolder(val view: View) : RecyclerView.ViewHolder(view) {
        private val binding = ItemPlanetBinding.bind(view)

        fun handleData(item: PlanetsResultModel?) {
            binding.tvName.text = "${item?.name}"
            binding.tvRank.text = "#${adapterPosition+1}"

        }

    }

    // Creates the ITEM/ROW for the UI
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlanetsAdapter.ViewHolder {

        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_planet, parent, false)

        return ViewHolder(view)
    }

    // Size of the list
    override fun getItemCount(): Int = planets?.size ?: 0

    // Handle the CURRENT item you are on
    override fun onBindViewHolder(holder: PlanetsAdapter.ViewHolder, position: Int) {
        holder.handleData(planets?.get(position))
        holder.itemView.setOnClickListener{
            planets?.get(position)?.let {
                onItemClick?.invoke(it)
            }
        }
    }

    fun addMoreItems(results: List<PlanetsResultModel>) {
        planets?.addAll(results)
        notifyDataSetChanged()
    }

}
