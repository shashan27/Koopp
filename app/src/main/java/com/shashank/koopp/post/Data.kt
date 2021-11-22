package com.shashank.koopp.post

data class Data(
    val meta: MetaData,
    val data: List<ResultData>
)

data class ResultData(
    val body: String,
    val id: Int,
    val title: String,
    val user_id: Int
)

data class MetaData(
    val pagination: Pagination,
    val total: Int?,
    val pages: String?,
    val page: String?,
    val limit: Any?,
    val links: Links
)
