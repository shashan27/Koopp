package io.deanencoded.koopp.post

import retrofit2.Call
import retrofit2.http.GET

interface ApiInteface {

    @GET("/posts")
    fun getData(): Call<List<Data>>

}