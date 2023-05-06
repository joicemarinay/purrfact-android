package io.rcm.purrfact.data.remote

import io.rcm.purrfact.data.remote.response.BaseResponse
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Created by joicemarinay on 18/12/2017.
 */
internal interface CatFactsService {

    /**
     * e.g. /facts?limit=7&max_length=140&page=2
     */
    @GET(RemoteConstants.ENDPOINT_FACTS)
    fun getFacts(
            @Query(RemoteConstants.LIMIT) limit: Int,
            @Query(RemoteConstants.MAX_LENGTH) maxLength: Int,
            @Query(RemoteConstants.PAGE) page: Int
    ) : Observable<BaseResponse>
}