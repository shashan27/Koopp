package io.deanencoded.koopp

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.cachedIn
import io.deanencoded.koopp.post.ApiInteface
import io.deanencoded.koopp.post.CharacterPagingSource
import io.deanencoded.koopp.post.RetroInstance
import io.deanencoded.koopp.post.resultData
import kotlinx.coroutines.flow.Flow

class MainActivityViewModel {

    lateinit var retroService: ApiInteface

    init {
        retroService = RetroInstance.getRetroInstance().create(ApiInteface::class.java)
    }

    fun getListData(): Flow<PagingData<resultData>> {
        return Pager (config = PagingConfig(pageSize = 73, maxSize = 200),
            pagingSourceFactory = {
                CharacterPagingSource(retroService)
            }).flow.cachedIn(viewModelScope)
    }

}