package com.example.newsappwithcleanarchitecture.ui.data.entity

data class NewsResponce(
    val articles: List<Article>,
    val status: String?,
    val totalResults: Int?
)