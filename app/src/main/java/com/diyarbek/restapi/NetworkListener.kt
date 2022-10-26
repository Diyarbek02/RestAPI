package com.diyarbek.restapi

import com.diyarbek.restapi.model.SchoolClass

interface NetworkListener {

    fun onSchoolClassesResponse(models: List<SchoolClass>?)
    fun onSchoolClassesFailure(message: String?)
}