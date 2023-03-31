package com.example.starwarstrivia.ui.vehicles

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.starwarstrivia.R
import com.example.starwarstrivia.data.model.vehicles.VehiclesResultModel
import com.example.starwarstrivia.databinding.ItemVehicleBinding

class VehiclesAdapter(val vehicles: MutableList<VehiclesResultModel>?) :
    RecyclerView.Adapter<VehiclesAdapter.ViewHolder>() {

    var onItemClick: ((VehiclesResultModel) -> Unit)? = null

    // ITEM/ROW all the settings/UI of individual items
    class ViewHolder(val view: View) : RecyclerView.ViewHolder(view) {
        private val binding = ItemVehicleBinding.bind(view)

        fun handleData(item: VehiclesResultModel?) {
            binding.tvName.text = "${item?.name}"
            binding.tvRank.text = "#${adapterPosition + 1}"

        }

    }

    // Creates the ITEM/ROW for the UI
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VehiclesAdapter.ViewHolder {

        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_vehicle, parent, false)

        return ViewHolder(view)
    }

    // Size of the list
    override fun getItemCount(): Int = vehicles?.size ?: 0

    // Handle the CURRENT item you are on
    override fun onBindViewHolder(holder: VehiclesAdapter.ViewHolder, position: Int) {
        holder.handleData(vehicles?.get(position))
        holder.itemView.setOnClickListener {
            vehicles?.get(position)?.let {
                onItemClick?.invoke(it)
            }
        }
    }

    fun addMoreItems(results: List<VehiclesResultModel>) {
        vehicles?.addAll(results)
        notifyDataSetChanged()
    }

}
