package io.rcm.purrfact.data.local

import android.arch.persistence.room.Database
import android.arch.persistence.room.Room
import android.arch.persistence.room.RoomDatabase
import android.content.Context
import io.rcm.purrfact.data.CatFact

/**
 * Room database that contains "catfacts" table
 *
 * Created by joicemarinay on 06/12/2017.
 */
@Database(entities = arrayOf(CatFact::class), version = 1)
internal abstract class PurrfactDb : RoomDatabase() {

    abstract fun catfactDao(): CatFactsDao

    companion object {
        private const val DB_NAME = "Purrfact.db"
        @Volatile private var INSTANCE: PurrfactDb? = null

        fun getInstance(context: Context): PurrfactDb =
                INSTANCE ?: synchronized(this) {
                    INSTANCE ?: buildDatabase(context)
                            .also { INSTANCE = it }
        }

        private fun buildDatabase(context: Context) =
                Room.databaseBuilder(context.applicationContext,
                        PurrfactDb::class.java, DB_NAME)
                        .build()
    }

}