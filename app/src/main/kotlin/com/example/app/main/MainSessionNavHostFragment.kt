package com.example.app.main

import androidx.fragment.app.Fragment
import dev.hotwire.strada.Bridge
import dev.hotwire.turbo.config.TurboPathConfiguration
import com.example.app.features.web.NumbersFragment
import com.example.app.features.web.WebFragment
import com.example.app.features.web.WebHomeFragment
import dev.hotwire.turbo.session.TurboSessionNavHostFragment
import kotlin.reflect.KClass

@Suppress("unused")
class MainSessionNavHostFragment : TurboSessionNavHostFragment() {
    override val sessionName = "main"
    override val startLocation = "http://10.0.2.2:45678/numbers"

    override val registeredFragments: List<KClass<out Fragment>>
        get() = listOf(
            WebFragment::class,
            WebHomeFragment::class,
            NumbersFragment::class,
        )

    override val pathConfigurationLocation: TurboPathConfiguration.Location
        get() = TurboPathConfiguration.Location(
            assetFilePath = "json/configuration.json"
        )

    override fun onSessionCreated() {
        super.onSessionCreated()
        Bridge.initialize(session.webView)
    }
}
