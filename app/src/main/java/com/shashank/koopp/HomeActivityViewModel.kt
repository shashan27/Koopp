package com.shashank.koopp

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.shashank.koopp.post.ApiInteface
import com.shashank.koopp.post.CharacterPagingSource
import com.shashank.koopp.post.RetroInstance
import com.shashank.koopp.post.ResultData
import kotlinx.coroutines.flow.Flow

class HomeActivityViewModel: ViewModel() {

    var retroService: ApiInteface = RetroInstance.getRetroInstance().create(ApiInteface::class.java)

    fun getListData(): Flow<PagingData<ResultData>> {
        return Pager (config = PagingConfig(pageSize = 65, maxSize = 200),
            pagingSourceFactory = {
                CharacterPagingSource(retroService)
            }).flow.cachedIn(viewModelScope)
    }

}