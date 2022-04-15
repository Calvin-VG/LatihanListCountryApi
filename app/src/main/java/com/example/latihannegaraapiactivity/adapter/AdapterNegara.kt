package com.example.latihannegaraapiactivity.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.latihannegaraapiactivity.R
import com.example.latihannegaraapiactivity.model.GetAllNegaraResponItem
import kotlinx.android.synthetic.main.item_adapter_negara.view.*

class AdapterNegara(private var datanegara: List<GetAllNegaraResponItem>) : RecyclerView.Adapter<AdapterNegara.ViewHolder>() {
    class ViewHolder(itemView : View):RecyclerView.ViewHolder(itemView) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AdapterNegara.ViewHolder {
        val itemview = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_adapter_negara, parent, false)
        return AdapterNegara.ViewHolder(itemview)
    }

    override fun onBindViewHolder(holder: AdapterNegara.ViewHolder, position: Int) {
        holder.itemView.tv_nama_negara.text = datanegara[position].name
        holder.itemView.tv_region_negara.text = datanegara[position].region
        holder.itemView.tv_populasi_negara.text = datanegara[position].population.toString()

        Glide.with(holder.itemView.context).load(datanegara[position].flags.png).into(holder.itemView.iv_gambar_negara)
    }

    override fun getItemCount(): Int {
        return datanegara.size
    }
}