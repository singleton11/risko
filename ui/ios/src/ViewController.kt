import androidx.compose.ui.window.ComposeUIViewController
import com.arkivanov.decompose.DefaultComponentContext
import com.arkivanov.decompose.ExperimentalDecomposeApi
import com.arkivanov.decompose.lifecycle.ApplicationLifecycle
import components.root.DefaultRootComponent
import components.root.RootContent
import platform.UIKit.UIViewController

@OptIn(ExperimentalDecomposeApi::class)
fun ViewController(): UIViewController = ComposeUIViewController {
    RootContent(DefaultRootComponent(componentContext = DefaultComponentContext(lifecycle = ApplicationLifecycle())))
}