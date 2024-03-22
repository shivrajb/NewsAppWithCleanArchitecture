package com.example.newsappwithcleanarchitecture.ui.data.api

import com.example.newsappwithcleanarchitecture.ui.data.entity.NewsResponce
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("v2/top-headlines")
    suspend fun getNewsHeadline(
        @Query("country") country: String,
        @Query("apiKey") apiKey: String = "94c99869d67844b59d39f1cf0835b196"
    ):Response<NewsResponce>
    //https://newsapi.org/v2/top-headlines?country=us&apiKey=94c99869d67844b59d39f1cf0835b196
}