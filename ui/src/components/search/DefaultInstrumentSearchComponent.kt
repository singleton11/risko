package components.search

import com.arkivanov.decompose.ComponentContext

class DefaultInstrumentSearchComponent(private val componentContext: ComponentContext) : InstrumentSearchComponent, ComponentContext by componentContext 