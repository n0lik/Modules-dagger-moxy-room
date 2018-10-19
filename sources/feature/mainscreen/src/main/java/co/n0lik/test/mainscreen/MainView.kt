package co.n0lik.test.mainscreen

import com.arellomobile.mvp.MvpView
import com.arellomobile.mvp.viewstate.strategy.*
import co.n0lik.test.model.SampleEntity


interface MainView: MvpView {

    @StateStrategyType(AddToEndSingleStrategy::class)
    fun showErrorMsg(msg: String)

    @StateStrategyType(AddToEndStrategy::class)
    fun showItem(sampleEntity: SampleEntity)

    @StateStrategyType(AddToEndStrategy::class)
    fun showItems(list: List<SampleEntity>)

}