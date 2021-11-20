package io.deanencoded.koopp.post

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiInteface {

    @GET("v1")
    suspend fun getData(@Query("posts") query: Int): Data


}