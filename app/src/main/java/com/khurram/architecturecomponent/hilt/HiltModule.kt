package com.khurram.architecturecomponent.hilt

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.khurram.architecturecomponent.BuildConfig
import com.khurram.architecturecomponent.network.APIsInterface
import com.khurram.architecturecomponent.repository.NetworkRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@InstallIn(ApplicationComponent::class)
@Module
object HiltModule {

        private val BASE_URL= BuildConfig.BASE_URL
        private val interceptor: HttpLoggingInterceptor = HttpLoggingInterceptor().setLevel(
            HttpLoggingInterceptor.Level.BODY)
        val okHttpClient = OkHttpClient.Builder()
            .readTimeout(60, TimeUnit.SECONDS)
            .connectTimeout(60, TimeUnit.SECONDS)
            .addInterceptor(interceptor)
            .build()


    @Singleton
    @Provides
    fun providesGsonBuilder() : Gson{
        return GsonBuilder().create()
    }

    @Singleton
    @Provides
    fun providesRetrofit(gson: Gson): Retrofit.Builder{
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create(gson))
    }

    @Singleton
    @Provides
    fun providesNetworkAPI(retrofit: Retrofit.Builder): APIsInterface{
        return retrofit.build().create(APIsInterface::class.java)
    }

    @Singleton
    @Provides
    fun providesNetworkRepository(apIsInterface: APIsInterface) : NetworkRepository {
        return NetworkRepository(apIsInterface)
    }
}