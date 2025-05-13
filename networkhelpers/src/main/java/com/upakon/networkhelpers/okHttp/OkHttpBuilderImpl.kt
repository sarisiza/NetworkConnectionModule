package com.upakon.networkhelpers.okHttp

import android.content.Context
import com.upakon.networkhelpers.interceptors.CacheInterceptor
import com.upakon.networkhelpers.interceptors.ClientCacheProvider
import com.upakon.networkhelpers.interceptors.ForceCacheInterceptor
import com.upakon.networkhelpers.network.NetworkVerification
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import java.util.concurrent.TimeUnit

/**
 * [OkHttpBuilderImpl]
 * Class that builds a custom OkHttpClient
 *
 * Implements: [OkHttpBuilder]
 * @author Sara Iza
 */
internal class OkHttpBuilderImpl : OkHttpBuilder {

    private val builder = OkHttpClient.Builder()

    override fun forceCache(networkVerification: NetworkVerification){
        builder.addInterceptor(ForceCacheInterceptor(networkVerification))
    }

    override fun cache(context: Context, fileName: String){
        builder.cache(ClientCacheProvider.createCache(context, fileName))
    }

    override fun cacheInterceptor(
        maxSize: Int,
        timeUnit: TimeUnit
    ){
        builder.addInterceptor(CacheInterceptor(maxSize,timeUnit))
    }

    override fun logging(
        level: HttpLoggingInterceptor.Level
    ){
        val logger = HttpLoggingInterceptor().apply {
            this.level = level
        }
        builder.addInterceptor(logger)
    }

    override fun addInterceptor(interceptor: Interceptor){
        builder.addInterceptor(interceptor)
    }

    override fun build(): OkHttpClient = builder.build()

}