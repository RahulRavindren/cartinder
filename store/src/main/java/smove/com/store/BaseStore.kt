package smove.com.store

import com.nytimes.android.external.store3.base.Fetcher
import com.nytimes.android.external.store3.base.Persister
import com.nytimes.android.external.store3.base.impl.RealStore

/**
 * @Author rahulravindran
 */
open class BaseStore<P,T> : RealStore<P,T> {
    constructor(fetcher: Fetcher<P, T>, persister: Persister<P, T>) : super(fetcher, persister)

}