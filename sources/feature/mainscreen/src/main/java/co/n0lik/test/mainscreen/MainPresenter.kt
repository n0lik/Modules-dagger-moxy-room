package co.n0lik.test.mainscreen

import co.n0lik.test.repo.LocalRepo
import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpPresenter
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

@InjectViewState
class MainPresenter
    @Inject constructor(private val repo: LocalRepo): MvpPresenter<MainView>() {

    private val disposable = CompositeDisposable()

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        retrieveLocalEntities()
    }

    private fun retrieveLocalEntities(){
        disposable
                .add(repo.getAll()
                        .compose { applySchedulers(it) }
                        .subscribe ( viewState::showItems ) {
                            it.printStackTrace()
                        })
    }

    override fun detachView(view: MainView?) {
        super.detachView(view)
        disposable.clear()
    }

    private fun <T> applySchedulers(stream: Single<T>) =
            stream.subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())

}