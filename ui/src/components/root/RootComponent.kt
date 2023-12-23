package components.root

import com.arkivanov.decompose.router.stack.ChildStack
import com.arkivanov.decompose.value.Value
import components.portfolio.PortfolioComponent
import components.search.InstrumentSearchComponent
import kotlinx.coroutines.flow.Flow

interface RootComponent {
    val stack: Value<ChildStack<*, Child>>
    
    val tabChosen: Value<Tab>

    fun onInstrumentSearchClick()
    fun onPortfolioClick()

    sealed interface Child {
        class Portfolio(val component: PortfolioComponent): Child
        class InstrumentSearch(val component: InstrumentSearchComponent): Child
    }

    sealed interface Tab {
        object Portfolio: Tab
        object InstrumentSearch: Tab
    }
}