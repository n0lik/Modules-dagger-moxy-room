package co.n0lik.test.repo

import io.reactivex.Single
import co.n0lik.test.model.SampleEntity

interface LocalRepo {

    fun getAll(): Single<List<SampleEntity>>

    fun insert(entity: SampleEntity)

    fun insertList(entities: List<SampleEntity>)

}