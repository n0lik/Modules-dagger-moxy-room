package co.n0lik.test.repository

import co.n0lik.test.db.DbDao
import co.n0lik.test.model.SampleEntity
import co.n0lik.test.repo.LocalRepo
import javax.inject.Inject

class LocalRepoImpl
    @Inject constructor(private val dao: DbDao): LocalRepo {

    override fun insertList(entities: List<SampleEntity>) { dao.insertList(entities) }

    override fun insert(entity: SampleEntity) { dao.insert(entity) }

    override fun getAll() = dao.getAll()

}