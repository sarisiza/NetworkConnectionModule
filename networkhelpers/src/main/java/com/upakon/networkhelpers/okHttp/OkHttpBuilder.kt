package com.upakon.networkhelpers.okHttp

import android.content.Context
import com.upakon.networkhelpers.network.NetworkVerification
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import java.util.concurrent.TimeUnit

/**
 * [OkHttpBuilder]
 * Interface that exposes the methods to build a custom OkHttpClient
 *
 * Expose implementation through [OkHttpHelper]
 * @author Sara Iza
 */
interface OkHttpBuilder {

    fun forceCache(networkVerification: NetworkVerification)
    fun cache(context: Context, fileName: String)
    fun cacheInterceptor(maxSize: Int, timeUnit: TimeUnit)
    fun logging(level: HttpLoggingInterceptor.Level)
    fun addInterceptor(interceptor: Interceptor)
    fun build(): OkHttpClient

}