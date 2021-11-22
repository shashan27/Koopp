package com.shashank.koopp.post

import android.net.Uri
import androidx.paging.PagingSource
import androidx.paging.PagingState

class CharacterPagingSource(private val apiService: ApiInteface): PagingSource<Int, ResultData>() {

    override fun getRefreshKey(state: PagingState<Int, ResultData>): Int? {

        return state.anchorPosition

    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, ResultData> {
        return try {
            val nextPage: Int = params.key ?: FIRST_PAGE_INDEX
            val response = apiService.getData(nextPage)

            var nextPageNumber: Int? = null
            if(response?.meta?.next != null) {
                val uri = Uri.parse(response?.meta?.next!!)
                val nextPageQuery = uri.getQueryParameter("page")
                nextPageNumber = nextPageQuery?.toInt()
            }
            var prevPageNumber: Int? = null
            if(response?.meta?.previous != null) {
                val uri = Uri.parse(response?.meta?.previous!!)
                val prevPageQuery = uri.getQueryParameter("page")

                prevPageNumber = prevPageQuery?.toInt()
            }

            LoadResult.Page(data = response.data,
                prevKey = prevPageNumber,
                nextKey = nextPageNumber)
        }
        catch (e: Exception) {
            LoadResult.Error(e)
        }
    }
    companion object {
        private const val FIRST_PAGE_INDEX = 1
    }

}