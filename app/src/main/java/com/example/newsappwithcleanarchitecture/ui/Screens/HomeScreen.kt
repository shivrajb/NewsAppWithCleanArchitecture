package com.example.newsappwithcleanarchitecture.ui.Screens

import android.util.Log
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.pager.PageSize
import androidx.compose.foundation.pager.VerticalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.newsappwithcleanarchitecture.ui.components.Loader
import com.example.newsappwithcleanarchitecture.ui.components.NewsList
import com.example.newsappwithcleanarchitecture.ui.components.NewsRowComponent
import com.example.newsappwithcleanarchitecture.ui.data.entity.NewsResponce
import com.example.newsappwithcleanarchitecture.ui.viewmodel.NewsViewModel
import com.example.utilities.ResourceState

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun HomeScreen(
    newsViewModel: NewsViewModel = hiltViewModel()
) {

    val newsResponse by newsViewModel.news.collectAsState()

    val pagerState= rememberPagerState(
        initialPage = 0,
        initialPageOffsetFraction = 0f
    ) {
        100
    }

    VerticalPager(state = pagerState,
        modifier = Modifier.fillMaxSize(),
        pageSize = PageSize.Fill,
        pageSpacing = 8.dp) {page: Int ->

            when(newsResponse){
                is ResourceState.Loading -> {
                    Loader()
                }
                is ResourceState.Success -> {
                    val response = (newsResponse as ResourceState.Success<NewsResponce>).data
                    Log.e("tag",response.toString())
                    if (response.articles.isNotEmpty()){
                        NewsRowComponent(page, response.articles[page])
                    }
                }
                is ResourceState.Error -> {
                    Text(text = "dsdfsds")
                }
            }

    }
}

@Preview
@Composable
fun HomeScreenPreview() {
HomeScreen()
}