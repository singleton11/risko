package io.github.singleton11

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.arkivanov.decompose.defaultComponentContext
import components.root.DefaultRootComponent
import components.root.RootContent

class MainActivity: ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        
        setContent {
            RootContent(DefaultRootComponent(defaultComponentContext()))
        }   
    }
}