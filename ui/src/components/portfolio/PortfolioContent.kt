package components.portfolio

import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme.typography
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp

@Composable
fun PortfolioContent(component: PortfolioComponent) {
    Column(
        Modifier
            .padding(30.dp)
            .fillMaxWidth()
            .wrapContentSize(Alignment.Center)
    ) {
        Box(
            modifier = Modifier
                .fillMaxHeight()
                .wrapContentSize(Alignment.Center)
        ) {
            Text(
                "Portfolio",
                textAlign = TextAlign.Center,
                style = typography.headlineLarge
            )
        }
    }
}