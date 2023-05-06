package io.rcm.purrfact.data.local

import android.arch.persistence.room.*
import io.rcm.purrfact.data.CatFact

/**
 *
 * Data Access Object for catfacts table.
 *
 * Created by joicemarinay on 06/12/2017.
 */
@Dao internal interface CatFactsDao {

    /**
     * Get all facts whose character length is
     *  less than or equal to a specified length.
     *
     * @param maxLength maximum character length of a fact
     * @return facts within specified maxLength
     */
    @Query("SELECT * FROM ${CatFact.TABLE_NAME} WHERE ${CatFact.COLUMN_LENGTH} <= :maxLength")
    fun getFactsByLength(maxLength: Int): List<CatFact>?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertFact(fact: CatFact)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertFacts(facts: List<CatFact>)

    /**
     * Deletes all cat facts
     */
    @Query("DELETE FROM ${CatFact.TABLE_NAME}")
    fun deleteCatFacts()

}