package smove.com.base

/**
 * @Author rahulravindran
 */
class BaseUrl{
    companion object {
        var BASE_URL: String? = null
            private set
            get() = BASE_URL

        fun init(buildConfig: BuildConfig) {
            BaseUrl(buildConfig)
        }
    }

    constructor(buildConfig: BuildConfig) {

    }



}