package components.portfolio

import Position
import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.value.MutableValue
import com.arkivanov.decompose.value.Value

class DefaultPortfolioComponent(componentContext: ComponentContext): PortfolioComponent, ComponentContext by componentContext {
    override val model: Value<PortfolioComponent.Model>
        get() = MutableValue(
            PortfolioComponent.Model(
                listOf(
                    Position("APPL", 1, Currency.Usd, 100.0, 102.0, 1020.0, 20.0),
                    Position("INTL", 1, Currency.Usd, 100.0, 102.0, 1020.0, -20.0),
                ),
                Currency.Rub
            )
        )
}