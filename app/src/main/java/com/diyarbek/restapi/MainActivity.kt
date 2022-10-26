package com.diyarbek.restapi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.DividerItemDecoration
import com.diyarbek.restapi.databinding.ActivityMainBinding
import com.diyarbek.restapi.model.SchoolClass
import com.diyarbek.restapi.model.SchoolClassAdapter
import com.diyarbek.restapi.retrofit.ApiClient

class MainActivity : AppCompatActivity(), NetworkListener {

    private lateinit var binding: ActivityMainBinding
    private val adapter = SchoolClassAdapter()
    private lateinit var networkHelper: NetworkHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.mList.adapter = adapter
        binding.mList.addItemDecoration(DividerItemDecoration(this, DividerItemDecoration.VERTICAL))
        networkHelper = NetworkHelper(ApiClient.getClient())
        setData()
    }

    private fun setData() {
        networkHelper.getClasses(this)
    }

    override fun onSchoolClassesResponse(models: List<SchoolClass>?) {
       adapter.models = models
    }

    override fun onSchoolClassesFailure(message: String?) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show()
    }
}