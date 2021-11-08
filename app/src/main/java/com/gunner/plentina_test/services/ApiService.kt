package com.gunner.plentina_test.services

import com.gunner.plentina_test.models.ResponseInfo
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

/**
Created by GUNNER on 2021-11-05 18:37

 */
interface ApiService {
    @GET(" ")
    suspend fun fetchMatchInfoList() : ResponseInfo

    companion object {
        var apiService: ApiService? = null
        fun getInstance() : ApiService {
            if (apiService == null) {
                apiService = Retrofit.Builder()
                    .baseUrl("https://www.scorebat.com/video-api/v3/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build().create(ApiService::class.java)
            }
            return apiService!!
        }
    }
}