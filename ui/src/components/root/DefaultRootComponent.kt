package components.root

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.router.stack.ChildStack
import com.arkivanov.decompose.router.stack.StackNavigation
import com.arkivanov.decompose.router.stack.bringToFront
import com.arkivanov.decompose.router.stack.childStack
import com.arkivanov.decompose.value.MutableValue
import com.arkivanov.decompose.value.Value
import com.arkivanov.decompose.value.update
import components.portfolio.DefaultPortfolioComponent
import components.portfolio.PortfolioComponent
import components.root.RootComponent.Child
import components.search.DefaultInstrumentSearchComponent
import components.search.InstrumentSearchComponent
import kotlinx.serialization.Serializable

class DefaultRootComponent(componentContext: ComponentContext) : RootComponent, ComponentContext by componentContext {
    private val navigation = StackNavigation<Config>()

    override val stack: Value<ChildStack<*, Child>>
        get() = childStack(
                source = navigation,
                serializer = Config.serializer(),
                initialConfiguration = Config.Portfolio,
                handleBackButton = true,
                childFactory = ::child
        )

    private val _tabChosen: MutableValue<RootComponent.Tab> = MutableValue(initialValue = RootComponent.Tab.Portfolio)
    override val tabChosen: Value<RootComponent.Tab>
        get() = _tabChosen

    override fun onInstrumentSearchClick() {
        navigation.bringToFront(Config.InstrumentSearch)
        _tabChosen.update { RootComponent.Tab.InstrumentSearch }
    }

    override fun onPortfolioClick() {
        navigation.bringToFront(Config.Portfolio)
        _tabChosen.update { RootComponent.Tab.Portfolio }
    }

    private fun child(config: Config, childComponentContext: ComponentContext): Child = when (config) {
        is Config.Portfolio -> Child.Portfolio(portfolioComponent(childComponentContext))
        is Config.InstrumentSearch -> Child.InstrumentSearch(instrumentSearchComponent(childComponentContext))
    }

    private fun portfolioComponent(componentContext: ComponentContext): PortfolioComponent = DefaultPortfolioComponent(componentContext)
    private fun instrumentSearchComponent(componentContext: ComponentContext): InstrumentSearchComponent = DefaultInstrumentSearchComponent(componentContext)

    @Serializable
    private sealed interface Config {
        @Serializable
        data object Portfolio : Config

        @Serializable
        data object InstrumentSearch : Config
    }
}