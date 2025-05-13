package com.upakon.networkhelpers.okHttp

/**
 * [OkHttpHelper]
 * Object that exposes the [OkHttpBuilder]
 * @author Sara Iza
 */
object OkHttpHelper {

    /**
     * [builder]
     * Exposes interface [OkHttpBuilder]
     */
    val builder: OkHttpBuilder by lazy {
        OkHttpBuilderImpl()
    }

}