package com.upakon.networkhelpers.interceptors

import okhttp3.CacheControl
import okhttp3.Interceptor
import okhttp3.Response
import java.util.concurrent.TimeUnit

/**
 * Cache Interceptor
 * @author Sara Iza
 * Creates a Cache Control Interceptor for API Connections
 * Implements: interceptor
 * @param maxAge The amount of time it takes for the copy of a resource to expire
 * @param timeUnit
 * @constructor Creates a new Cache Interceptor
 */
class CacheInterceptor(
    private val maxAge: Int,
    private val timeUnit: TimeUnit
) : Interceptor {

    /**
     * [intercept]
     * Adds a Cache Control header to the Response
     * Cache control
     * @param chain
     * @return Response
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