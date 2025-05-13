package com.upakon.networkhelpers.interceptors

import android.content.Context
import okhttp3.Cache
import java.io.File

/**
 * [ClientCacheProvider]
 * Object that provides a cache file for Network connectivity
 * @author Sara Iza
 */
internal object ClientCacheProvider {

    /**
     * [createCache]
     * Method that creates a cache file
     * @param context Application Context
     * @param fileName
     */
    fun createCache(
        context: Context,
        fileName: String
    ): Cache {
        return Cache(File(context.cacheDir,fileName),10L*1024L*1024L)
    }

}