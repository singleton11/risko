package components.root

import AppTheme
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import com.arkivanov.decompose.extensions.compose.jetbrains.stack.Children
import com.arkivanov.decompose.extensions.compose.jetbrains.stack.animation.fade
import com.arkivanov.decompose.extensions.compose.jetbrains.stack.animation.plus
import com.arkivanov.decompose.extensions.compose.jetbrains.stack.animation.scale
import com.arkivanov.decompose.extensions.compose.jetbrains.stack.animation.stackAnimation
import com.arkivanov.decompose.extensions.compose.jetbrains.subscribeAsState
import components.portfolio.PortfolioContent
import components.root.RootComponent.Child
import components.search.InstrumentSearchContent

@Composable
fun RootContent(component: RootComponent) {
    val tabChosen by component.tabChosen.subscribeAsState()
    AppTheme {
        Scaffold(bottomBar = {
            NavigationBar {
                NavigationBarItem(
                    selected = tabChosen is RootComponent.Tab.Portfolio,
                    onClick = { component.onPortfolioClick() },
                    icon = { Icon(imageVector = Icons.Default.Home, contentDescription = "Portfolio") }
                )
                NavigationBarItem(
                    selected = tabChosen is RootComponent.Tab.InstrumentSearch,
                    onClick = { component.onInstrumentSearchClick() },
                    icon = { Icon(imageVector = Icons.Default.Search, contentDescription = "Instrument search") }
                )
            }
        }) {
            Children(
                stack = component.stack,
                modifier = Modifier.fillMaxSize(),
                animation = stackAnimation(fade() + scale())
            ) {
                when (val instance = it.instance) {
                    is Child.Portfolio -> PortfolioContent(component = instance.component)
                    is Child.InstrumentSearch -> InstrumentSearchContent(component = instance.component)
                }
            }
        }
    }
}