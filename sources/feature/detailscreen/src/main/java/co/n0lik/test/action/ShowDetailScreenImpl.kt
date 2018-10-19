package co.n0lik.test.action

import android.content.Context
import android.content.Intent
import co.n0lik.test.detailscreen.DetailActivity
import co.n0lik.test.model.SampleEntity

class ShowDetailScreenImpl: ShowDetailScreen {

    override fun showDetail(context: Context, entity: SampleEntity) {
        context.startActivity(Intent(context, DetailActivity::class.java).apply {
            putExtra(ShowDetailScreen.DATA_KEY, entity)
        })
    }

}