package com.sensenews.app.mapper

import com.sensenews.app.data.model.ArticleDTO
import com.sensenews.app.domain.model.Article

fun List<ArticleDTO>.toDomain():List<Article>{
    return map{
        Article(
            content = it.content?:"",
            description = it.description?:"",
            title = it.title?:"",
            urlToImage = it.urlToImage?:""
        )
    }
}