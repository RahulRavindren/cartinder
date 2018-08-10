package smove.com.network.util

import android.annotation.SuppressLint
import android.content.Context
import android.content.Context.CONNECTIVITY_SERVICE
import android.net.ConnectivityManager
import android.net.NetworkInfo
import android.support.annotation.RequiresPermission
import okhttp3.logging.HttpLoggingInterceptor
import smove.com.base.Utils

/**
 * @Author rahulravindran
 */
class NetworkUtil {

    companion object {

        @SuppressLint("MissingPermission")
        fun isNetworkAvailable(): Boolean {
            val connectivityManager = Utils.getApplicationContext().getSystemService(Context
                    .CONNECTIVITY_SERVICE) as ConnectivityManager
            val networkInfo = connectivityManager.activeNetworkInfo as NetworkInfo
            return networkInfo!= null && networkInfo.isConnected
        }

        fun networkLogger(): HttpLoggingInterceptor {
            val logging:HttpLoggingInterceptor = HttpLoggingInterceptor();
            logging.level = HttpLoggingInterceptor.Level.valueOf(Utils.logLevel!!.getNetworkDebugLevel())
            return logging
        }
    }
}