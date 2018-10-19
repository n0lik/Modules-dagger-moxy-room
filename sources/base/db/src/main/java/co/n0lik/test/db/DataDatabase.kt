package co.n0lik.test.db

import android.arch.persistence.db.SupportSQLiteDatabase
import android.arch.persistence.room.Database
import android.arch.persistence.room.Room
import android.arch.persistence.room.RoomDatabase
import android.content.Context
import co.n0lik.test.model.SampleEntity
import java.util.concurrent.Executors

@Database(entities = [SampleEntity::class], version = 1)
abstract class DataDatabase: RoomDatabase() {

    abstract fun dataDao(): DataDao

    companion object {

        private var INSTANCE: DataDatabase? = null

        fun getInstance(context: Context): DataDatabase? {
            if(INSTANCE == null) {
                synchronized(DataDatabase::class){
                    INSTANCE = Room.databaseBuilder(context.applicationContext,
                            DataDatabase::class.java, "data.db")
                            .addCallback(object : RoomDatabase.Callback() {
                                override fun onCreate(db: SupportSQLiteDatabase) {
                                    super.onCreate(db)
                                    Executors.newSingleThreadExecutor().execute {
                                        getInstance(context)!!.dataDao()
                                                .insertList(PopulateEntities.populate())
                                    }
                                }
                            })
                            .build()

                }
            }
            return INSTANCE
        }

        fun destroyInstance(){
            INSTANCE = null
        }

    }

}