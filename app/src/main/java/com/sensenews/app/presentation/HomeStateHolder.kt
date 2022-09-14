package com.sensenews.app.presentation

import com.sensenews.app.domain.model.Article

data class HomeStateHolder(
    val isLoading:Boolean=false,
    val data:List<Article>? = null,
    val error:String=""
)
