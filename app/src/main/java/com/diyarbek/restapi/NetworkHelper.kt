package com.diyarbek.restapi

import com.diyarbek.restapi.model.SchoolClass
import com.diyarbek.restapi.retrofit.ApiInterface
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.Callback
import retrofit2.Response

class NetworkHelper(private val apiClient: Retrofit) {

    fun getClasses(listener: NetworkListener) {
        val call: Call<List<SchoolClass>> = apiClient.create(ApiInterface::class.java).getClasses()
        call.enqueue(object : Callback<List<SchoolClass>> {
            override fun onResponse(
                call: Call<List<SchoolClass>>,
                response: Response<List<SchoolClass>>
            ) {
                listener.onSchoolClassesResponse(response?.body())
            }

            override fun onFailure(call: Call<List<SchoolClass>>, t: Throwable) {
                listener.onSchoolClassesFailure(t?.localizedMessage)
            }

        })


    }
}