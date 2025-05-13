package com.upakon.networkhelpers.interceptors

import com.upakon.networkhelpers.network.NetworkVerification
import okhttp3.CacheControl
import okhttp3.Interceptor
import okhttp3.Response

/**
 * [ForceCacheInterceptor]
 * @author Sara Iza
 * Forces caching whenever internet is not available
 * @constructor Creates a [ForceCacheInterceptor]
 * @param networkVerification Helper to verify if internet is present
 * Implements: Interceptor
 */

internal class ForceCacheInterceptor(
    private val networkVerification: NetworkVerification
) : Interceptor {

    /**
     * [intercept]
     * Adds a Cache Control header that Forces Cache whenever connection is not available
     * @param chain
     * @return Header response
     */
    override fun intercept(chain: Interceptor.Chain): Response {
        chain.request().newBuilder().apply {
            if(!networkVerification.verifyConnectivity())
                cacheControl(CacheControl.FORCE_CACHE)
        }.build().also { return chain.proceed(it) }
    }
}