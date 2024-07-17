package com.example.app.main

import androidx.fragment.app.Fragment
import dev.hotwire.strada.Bridge
import dev.hotwire.turbo.config.TurboPathConfiguration
import com.example.app.features.imageviewer.ImageViewerFragment
import com.example.app.features.numbers.NumberBottomSheetFragment
import com.example.app.features.numbers.NumbersFragment
import com.example.app.features.web.WebBottomSheetFragment
import com.example.app.features.web.WebCustomersFragment
import com.example.app.features.web.WebFragment
import com.example.app.features.web.WebHomeFragment
import com.example.app.features.web.WebModalFragment
import com.example.app.util.HOME_URL
import com.example.app.util.customUserAgent
import com.example.app.util.initDayNightTheme
import dev.hotwire.turbo.session.TurboSessionNavHostFragment
import kotlin.reflect.KClass

@Suppress("unused")
class MainSessionNavHostFragment : TurboSessionNavHostFragment() {
    override val sessionName = "main"

    override val startLocation = HOME_URL

    override val registeredFragments: List<KClass<out Fragment>>
        get() = listOf(
            WebFragment::class,
            WebHomeFragment::class,
            WebCustomersFragment::class,
            WebModalFragment::class,
            WebBottomSheetFragment::class,
            NumbersFragment::class,
            NumberBottomSheetFragment::class,
            ImageViewerFragment::class
        )

    override val pathConfigurationLocation: TurboPathConfiguration.Location
        get() = TurboPathConfiguration.Location(
            assetFilePath = "json/configuration.json"
        )

    override fun onSessionCreated() {
        super.onSessionCreated()

        // Configure WebView
        session.webView.settings.userAgentString = session.webView.customUserAgent
        session.webView.initDayNightTheme()

        // Initialize Strada bridge with new WebView instance
        Bridge.initialize(session.webView)
    }
}
