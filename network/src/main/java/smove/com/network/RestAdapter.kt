package smove.com.network

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import smove.com.base.BaseUrl
import smove.com.base.Utils
import smove.com.network.interceptor.NetworkConnectivityInterceptor
import java.util.concurrent.TimeUnit

/**
 * @Author rahulravindran
 */
class RestAdapter {

    companion object {
        val TIME_OUT = 60000

        fun <T> getRestAdapter(clazz: Class<T>): T {

        }


        private fun initRetrofitBuilder(): Retrofit{
            Retrofit.Builder()
                    .baseUrl(BaseUrl.BASE_URL)
                    .client(getClient())
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.createAsync())
                    .addConverterFactory()
        }

        private fun getClient(): OkHttpClient {
            return OkHttpClient.Builder()
                    .addInterceptor(NetworkConnectivityInterceptor())
                    .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.valueOf(Utils.logLevel!!.getNetworkDebugLevel())))
                    .readTimeout(TIME_OUT.toLong(), TimeUnit.SECONDS)
                    .writeTimeout(TIME_OUT.toLong(), TimeUnit.SECONDS)
                    .connectTimeout(TIME_OUT.toLong(), TimeUnit.SECONDS)
                    .build()
        }
    }


}