package com.example.app.strada

import dev.hotwire.strada.BridgeComponentFactory

val bridgeComponentFactories = listOf(
    BridgeComponentFactory("form", ::FormComponent),
    BridgeComponentFactory("menu", ::MenuComponent),
    BridgeComponentFactory("overflow-menu", ::OverflowMenuComponent)
)
