package co.n0lik.test.db

import io.reactivex.Single
import co.n0lik.test.model.SampleEntity

interface DbDao{

    fun getAll(): Single<List<SampleEntity>>

    fun insert(sampleEntity: SampleEntity)

    fun insertList(list: List<SampleEntity>)

}