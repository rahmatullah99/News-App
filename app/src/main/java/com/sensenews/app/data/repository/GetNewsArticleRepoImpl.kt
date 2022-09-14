package com.sensenews.app.data.repository

import com.sensenews.app.data.network.ApiService
import com.sensenews.app.domain.model.Article
import com.sensenews.app.domain.repository.GetNewsArticleRepo
import com.sensenews.app.mapper.toDomain
import com.sensenews.app.utils.SafeApiRequest
import javax.inject.Inject

class GetNewsArticleRepoImpl@Inject constructor(val apiService:ApiService):
    GetNewsArticleRepo, SafeApiRequest() {

    override suspend fun getNewsArticle(): List<Article> {
        val response = safeApiRequest { apiService.getNewsArticles() }
        return response.articles?.toDomain()!!
    }

}