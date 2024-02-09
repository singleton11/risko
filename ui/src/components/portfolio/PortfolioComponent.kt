package components.portfolio

import Currency
import Position
import com.arkivanov.decompose.value.Value

interface PortfolioComponent {
    val model: Value<Model>

    data class Model(val positions: List<Position>, val currency: Currency)
}