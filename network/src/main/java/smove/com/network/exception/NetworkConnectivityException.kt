package smove.com.network.exception

import smove.com.base.Utils
import smove.com.network.R

/**
 * @Author rahulravindran
 */
class NetworkConnectivityException: BaseException {
    companion object {
        val DEFUALT = Utils.getStringFromResource(R.string.network_connection_error)
    }
    constructor() : super(DEFUALT)
    constructor(message: String?) : super(message)
    constructor(message: String?, cause: Throwable?) : super(message, cause)
    constructor(cause: Throwable?) : super(cause)
}