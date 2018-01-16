package io.rcm.purrfact.common.util

import io.rcm.purrfact.data.CatFact

/**
 * Created by joicemarinay on 06/12/2017.
 */
internal fun createCatFact(fact: String): CatFact = CatFact(fact, fact.length)