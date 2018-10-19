package co.n0lik.test.db

import co.n0lik.test.model.SampleEntity

object PopulateEntities {

    fun populate(): List<SampleEntity> {
        val entities = ArrayList<SampleEntity>()
        for (i in 0..20){
            entities.add(SampleEntity(null, "SampleEntity $i"))
        }
        return entities
    }

}