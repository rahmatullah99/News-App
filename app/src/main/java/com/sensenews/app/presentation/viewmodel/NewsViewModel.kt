package com.sensenews.app.presentation.viewmodel

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sensenews.app.domain.usecase.GetNewsArticle
import com.sensenews.app.presentation.HomeStateHolder
import com.sensenews.app.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.scopes.ViewModelScoped
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class NewsViewModel @Inject constructor(val getNewsArticleUseCase: GetNewsArticle): ViewModel() {

    val articles= mutableStateOf(HomeStateHolder())

    fun getNewsArticle(){
        getNewsArticleUseCase().onEach{

            when(it){
                is Resource.Loading->{articles.value= HomeStateHolder(isLoading = true) }
                is Resource.Success->{articles.value= HomeStateHolder(data = it.data) }
                is Resource.Error->{articles.value= HomeStateHolder(error = it.message.toString()) }
            }
        }.launchIn(viewModelScope)
    }

    init {
        getNewsArticle()
    }

}