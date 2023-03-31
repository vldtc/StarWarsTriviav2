package com.example.starwarstrivia.ui.people.peopledetailed

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.starwarstrivia.R
import com.example.starwarstrivia.data.model.people.PeopleDetailedModel
import com.example.starwarstrivia.data.model.people.PeopleModel
import com.example.starwarstrivia.databinding.ItemPeopleDetailsBinding

class PeopleDetailedAdapter(val people: List<PeopleModel>) :
    RecyclerView.Adapter<PeopleDetailedAdapter.ViewHolder>() {

    class ViewHolder(val view: View): RecyclerView.ViewHolder(view) {
        private val binding = ItemPeopleDetailsBinding.bind(view)

        fun handleData(item: PeopleModel?){

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PeopleDetailedAdapter.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_people_details, parent, false)

        return PeopleDetailedAdapter.ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.handleData(people?.get(position))
    }

    override fun getItemCount(): Int = people?.size ?: 0


}
