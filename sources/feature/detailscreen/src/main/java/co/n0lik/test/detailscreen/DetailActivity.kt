package co.n0lik.test.detailscreen

import android.os.Bundle
import android.support.v7.widget.Toolbar
import android.util.Log
import android.view.MenuItem
import android.widget.Chronometer
import android.widget.TextView
import com.arellomobile.mvp.MvpAppCompatActivity
import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import co.n0lik.test.App
import co.n0lik.test.action.ShowDetailScreen
import co.n0lik.test.di.ActivityScope
import co.n0lik.test.di.DetailActivityComponent
import co.n0lik.test.model.SampleEntity
import javax.inject.Inject

@ActivityScope
class DetailActivity : MvpAppCompatActivity(), DetailView {

    override fun showData(entity: SampleEntity) {
        detailTitle.text = entity.text
    }

    @Inject
    @InjectPresenter
    lateinit var presenter: DetailPresenter

    @ProvidePresenter
    fun provideMainPresenter() = presenter

    private val detailTitle by lazy {
        findViewById<TextView>(R.id.detailTitle)
    }

    private val toolbar1 by lazy {
        findViewById<Toolbar>(R.id.toolbar)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        inject()
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        setSupportActionBar(toolbar1)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        println("PresenterDetail hashCode = ${presenter.hashCode()}")
    }

    private fun inject() {
        DetailActivityComponent.Initializer
                .init((applicationContext as App).getAppComponent())
                .inject(this@DetailActivity)
    }

    override fun onResume() {
        super.onResume()
        (intent.getParcelableExtra(ShowDetailScreen.DATA_KEY) as? SampleEntity)?.also {
            presenter.addModel(it)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "$TAG has been destroyed")
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when (item?.itemId) {
            android.R.id.home -> onBackPressed()
        }
        return super.onOptionsItemSelected(item)

    }

    companion object {
        const val DATA_KEY = "DATA_KEY"
        const val TAG = "DetailActivityPresenter"
    }

}