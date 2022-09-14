package com.sensenews.app.domain.model

import com.sensenews.app.data.model.SourceDTO

data class Article(
    val content: String,
    val description: String,
    val title: String,
    val urlToImage: String
)