package com.example.starwarstrivia.ui.people

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.starwarstrivia.R
import com.example.starwarstrivia.data.model.people.PeopleModel
import com.example.starwarstrivia.data.model.people.PeopleResultModel
import com.example.starwarstrivia.databinding.ItemPeopleBinding

class PeopleAdapter(val people: MutableList<PeopleResultModel>?) :
    RecyclerView.Adapter<PeopleAdapter.ViewHolder>() {

    var onItemClick: ((PeopleResultModel) -> Unit)? = null

    // ITEM/ROW all the settings/UI of individual items
    class ViewHolder(val view: View) : RecyclerView.ViewHolder(view) {
        private val binding = ItemPeopleBinding.bind(view)

        fun handleData(item: PeopleResultModel?) {
            binding.tvName.text = "${item?.name}"
            binding.tvRank.text = "#${adapterPosition+1}"

        }

    }

    // Creates the ITEM/ROW for the UI
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PeopleAdapter.ViewHolder {

        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_people, parent, false)

        return ViewHolder(view)
    }

    // Size of the list
    override fun getItemCount(): Int = people?.size ?: 0

    // Handle the CURRENT item you are on
    override fun onBindViewHolder(holder: PeopleAdapter.ViewHolder, position: Int) {
        holder.handleData(people?.get(position))
        holder.itemView.setOnClickListener{
            people?.get(position)?.let {
                onItemClick?.invoke(it)
            }
        }
    }

    fun addMoreItems(results: List<PeopleResultModel>) {
        people?.addAll(results)
        notifyDataSetChanged()
    }

}

