package io.rcm.purrfact.data.local

import android.support.test.runner.AndroidJUnit4
import io.rcm.purrfact.data.CatFact
import io.rcm.purrfact.common.util.createCatFact
import junit.framework.TestCase.assertNotNull
import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.CoreMatchers.notNullValue
import org.hamcrest.MatcherAssert.assertThat
import org.junit.Test
import org.junit.runner.RunWith

/**
 *
 * Test implementation of [CatFactsDao]
 *
 * Created by joicemarinay on 06/12/2017.
 */
@RunWith(AndroidJUnit4::class)
internal class CatFactsDaoTest: DbTest() {

    @Test
    fun insertCatFacts_shouldReturnBasedOnMaxLength() {
        //When inserting 2 cat facts
        db.catfactDao().insertFact(CAT_FACT_SHORT)
        db.catfactDao().insertFact(CAT_FACT_LONG)

        //When getting the catfacts by length
        val loadedAll = db.catfactDao().getFactsByLength(CAT_FACT_LONG.length)
        val loadedShort = db.catfactDao().getFactsByLength(CAT_FACT_SHORT.length)

        //The loaded catfacts with max length long should...
        // be not null
        assertNotNull(loadedAll)
        // have 2
        assertThat(loadedAll?.size, `is`(2))

        //The loaded catfacts with max length long should...
        // be not null
        assertNotNull(loadedShort)
        // have only 1 cat fact
        assertThat(loadedShort?.size, `is`(1))
        //should match cat fact with short length
        assertCatFact(loadedShort?.get(0), CAT_FACT_SHORT)
    }

    private fun assertCatFact(factToAssert: CatFact?, factReference: CatFact) {
        assertThat<CatFact>(factToAssert as CatFact, notNullValue())
        assertThat(factToAssert.fact, `is`(factReference.fact))
        assertThat(factToAssert.length, `is`(factReference.length))
    }

    companion object {
        private val TAG = CatFactsDaoTest::class.java.simpleName
        private val FACT_SHORT = "The cat's tail is used to maintain balance."
        private val CAT_FACT_SHORT = createCatFact(FACT_SHORT)

        private val FACT_LONG = "There are approximately 60,000 hairs per square inch on the back of a cat and about 120,000 per square inch on its underside."
        private val CAT_FACT_LONG = createCatFact(FACT_LONG)
    }
}