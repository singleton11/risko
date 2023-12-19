package components.root

import AppTheme
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.arkivanov.decompose.extensions.compose.jetbrains.stack.Children
import com.arkivanov.decompose.extensions.compose.jetbrains.stack.animation.fade
import com.arkivanov.decompose.extensions.compose.jetbrains.stack.animation.plus
import com.arkivanov.decompose.extensions.compose.jetbrains.stack.animation.scale
import com.arkivanov.decompose.extensions.compose.jetbrains.stack.animation.stackAnimation
import components.portfolio.PortfolioContent
import components.root.RootComponent.Child

@Composable
fun RootContent(component: RootComponent) {
    AppTheme {
        Scaffold {
            Children(
                stack = component.stack,
                modifier = Modifier.fillMaxSize(),
                animation = stackAnimation(fade() + scale())
            ) {
                when (val instance = it.instance) {
                    is Child.Portfolio -> PortfolioContent(component = instance.component)
                }
            }
        }
    }
}