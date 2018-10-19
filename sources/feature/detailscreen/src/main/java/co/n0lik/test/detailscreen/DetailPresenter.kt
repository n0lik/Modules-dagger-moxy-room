package co.n0lik.test.detailscreen

import android.util.Log
import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpPresenter
import co.n0lik.test.model.SampleEntity

@InjectViewState
class DetailPresenter: MvpPresenter<DetailView>() {

    private var entity: SampleEntity? = null

    override fun onDestroy() {
        super.onDestroy()
        Log.d("DetailPresenter", "onDestroy")
    }

    fun addModel(entity: SampleEntity){
        if(this.entity == null) this.entity = entity
        viewState.showData(entity)
    }

}