package com.example.businesscontrol.data.repository

import android.content.ContentValues.TAG
import android.util.Log
import com.google.firebase.firestore.FirebaseFirestore
import java.util.*
import kotlin.collections.HashMap


class MainRepository (){
    var db = FirebaseFirestore.getInstance()

    val map = HashMap<String, Any>()
    val array = arrayOf("One", "Two", "Three")




    fun mainList(){
        map["array"] = Arrays.asList(*array)
    }

    val serviceСategory = hashMapOf(
        "engine" to "Engine",
        "transmission" to "Transmission",
        "chassis" to "Chassis",
        "electronics" to "Electronics",
        "carBody" to "CarBody",
        "salon" to "Salon"
    )


    fun mainList2(){
        db.collection("cities").document("LA")
            .set(serviceСategory)
            .addOnSuccessListener { Log.d(TAG, "DocumentSnapshot successfully written!") }
            .addOnFailureListener { e -> Log.w(TAG, "Error writing document", e) }
    }

}