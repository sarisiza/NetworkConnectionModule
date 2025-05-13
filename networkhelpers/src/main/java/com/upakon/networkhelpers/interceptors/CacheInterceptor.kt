package com.upakon.networkhelpers.interceptors

import com.upakon.networkhelpers.network.NetworkVerification
import okhttp3.CacheControl
import okhttp3.Interceptor
import okhttp3.Response
import java.util.concurrent.TimeUnit

/**
 * [CacheInterceptor]
 * Creates a Cache Control Interceptor for API Connections
 *
 * Implements: interceptor
 * @author Sara Iza
 * @param maxAge The amount of time it takes for the copy of a resource to expire
 * @param timeUnit
 * @constructor Creates a new Cache Interceptor
 */
internal class CacheInterceptor(
    private val maxAge: Int,
    private val timeUnit: TimeUnit,
) : Interceptor {

    /**
     * [intercept]
     * Adds a Cache Control header to the Response
     * @param chain
     * @return Header Response
     */
    override fun intercept(chain: Interceptor.Chain): Response {
        val cacheControl =
            CacheControl.Builder()
                .maxAge(maxAge, timeUnit)
                .build()
        chain.request().newBuilder().apply {
            header("Cache-Control",cacheControl.toString())
        }.build().also { return chain.proceed(it) }
    }
}