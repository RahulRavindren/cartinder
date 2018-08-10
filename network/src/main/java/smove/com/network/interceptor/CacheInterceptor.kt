package smove.com.network.interceptor

import okhttp3.Headers
import okhttp3.Interceptor
import okhttp3.Request
import okhttp3.Response

/**
 * @Author rahulravindran
 */
class CacheInterceptor : Interceptor{

    override fun intercept(chain: Interceptor.Chain?): Response {
        val request:Request = chain!!.request()
        var response:Response =  chain.proceed(request) as Response

        if (parseHeaderForAppCache(request.headers())) {
            response.networkResponse()
        }
        return response
    }

    private fun parseHeaderForAppCache(headers: Headers): Boolean {
        return headers.get("appCache").equals("true")
    }
}