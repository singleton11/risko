package components.root

import com.arkivanov.decompose.router.stack.ChildStack
import com.arkivanov.decompose.value.Value
import components.portfolio.PortfolioComponent

interface RootComponent {
    val stack: Value<ChildStack<*, Child>>
    
    sealed interface Child {
        class Portfolio(val component: PortfolioComponent): Child
    }
}