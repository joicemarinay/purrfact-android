package io.rcm.purrfact.data

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

/**
 * Model class for a CatFact
 *
 * Value of column fact is considered the primary key
 *  to ensure that no duplicate facts are inserted in the table.
 *  Decided to do this because there is no way in Room (yet) to
 *  indicate that a column's value should be unique.
 *
 *  TODO this will also be re-used as a model for API calls
 *
 * Created by joicemarinay on 06/12/2017.
 */
@Entity(tableName = "catfacts")
internal data class CatFact (
        @PrimaryKey
        @ColumnInfo(name = COLUMN_FACT)
        val fact: String,

        @ColumnInfo(name = COLUMN_LENGTH)
        val length: Int) {

    companion object {
        const val COLUMN_FACT = "fact"
        const val COLUMN_LENGTH = "length"
        const val TABLE_NAME = "catfacts"
    }
}