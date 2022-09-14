package com.sensenews.app.domain.usecase

import com.sensenews.app.domain.model.Article
import com.sensenews.app.domain.repository.GetNewsArticleRepo
import com.sensenews.app.utils.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GetNewsArticle @Inject constructor(private val getNewsArticleRepo: GetNewsArticleRepo) {

    operator fun invoke(): Flow<Resource<List<Article>>> = flow{
        emit(Resource.Loading(""))
        try{ emit(Resource.Success(getNewsArticleRepo.getNewsArticle())) }
        catch (e:Exception){ emit(Resource.Error(e.message)) }
    }

}