package com.pissiphany.ports.repository.jsonPlaceholder

import com.pissiphany.ports.domain.JsonPlaceholderService
import retrofit2.Retrofit
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Created by kierse on 2016-08-14.
 */
fun buildJsonPlaceholderService() : JsonPlaceholderService {
    return Retrofit.Builder()
            .baseUrl("http://jsonplaceholder.typicode.com")
            .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(JsonPlaceholderService::class.java)
}
