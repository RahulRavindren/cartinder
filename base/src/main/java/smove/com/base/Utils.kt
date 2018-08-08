package smove.com.base

import android.app.Application
import android.content.Context

/**
 * @Author rahulravindran
 */
class Utils {

    companion object {
        private var application: Application? = null
            private get() = field
            set(value) {field = value}

        fun getApplicationContext(): Context {
            return application!!.applicationContext
        }
    }
}