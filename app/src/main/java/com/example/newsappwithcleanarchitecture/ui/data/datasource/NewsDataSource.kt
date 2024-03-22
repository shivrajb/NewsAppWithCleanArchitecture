package com.example.newsappwithcleanarchitecture.ui.data.datasource

import com.example.newsappwithcleanarchitecture.ui.data.entity.NewsResponce
import retrofit2.Response

interface NewsDataSource {

    suspend fun getNewsHeadlines(country: String): Response<NewsResponce>
}