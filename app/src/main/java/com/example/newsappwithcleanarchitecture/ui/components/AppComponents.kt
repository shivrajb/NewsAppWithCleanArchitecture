package com.example.newsappwithcleanarchitecture.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.newsappwithcleanarchitecture.R
import com.example.newsappwithcleanarchitecture.ui.data.entity.Article
import com.example.newsappwithcleanarchitecture.ui.data.entity.NewsResponce
import com.example.newsappwithcleanarchitecture.ui.theme.Purple40

@Composable
fun Loader() {

    Column(modifier = Modifier
        .fillMaxSize()
        .padding(8.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center) {
        CircularProgressIndicator(
            modifier = Modifier
                .size(60.dp)
                .padding(10.dp),
            color = Purple40
        )
    }
    
}

@Composable
fun NewsList(response: NewsResponce) {
    LazyColumn{
        items(response.articles) {article->
          Text(text = article.title?:"NA")
        }
    }
}

@Composable
fun NewsRowComponent(page: Int, article: Article) {
    Column(modifier = Modifier
        .fillMaxSize()
        .padding(8.dp)
        .background(Color.White)) {

        AsyncImage(
            modifier = Modifier
                .fillMaxWidth()
                .size(240.dp),
            model = article.urlToImage,
            contentDescription = "",
            contentScale = ContentScale.Crop,
            placeholder = painterResource(id = R.drawable.ic_launcher_background),
            error = painterResource(id = R.drawable.ic_launcher_background)
        )

        Spacer(modifier = Modifier.size(20.dp))

        HeadingText(textValue = article.title ?: "")

        NormalText(textValue = article.content ?: "")
        
    }
}

@Composable
fun HeadingText(textValue: String) {
    Text(modifier = Modifier
        .fillMaxWidth()
        .wrapContentHeight()
        .padding(8.dp)
        ,text = textValue,
        style = TextStyle(
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold
        )
    )
}

@Composable
fun NormalText(textValue: String) {
    Text(modifier = Modifier
        .fillMaxWidth()
        .wrapContentHeight()
        .padding(8.dp)
        ,text = textValue,
        style = TextStyle(
            fontSize = 18.sp,
            fontWeight = FontWeight.Normal,
            color = Purple40
        )
    )
}