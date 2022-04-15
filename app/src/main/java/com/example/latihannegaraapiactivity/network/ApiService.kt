package com.example.latihannegaraapiactivity.network

import com.example.latihannegaraapiactivity.model.GetAllNegaraResponItem
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {

    @GET("all")
    fun getAllNegara() : Call<List<GetAllNegaraResponItem>>

}