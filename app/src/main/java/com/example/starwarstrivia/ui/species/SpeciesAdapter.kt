package com.example.starwarstrivia.ui.species

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.starwarstrivia.R
import com.example.starwarstrivia.data.model.people.PeopleResultModel
import com.example.starwarstrivia.data.model.species.SpeciesModel
import com.example.starwarstrivia.data.model.species.SpeciesResultModel
import com.example.starwarstrivia.databinding.ItemSpeciesBinding

class SpeciesAdapter(val species: MutableList<SpeciesResultModel>?) :
    RecyclerView.Adapter<SpeciesAdapter.ViewHolder>() {

    var onItemClick: ((SpeciesResultModel) -> Unit)? = null

    class ViewHolder(val view: View): RecyclerView.ViewHolder(view) {
        private val binding = ItemSpeciesBinding.bind(view)

        fun handleData(item: SpeciesResultModel?){
            binding.tvName.text = item?.name
            binding.tvRank.text = "#${adapterPosition+1}"
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SpeciesAdapter.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_species, parent, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.handleData(species?.get(position))
        holder.itemView.setOnClickListener{
            species?.get(position)?.let {
                onItemClick?.invoke(it)
            }
        }
    }

    override fun getItemCount(): Int = species?.size ?: 0

    fun addMoreItems(results: List<SpeciesResultModel>) {
        species?.addAll(results)
        notifyDataSetChanged()
    }


}
