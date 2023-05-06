package io.rcm.purrfact.di

import dagger.Module
import dagger.Provides
import io.rcm.purrfact.BuildConfig
import io.rcm.purrfact.data.remote.CatFactsService
import io.rcm.purrfact.data.remote.RemoteConstants
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

/**
 * For remote data dependencies
 *
 * Created by joicemarinay on 18/12/2017.
 */
@Module
internal class RemoteModule {

    @Provides
    @Singleton
    fun provideCatFactsService(retrofit: Retrofit): CatFactsService =
            retrofit.create(CatFactsService::class.java)

    @Provides
    @Singleton
    fun provideOkHttpClient(): OkHttpClient {
        var okbuilder = OkHttpClient.Builder()
        if (BuildConfig.DEBUG) {
            okbuilder.addInterceptor(HttpLoggingInterceptor()
                    .setLevel(HttpLoggingInterceptor.Level.BODY))
        } else {
            okbuilder.addInterceptor(HttpLoggingInterceptor()
                    .setLevel(HttpLoggingInterceptor.Level.NONE))
        }
        return okbuilder.build()
    }

    @Provides
    @Singleton
    fun providesRetrofit(okHttpClient: OkHttpClient): Retrofit =
            Retrofit.Builder()
                    .baseUrl(RemoteConstants.BASE_API)
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .client(okHttpClient)
                    .build()

}