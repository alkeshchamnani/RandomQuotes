package com.premier.dataProvider.common.network

import com.alkesh.randomquote.core.network.response.QuoteDto
import retrofit2.Response
import retrofit2.http.GET


interface ApiService {
    @GET("/quotes/random")
    suspend fun getRandomQuote(): Response<QuoteDto>
}