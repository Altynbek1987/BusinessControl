package com.example.businesscontrol.ui.detail

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.example.businesscontrol.R
import com.example.businesscontrol.models.Category
import com.example.businesscontrol.models.LocalData
import com.example.businesscontrol.ui.detail.adapter.AdapterDetail
import com.example.businesscontrol.ui.main.MainViewModel
import com.example.businesscontrol.ui.main.adapter.AdapterMain
import kotlinx.android.synthetic.main.activity_detail.*
import kotlinx.android.synthetic.main.activity_main.*

class DetailActivity : AppCompatActivity() {
    private lateinit var dViewModel: DetailViewModel
    private lateinit var adapterDetail: AdapterDetail
    private var data: String? = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        dViewModel = ViewModelProvider(this, ViewModelProvider.NewInstanceFactory()).get(DetailViewModel::class.java)
        setAdapterDetail()

    }


    fun setAdapterDetail(){
        recyclerview_detail.layoutManager = GridLayoutManager(this, 1)
        adapterDetail= AdapterDetail()
        recyclerview_detail.adapter = adapterDetail
        recyclerview_detail.setHasFixedSize(true)
        adapterDetail.addDetailCategory(LocalData.dataCategory[positionData!!].listData!!)

    }

    companion object{
        var detaillist: MutableList<Category>? = null
        var positionData:Int?=null

        fun instanceActivity(
            context: Context,
            detaillist:MutableList<Category>,
            positionData:Int
        ){
            this.positionData = positionData
            val intent = Intent(context,DetailActivity::class.java)
            this.detaillist = detaillist
            context.startActivity(intent)
        }
    }
}