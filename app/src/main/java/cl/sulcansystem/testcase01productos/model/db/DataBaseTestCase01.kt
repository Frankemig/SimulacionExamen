package cl.sulcansystem.testcase01productos.model.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [EntityTestCase01::class], version = 1)
abstract class DataBaseTestCase01 : RoomDatabase(){

    abstract fun getDaoTest(): DaoTestCase01

    companion object {
        // Singleton prevents multiple instances of database opening at the
        // same time.
        @Volatile
        private var INSTANCE: DataBaseTestCase01? = null

        fun getDatabase(context: Context): DataBaseTestCase01 {
            val tempInstance =
                INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }
            synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    DataBaseTestCase01::class.java,
                    "hero_database"
                ).build()
                INSTANCE = instance
                return instance
            }
        }
    }
}