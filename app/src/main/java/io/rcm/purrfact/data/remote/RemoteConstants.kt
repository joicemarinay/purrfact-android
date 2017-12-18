package io.rcm.purrfact.data.remote

/**
 * Created by joicemarinay on 18/12/2017.
 */
internal class RemoteConstants {

    companion object {

        const val ENDPOINT_FACTS = "facts"

        //Base response
        const val CURRENT_PAGE = "current_page"
        const val DATA = "data"
        const val FROM = "from"
        const val LAST_PAGE = "last_page"
        const val PER_PAGE = "per_page"
        const val TO = "to"
        const val TOTAL = "total"

        //Query param
        const val LIMIT = "limit"
        const val MAX_LENGTH = "max_length"
        const val PAGE = "limit"
    }
}