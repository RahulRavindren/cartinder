package smove.com.network

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import smove.com.base.BaseUrl

/**
 * @Author rahulravindran
 */
class RestAdapter {

    companion object {
        val okHttpClient = OkHttpClient() // shared between all clients

        val DEFUALT_BUIDER = OkHttpClient.Builder()
                .addInterceptor()

        fun <T> getRestAdapter(clazz: Class<T>): T {

        }


        private fun initRetrofitBuilder(): Retrofit{
            Retrofit.Builder()
                    .baseUrl(BaseUrl.BASE_URL)
                    .client(getClient())
        }

        private fun getClient(): OkHttpClient {
            return okHttpClient.newBuilder()
        }
    }


}