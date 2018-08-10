package smove.com.store

import com.nytimes.android.external.store3.base.Fetcher

/**
 * @Author rahulravindran
 */
interface NetworkFetcher<Raw, Key>: Fetcher<Raw, Key> {
    fun fetch()
}