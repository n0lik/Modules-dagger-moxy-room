package co.n0lik.test.mainscreen

import android.os.Bundle
import android.support.design.widget.FloatingActionButton
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.Toolbar
import android.util.Log
import android.view.Menu
import android.widget.Toast
import com.arellomobile.mvp.MvpAppCompatActivity
import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import io.reactivex.disposables.CompositeDisposable
import co.n0lik.test.App
import co.n0lik.test.di.ActivityScope
import co.n0lik.test.model.SampleEntity
import co.n0lik.test.mainscreen.adapter.RecyclerViewAdapter
import co.n0lik.test.mainscreen.di.MainActivityComponent
import co.n0lik.test.action.ShowDetailScreen
import javax.inject.Inject

@ActivityScope
class MainActivity : MvpAppCompatActivity(), MainView {

    override fun showErrorMsg(msg: String) {
        Toast.makeText(this@MainActivity, msg, Toast.LENGTH_LONG).show()
    }

    override fun showItems(list: List<SampleEntity>) {
        recyclerViewAdapter.addList(list)
    }

    override fun showItem(sampleEntity: SampleEntity) {
        recyclerViewAdapter.add(sampleEntity)
    }

    @Inject
    @InjectPresenter
    lateinit var presenter: MainPresenter

    @ProvidePresenter
    fun provideMainPresenter() = presenter

    private val disposable = CompositeDisposable()

    @Inject
    lateinit var recyclerViewAdapter: RecyclerViewAdapter

    @Inject
    lateinit var showDetailScreen: ShowDetailScreen

    private val recyclerView by lazy {
        findViewById<RecyclerView>(R.id.recyclerView)
    }
    private val toolbar1: Toolbar by lazy {
        findViewById<Toolbar>(R.id.toolbar)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        inject()
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        setSupportActionBar(toolbar1)

        recyclerView.apply{
            this.adapter = recyclerViewAdapter
            addItemDecoration(DividerItemDecoration(this@MainActivity, RecyclerView.VERTICAL))
        }

        disposable.add(
                recyclerViewAdapter.subjectClick
                        .subscribe({
                                    showDetailScreen.showDetail(this@MainActivity, it)
                                }, {
                                    it.printStackTrace()
                                }))

        Log.d(TAG, "Presenter hashCode = ${presenter.hashCode()}")
    }

    private fun inject(){
        MainActivityComponent.Initializer
                .init((applicationContext as App).getAppComponent())
                .inject(this@MainActivity)
    }

    override fun onDestroy() {
        disposable.clear()
        super.onDestroy()
        Log.d(TAG, "$TAG has been destroyed")
    }

    companion object {
        const val TAG = "MainActivity"
    }

}
