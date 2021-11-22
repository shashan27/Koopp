package com.shashank.koopp.post

import retrofit2.http.GET
import retrofit2.http.Query

interface ApiInteface {

    @GET("posts")
    suspend fun getData(@Query("page") query: Int): Data


}