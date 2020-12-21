package com.alkesh.randomquote.core.network.retrofitService

import com.alkesh.randomquote.core.network.constant.NetworkConstants
import com.google.gson.GsonBuilder
import com.premier.dataProvider.common.network.ApiService
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit


object RetrofitService {
    lateinit var retrofit: Retrofit
    fun getInstance(): ApiService {
        val retrofit =
            getRetrofitInstance()
        val apiService = retrofit.create(ApiService::class.java)
        return apiService
    }

    private fun getRetrofitInstance(): Retrofit {
        val interceptor = HttpLoggingInterceptor()
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY)

        val clientBuilder = OkHttpClient.Builder()
            .connectTimeout(10, TimeUnit.SECONDS)
            .writeTimeout(30, TimeUnit.SECONDS)
            .readTimeout(30, TimeUnit.SECONDS)
            .addInterceptor(interceptor)

        val client = clientBuilder.build()
        val builder = Retrofit.Builder()
        builder.baseUrl(NetworkConstants.BaseURL)
        builder.addConverterFactory(
            GsonConverterFactory.create(
                GsonBuilder().excludeFieldsWithoutExposeAnnotation().create()
            )
        )
        builder.client(client)

        retrofit = builder.build()
        return retrofit
    }
}