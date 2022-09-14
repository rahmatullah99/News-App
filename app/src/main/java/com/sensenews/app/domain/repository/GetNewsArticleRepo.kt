package com.sensenews.app.domain.repository

import com.sensenews.app.domain.model.Article

interface GetNewsArticleRepo {

    suspend fun getNewsArticle():List<Article>

}