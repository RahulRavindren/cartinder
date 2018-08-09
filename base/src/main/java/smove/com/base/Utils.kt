package smove.com.base

import android.app.Application
import android.content.Context
import android.support.annotation.IntegerRes
import java.time.ZoneId

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


        fun getStringFromResource(resId: Int):String {
            return getApplicationContext().getString(resId)
        }

        fun getStringFromResource(resId: Int, vararg params:String):String {
            return getApplicationContext().getString(resId, params)
        }


    }
}