package com.example.businesscontrol.ui.main.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.businesscontrol.R
import com.example.businesscontrol.models.Category
import com.example.businesscontrol.ui.main.MainActivity


class AdapterMain(var onItemClickListener: MainActivity) :RecyclerView.Adapter<AdapterMain.MainHolder>(){
    var listService : MutableList<Category> = mutableListOf()


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_main_holder,parent,false)
        return MainHolder(view)
    }

    override fun getItemCount(): Int {
        return listService.count()
    }

    override fun onBindViewHolder(holder: MainHolder, position: Int) {
        holder.onBind(listService[position])
    }

    fun addImage(item: MutableList<Category>){
        listService.addAll(item)
        notifyDataSetChanged()
    }


    inner class MainHolder(itemView: View): RecyclerView.ViewHolder(itemView) {

        val imageMainHolder:ImageView = itemView.findViewById(R.id.image_main_holder)
        val tvNameService :TextView = itemView.findViewById(R.id.tv_name_service)


        @SuppressLint("SetTextI18n")
        fun onBind(category: Category) {
            imageMainHolder.setImageResource(category.imageId!!)
            tvNameService.text = category.name
            itemView.setOnClickListener { onItemClickListener.itemClick(category.id) }
        }

    }
}

