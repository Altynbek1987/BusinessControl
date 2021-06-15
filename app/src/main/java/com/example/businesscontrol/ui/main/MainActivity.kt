package com.example.businesscontrol.ui.main

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.example.businesscontrol.R
import com.example.businesscontrol.interfase.OnItemClickListener
import com.example.businesscontrol.models.Category
import com.example.businesscontrol.models.LocalData
import com.example.businesscontrol.ui.detail.DetailActivity
import com.example.businesscontrol.ui.detail.adapter.AdapterDetail
import com.example.businesscontrol.ui.main.adapter.AdapterMain
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity() : AppCompatActivity(),OnItemClickListener {

    private lateinit var adapterMain: AdapterMain
    private lateinit var viewModel: MainViewModel
    var db = FirebaseFirestore.getInstance()
    private var listServiceActivity: MutableList<Category> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        viewModel = ViewModelProvider(
            this,
            ViewModelProvider.NewInstanceFactory()
        ).get(MainViewModel::class.java)
        setAdapter()
    }

    private fun setAdapter() {
        recyclerview_main.layoutManager = GridLayoutManager(this, 2)
        adapterMain = AdapterMain(this)
        recyclerview_main.adapter = adapterMain
        recyclerview_main.setHasFixedSize(true)
        adapterMain.addImage(LocalData.dataCategory.toMutableList())

    }

    override fun itemClick(position: Int) {
        DetailActivity.instanceActivity(this, listServiceActivity, position)
    }

}