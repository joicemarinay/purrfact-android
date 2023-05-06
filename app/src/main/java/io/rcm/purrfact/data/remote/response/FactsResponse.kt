package io.rcm.purrfact.data.remote.response

import com.google.gson.annotations.SerializedName
import io.rcm.purrfact.data.CatFact
import io.rcm.purrfact.data.remote.RemoteConstants

/**
 * Created by joicemarinay on 18/12/2017.
 */
internal data class FactsResponse(
        @SerializedName(RemoteConstants.DATA) val factList: List<CatFact>
) : BaseResponse()