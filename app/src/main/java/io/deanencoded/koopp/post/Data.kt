package io.deanencoded.koopp.post

data class Data(
    val meta: metaData,
    val data: List<resultData>
)

data class resultData(
    val body: String,
    val id: Int,
    val title: String,
    val user_id: Int
)

data class metaData(
    val total: Int?,
    val pages: Int?,
    val page: Int?,
    val limit: Int?,
    val links: String?,
    val previous: String?,
    val current: String?,
    val next: String?,
)