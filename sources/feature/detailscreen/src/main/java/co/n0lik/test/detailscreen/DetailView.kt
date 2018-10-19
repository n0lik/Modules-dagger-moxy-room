package co.n0lik.test.detailscreen

import com.arellomobile.mvp.MvpView
import com.arellomobile.mvp.viewstate.strategy.SkipStrategy
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType
import co.n0lik.test.model.SampleEntity

interface DetailView: MvpView {

    @StateStrategyType(SkipStrategy::class)
    fun showData(entity: SampleEntity)

}