package smove.com.store

import android.net.Uri
import com.nytimes.android.external.store3.base.Fetcher
import com.nytimes.android.external.store3.base.Persister
import com.nytimes.android.external.store3.base.impl.BarCode
import com.nytimes.android.external.store3.base.impl.Store
import com.nytimes.android.external.store3.base.impl.StoreBuilder
import com.nytimes.android.external.store3.util.NoopParserFunc
import okio.BufferedSource

/**
 * @Author rahulravindran
 */
class AppStore(val persister: Persister<BufferedSource, BarCode>) : BaseStore<BufferedSource, BarCode>(fetcher, persister) {
    companion object {
        private var INSTANCE: AppStore? = null

        fun getInstance(fetcher: Fetcher<BufferedSource, BarCode>): AppStore? {
            if (INSTANCE == null) {
                synchronized(AppStore::class) {
                    if (INSTANCE == null) {
                        INSTANCE = AppStore(AppPersister.initPersister())
                    }
                }
            }
            return INSTANCE
        }
    }

    private fun init():Store<BarCode, BarCode> {
        return StoreBuilder.parsedWithKey<BarCode,BufferedSource, BarCode>()
                .fetcher(fetcher)
                .persister(persister)
                .parser(NoopParserFunc())
                .open()
    }

    fun getStore(): Store<BarCode, BarCode> {
        return init()
    }

}