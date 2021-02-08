package com.example.businesscontrol.ui.main.adapter

import android.annotation.SuppressLint
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.businesscontrol.R
import com.example.businesscontrol.models.LocalData

class AdapterMain() :RecyclerView.Adapter<AdapterMain.MainHolder>(){
    var listService : MutableList<Int> = mutableListOf()
    var listName: MutableList<String> = mutableListOf()
    lateinit var localData: LocalData



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_main_holder,parent,false)
        return MainHolder(view)
    }

    override fun getItemCount(): Int {
        return listService.count()
    }

    override fun onBindViewHolder(holder: MainHolder, position: Int) {
        holder.onBind(listService[position])
        //holder.onName(listName[position])
    }
    fun addImage(item: MutableList<Int>){
        listService.addAll(item)
        notifyDataSetChanged()
    }
//    fun addString(item: MutableList<String>){
//        listName.addAll(item).toString()
//    }

    inner class MainHolder(itemView: View): RecyclerView.ViewHolder(itemView) {

        val imageMainHolder:ImageView = itemView.findViewById(R.id.image_main_holder)
        val tvNameService :TextView = itemView.findViewById(R.id.tv_name_service)


        @SuppressLint("SetTextI18n")
        fun onBind(int: Int) {
            imageMainHolder.setImageResource(int)
            tvNameService.text
        }
        fun onName(s:String){
            //tvNameService.text[0].toString()
        }
    }
}

