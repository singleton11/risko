package components.portfolio

import Currency
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.arkivanov.decompose.extensions.compose.jetbrains.subscribeAsState

@Composable
fun PortfolioContent(component: PortfolioComponent, innerPadding: PaddingValues) {
    val positionsModel by component.model.subscribeAsState()

    Column(Modifier.padding(innerPadding)) {
        positionsModel.positions.forEach { position ->
            Row {
                PositionCell(position.instrumentName)
                PositionCell(position.amount.toString())
                PositionCell("${position.averagePrice}${position.currency.symbol}")
                PositionCell("${position.currentPrice}${position.currency.symbol}")
                PositionCell("${position.value}${positionsModel.currency.symbol}")
                PnlPositionCell(position.unrealizedPnl, positionsModel.currency)
            }
        }
    }
}

@Composable
fun PositionCell(value: String) {
    Text(value, Modifier.padding(5.dp))
}

@Composable
fun PnlPositionCell(value: Double, currency: Currency) {
    Text(
        text = "${if (value > 0) "+" else ""}$value${currency.symbol}",
        modifier = Modifier.padding(5.dp), color = if (value > 0) Color(0, 200, 0) else Color.Red
    )
}