package smove.com.store

import android.net.Uri
import com.nytimes.android.external.fs3.FileSystemPersisterFactory
import com.nytimes.android.external.fs3.PathResolver
import com.nytimes.android.external.fs3.filesystem.FileSystemFactory
import com.nytimes.android.external.store3.base.Persister
import com.nytimes.android.external.store3.base.impl.BarCode
import okio.BufferedSource
import smove.com.base.Utils

/**
 * @Author rahulravindran
 */
class AppPersister {
    companion object {

        fun initPersister(): Persister<BufferedSource, BarCode> {
           return  FileSystemPersisterFactory
                   .create(FileSystemFactory.create(Utils.getApplicationContext().cacheDir), AppPathResolver())
        }
    }


    class AppPathResolver: PathResolver<BarCode> {
        override fun resolve(key: BarCode): String {
            return key.toString()
        }
    }
}