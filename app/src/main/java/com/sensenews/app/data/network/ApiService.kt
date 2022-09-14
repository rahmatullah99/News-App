package com.sensenews.app.data.network

import com.sensenews.app.data.model.NewsDTO
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("top-headlines")
    suspend fun getNewsArticles(
        @Query("country")country:String="us",
        @Query("apiKey")apikey:String="bc6fc56fbbc249119f0a9317eed6878e"
    ):Response<NewsDTO>

}