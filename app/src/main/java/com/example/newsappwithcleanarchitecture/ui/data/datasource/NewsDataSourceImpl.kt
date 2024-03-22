package com.example.newsappwithcleanarchitecture.ui.data.datasource

import com.example.newsappwithcleanarchitecture.ui.data.api.ApiService
import com.example.newsappwithcleanarchitecture.ui.data.entity.NewsResponce
import retrofit2.Response
import javax.inject.Inject

class NewsDataSourceImpl @Inject constructor(
    private val apiService: ApiService
): NewsDataSource {
    override suspend fun getNewsHeadlines(country: String): Response<NewsResponce> {
        return apiService.getNewsHeadline(country)
    }
}