package co.n0lik.test.action

import android.content.Context
import co.n0lik.test.model.SampleEntity


interface ShowDetailScreen {

    fun showDetail(context: Context, entity: SampleEntity)

    companion object {
        const val DATA_KEY = "DATA_KEY"
    }
}