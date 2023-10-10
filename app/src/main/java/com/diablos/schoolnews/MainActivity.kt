package com.diablos.schoolnews

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.diablos.schoolnews.databinding.ActivityMainBinding
import com.google.firebase.firestore.FirebaseFirestore

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var firebaseFirestore: FirebaseFirestore
    lateinit var myAdapter : DataAdapter
    lateinit var mList : ArrayList<DataFirebase>
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)

        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        mList = ArrayList()
        initVars()
        getimage()
    }

    private fun initVars(){

        firebaseFirestore = FirebaseFirestore.getInstance()
        binding.rewData.setHasFixedSize(true)
        binding.rewData.layoutManager = LinearLayoutManager(this)
        myAdapter = DataAdapter(mList)
        binding.rewData.adapter = myAdapter
    }
    @SuppressLint("NotifyDataSetChanged")
    private fun getimage() {
        firebaseFirestore.collection("images")
            .get().addOnSuccessListener {
                for (i in it){
                    val dataimg = i.getString("imagesUri")
                    val datatxt = i.getString("textUri")
                    val soatText = i.getString("soatUri")
                    mList.add(DataFirebase(dataimg,datatxt,soatText))
                }
                myAdapter.notifyDataSetChanged()


            }
    }
}