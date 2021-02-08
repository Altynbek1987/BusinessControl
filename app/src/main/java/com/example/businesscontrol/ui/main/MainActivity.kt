package com.example.businesscontrol.ui.main

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.example.businesscontrol.R
import com.example.businesscontrol.models.LocalData
import com.example.businesscontrol.ui.main.adapter.AdapterMain
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity() : AppCompatActivity() {

    private lateinit var adapterMain: AdapterMain
    private lateinit var viewModel: MainViewModel

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
        adapterMain = AdapterMain()
        recyclerview_main.adapter = adapterMain
        recyclerview_main.setHasFixedSize(true)
        adapterMain.addImage(LocalData.arr.toMutableList())
        //adapterMain.addString(LocalData.stringList.toMutableList())
        //Log.e("ololo","setAdapter" + adapterMain.addString(LocalData.stringList.toMutableList()))

    }

}