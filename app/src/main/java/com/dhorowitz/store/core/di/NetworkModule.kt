package com.dhorowitz.store.core.di

import com.dhorowitz.store.data.ProductsRepository
import com.dhorowitz.store.data.ProductsRepositoryImpl
import com.dhorowitz.store.data.StoreApi
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

private const val BASE_URL = "https://api.myjson.com"

@Module
class NetworkModule {
    @Provides
    fun providesRetrofit(okHttpClient: OkHttpClient): Retrofit =
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient)
            .build()


    @Provides
    fun providesOkHttpClient(): OkHttpClient {
        val logging = HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        }
        return OkHttpClient.Builder()
            .addInterceptor(logging)
            .build()
    }

    @Provides
    fun providesStoreApi(retrofit: Retrofit): StoreApi = retrofit.create(StoreApi::class.java)

    @Provides
    fun provideRepository(storeApi: StoreApi): ProductsRepository = ProductsRepositoryImpl(storeApi)
}