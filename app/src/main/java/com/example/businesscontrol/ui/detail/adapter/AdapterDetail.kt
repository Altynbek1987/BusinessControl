package com.example.businesscontrol.ui.detail.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RadioButton
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.businesscontrol.R
import com.example.businesscontrol.models.Category
import com.example.businesscontrol.ui.detail.DetailActivity

class AdapterDetail : RecyclerView.Adapter<AdapterDetail.DetailHolder>(){

    var listDetail: MutableList<String> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DetailHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_detail_holder,parent,false)
        return DetailHolder(view)
    }

    override fun getItemCount(): Int {
       return listDetail.count()
    }


    override fun onBindViewHolder(holder: DetailHolder, position: Int) {
        holder.onBindDetail(listDetail[position])
    }

    fun addDetailCategory(item:  MutableList<String>){
        listDetail.addAll(item)
        notifyDataSetChanged()
    }

    inner class DetailHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val tvDetailService:TextView = itemView.findViewById(R.id.tv_detail_service)
        val radioButton: RadioButton = itemView.findViewById(R.id.radio_button)


        fun onBindDetail(category: String) {
            tvDetailService.text = category
            if (radioButton.isChecked){

            }
        }

    }


}