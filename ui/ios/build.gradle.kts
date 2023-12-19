import org.jetbrains.kotlin.gradle.plugin.mpp.Framework
import org.jetbrains.kotlin.gradle.plugin.mpp.KotlinNativeTarget

kotlin {
    targets
        .filterIsInstance<KotlinNativeTarget>()
        .flatMap { it.binaries }
        .filterIsInstance<Framework>()
        .forEach {
            it.export("com.arkivanov.decompose:decompose:2.2.0-compose-experimental-alpha05")
        }
}