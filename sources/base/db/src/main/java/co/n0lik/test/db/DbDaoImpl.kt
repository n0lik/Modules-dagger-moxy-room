package co.n0lik.test.db

import co.n0lik.test.model.SampleEntity
import io.reactivex.Single

class DbDaoImpl
    constructor(val db: DataDatabase): DbDao {

    override fun getAll(): Single<List<SampleEntity>> {
        return db.dataDao().getAll()
    }

    override fun insert(sampleEntity: SampleEntity) {
        db.dataDao().insert(sampleEntity)
    }

    override fun insertList(list: List<SampleEntity>) {
        db.dataDao().insertList(list)
    }

}