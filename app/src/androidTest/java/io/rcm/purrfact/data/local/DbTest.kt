package io.rcm.purrfact.data.local

import android.arch.persistence.room.Room
import android.support.test.InstrumentationRegistry
import org.junit.After
import org.junit.Before

/**
 * Created by joicemarinay on 06/12/2017.
 */
abstract internal class DbTest {

    @Before
    fun initDb() {
        // using an in-memory database because the information stored here
        // disappears after the test
        db = Room.inMemoryDatabaseBuilder(InstrumentationRegistry.getContext(),
                PurrfactDb::class.java)
                .build()
    }

    @After
    fun closeDb() = db.close()

    companion object {
        private val TAG = DbTest::class.java.simpleName
        lateinit var db: PurrfactDb
    }
}