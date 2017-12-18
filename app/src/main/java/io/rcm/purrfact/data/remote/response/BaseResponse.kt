package io.rcm.purrfact.data.remote.response

import com.google.gson.annotations.SerializedName
import io.rcm.purrfact.data.remote.RemoteConstants

/**
 * Created by joicemarinay on 18/12/2017.
 */
internal abstract class BaseResponse {

    @SerializedName(RemoteConstants.CURRENT_PAGE)
    lateinit var currentPage: String

    @SerializedName(RemoteConstants.LAST_PAGE)
    lateinit var lastPage: String

    @SerializedName(RemoteConstants.PER_PAGE)
    lateinit var perPage: String

    @SerializedName(RemoteConstants.FROM)
    lateinit var from: String

    @SerializedName(RemoteConstants.TO)
    lateinit var to: String

    @SerializedName(RemoteConstants.TOTAL)
    lateinit var total: String

    fun getCurrentPage(): Int = currentPage as Int

    fun getLastPage(): Int = lastPage as Int

    fun getPerPage(): Int = perPage as Int

    fun getFrom(): Int = from as Int

    fun getTo(): Int = to as Int

    fun getTotal(): Int = total as Int
}