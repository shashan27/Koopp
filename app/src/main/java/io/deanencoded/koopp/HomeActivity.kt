package io.deanencoded.koopp

import android.os.Bundle
import android.util.Log
import android.util.Log.d
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import io.deanencoded.koopp.post.ApiInteface
import io.deanencoded.koopp.post.Base_urls
import io.deanencoded.koopp.post.Data
import io.deanencoded.koopp.post.MyAdapter
import kotlinx.android.synthetic.main.activity_home.*
import retrofit2.*
import retrofit2.converter.gson.GsonConverterFactory
import kotlin.math.log

const val  Base_url = "https://gorest.co.in/"
class HomeActivity : AppCompatActivity() {

    lateinit var myAdapter: MyAdapter
    lateinit var linearLayoutManager: LinearLayoutManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        recyclerview_users.setHasFixedSize(true)
        linearLayoutManager = LinearLayoutManager(this)
        recyclerview_users.layoutManager = linearLayoutManager

        //Main
        getMyData()
    }

    private fun getMyData() {
        val retrofitBuilder = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(Base_urls)
            .build()
            .create(ApiInteface::class.java)


        val retrofitData = retrofitBuilder.getData()


        //Enqueue
        retrofitData.enqueue(object : Callback<List<Data>?> {
            override fun onResponse(call: Call<List<Data>?>, response: Response<List<Data>?>) {
                val responseBody = response.body()!!

                myAdapter = MyAdapter(baseContext, responseBody)
                recyclerview_users.adapter = myAdapter

            }

            override fun onFailure(call: Call<List<Data>?>, t: Throwable) {
                d("HomeActivity", "onFailure: " + t.message)
            }
        })
    }
}