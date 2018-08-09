package smove.com.network.interceptor

import okhttp3.Interceptor
import okhttp3.Response
import smove.com.network.exception.NetworkConnectivityException
import smove.com.network.util.NetworkUtil

/**
 * @Author rahulravindran
 */
class NetworkConnectivityInterceptor: Interceptor{

    companion object {
        val TAG = NetworkConnectivityException::class.simpleName
    }


    override fun intercept(chain: Interceptor.Chain?): Response? {
        if (!NetworkUtil.isNetworkAvailable()){
            throw NetworkConnectivityException()
        }
        return chain?.proceed(chain.request())
    }
}