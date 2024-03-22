package com.example.newsappwithcleanarchitecture.ui.repository

import com.example.newsappwithcleanarchitecture.ui.data.datasource.NewsDataSource
import com.example.newsappwithcleanarchitecture.ui.data.entity.NewsResponce
import com.example.utilities.ResourceState
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class NewsRepository @Inject constructor(
    private val newsDataSource: NewsDataSource
) {

    suspend fun getNewsHeadline(country: String): Flow<ResourceState<NewsResponce>> {
        return flow {

            emit(ResourceState.Loading())

            val response = newsDataSource.getNewsHeadlines(country)

            if (response.isSuccessful && response.body()!=null){
                emit(ResourceState.Success(response.body()!!))
            }else {
                emit(ResourceState.Error("Error fetching data"))
            }
        }.catch {e->
            emit(ResourceState.Error(e.localizedMessage?:"some error in flow"))
        }
    }
}