package components.root

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.router.stack.ChildStack
import com.arkivanov.decompose.router.stack.StackNavigation
import com.arkivanov.decompose.router.stack.childStack
import com.arkivanov.decompose.value.Value
import com.arkivanov.essenty.parcelable.Parcelable
import com.arkivanov.essenty.parcelable.Parcelize
import components.portfolio.DefaultPortfolioComponent
import components.portfolio.PortfolioComponent
import components.root.RootComponent.Child

class DefaultRootComponent(componentContext: ComponentContext) : RootComponent, ComponentContext by componentContext {
    private val navigation = StackNavigation<Config>()

    override val stack: Value<ChildStack<*, Child>>
        get() = childStack(source = navigation, initialConfiguration = Config.Portfolio, handleBackButton = true, childFactory = ::child)

    private fun child(config: Config, childComponentContext: ComponentContext): Child = when (config) {
        is Config.Portfolio -> Child.Portfolio(portfolioComponent(childComponentContext))
    }

    private fun portfolioComponent(componentContext: ComponentContext): PortfolioComponent = DefaultPortfolioComponent(componentContext)

    private sealed interface Config: Parcelable {
        @Parcelize
        data object Portfolio : Config
    }
}