package com.upakon.networkhelpers.network

import android.net.ConnectivityManager
import android.net.NetworkCapabilities

/**
 * NetworkVerification
 * Helper class that verifies if Internet is connected
 * @property connectivityManager Connectivity Manager from Application's Context
 * @constructor Creates an instance of the NetworkVerification class
 */

class NetworkVerification(
    private val connectivityManager: ConnectivityManager
) {

    /**
     * verifyConnectivity
     * Method to verify if Internet is connected
     * @return true if device is connected to internet
     */

    fun verifyConnectivity(): Boolean =
        connectivityManager
            .getNetworkCapabilities(connectivityManager.activeNetwork)
            ?.hasCapability(NetworkCapabilities.NET_CAPABILITY_INTERNET) ?: false

}