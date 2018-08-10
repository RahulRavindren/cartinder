package smove.com.network

import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import smove.com.base.BaseUrl
import smove.com.base.Utils
import smove.com.network.interceptor.NetworkConnectivityInterceptor
import smove.com.network.util.NetworkUtil
import java.util.concurrent.TimeUnit

/**
 * @Author rahulravindran
 */
class RestAdapter {

    companion object {
        val TIME_OUT = 60000
        val httpClient:OkHttpClient = OkHttpClient()

        fun <T> getRestAdapter(clazz: Class<T>): T {
            return initRetrofitBuilder(interceptor = null).create(clazz)
        }


        fun <T> getRestAdapter(clazz: Class<T>, vararg interceptor: Interceptor): T {
            return initRetrofitBuilder(interceptor).create(clazz)
        }

        fun <T> getRestAdapter(baseUrl: String, clazz: Class<T>, vararg interceptor: Interceptor): T {
            return initRetrofitBuilder(baseUrl, interceptor).create(clazz)
        }



        private fun initRetrofitBuilder(baseUrl:String, interceptor: Array<out Interceptor>?): Retrofit{
            return Retrofit.Builder()
                    .baseUrl(baseUrl)
                    .client(getClient(interceptor))
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.createAsync())
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
        }

        private fun initRetrofitBuilder(interceptor: Array<out Interceptor>?): Retrofit{
            return Retrofit.Builder()
                    .baseUrl(BaseUrl.BASE_URL)
                    .client(getClient(interceptor))
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.createAsync())
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
        }



        private fun getClient(interceptor: Array<out Interceptor>?): OkHttpClient {

            var builder: OkHttpClient.Builder = httpClient.newBuilder()
                    .addInterceptor(NetworkConnectivityInterceptor())
                    .addInterceptor(NetworkUtil.networkLogger())
                    .readTimeout(TIME_OUT.toLong(), TimeUnit.SECONDS)
                    .writeTimeout(TIME_OUT.toLong(), TimeUnit.SECONDS)
                    .connectTimeout(TIME_OUT.toLong(), TimeUnit.SECONDS)

            if (interceptor != null && interceptor.isNotEmpty()) {
                interceptor.forEach { interceptor -> builder.addInterceptor(interceptor) }
            }

            return builder.build()
        }

    }


}