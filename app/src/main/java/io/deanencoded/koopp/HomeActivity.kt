package io.deanencoded.koopp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import io.deanencoded.koopp.post.*
import kotlinx.android.synthetic.main.activity_home.*
import kotlinx.coroutines.flow.collectLatest
import retrofit2.*


class HomeActivity : AppCompatActivity() {

    //Instance
    lateinit var myAdapter: MyAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        initRecyclerView()
        initViewModel()
    }

    private fun initRecyclerView() {
        recyclerview_users.apply {
            layoutManager = LinearLayoutManager(this@HomeActivity)
            val decoration  = DividerItemDecoration(applicationContext, DividerItemDecoration.VERTICAL)
            addItemDecoration(decoration)
            myAdapter = MyAdapter()
            adapter = myAdapter

        }
    }

    private fun initViewModel() {
        val viewModel  = ViewModelProvider(this).get(MainActivityViewModel::class.java)
        lifecycleScope.launchWhenCreated {
            viewModel.getListData().collectLatest {
                myAdapter.submitData(it)
            }
        }
    }

}