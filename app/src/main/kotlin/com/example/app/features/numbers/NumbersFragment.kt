package com.example.app.features.numbers

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.app.R
import com.example.app.base.NavDestination
import com.example.app.util.NUMBERS_URL
import dev.hotwire.turbo.fragments.TurboFragment
import dev.hotwire.turbo.nav.TurboNavGraphDestination

@TurboNavGraphDestination(uri = "turbo://fragment/numbers")
class NumbersFragment : TurboFragment(), NavDestination, NumbersFragmentCallback {
  private val numbersAdapter = NumbersAdapter(this)

  override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
    return inflater.inflate(R.layout.fragment_numbers, container, false)
  }

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)
    initView(view)
  }

  private fun initView(view: View) {
    view.findViewById<RecyclerView>(R.id.recycler_view).apply {
      layoutManager = LinearLayoutManager(view.context)
      adapter = numbersAdapter.apply {
        setData((1..100).toList())
      }
    }
  }

  override fun onItemClicked(number: Int) {
    navigate("$NUMBERS_URL/$number")
  }
}
