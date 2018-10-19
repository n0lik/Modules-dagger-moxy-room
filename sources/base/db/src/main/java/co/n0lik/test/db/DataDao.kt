package co.n0lik.test.db

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy
import android.arch.persistence.room.Query
import io.reactivex.Single
import co.n0lik.test.model.SampleEntity

@Dao
interface DataDao {

    @Query("SELECT * from datadb")
    fun getAll(): Single<List<SampleEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(data: SampleEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertList(list: List<SampleEntity>)

}