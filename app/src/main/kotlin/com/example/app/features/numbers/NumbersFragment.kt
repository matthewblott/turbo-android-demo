package com.example.app.features.numbers

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.app.R
import com.example.app.base.NavDestination
import com.example.app.util.NUMBERS_URL
import com.google.android.material.button.MaterialButton
import dev.hotwire.turbo.fragments.TurboFragment
import dev.hotwire.turbo.nav.TurboNavGraphDestination
import dev.hotwire.turbo.views.TurboView
import dev.hotwire.turbo.visit.TurboVisitAction
import dev.hotwire.turbo.visit.TurboVisitOptions

@TurboNavGraphDestination(uri = "turbo://fragment/numbers")
class NumbersFragment : TurboFragment(), NavDestination, NumbersFragmentCallback {
//  private val numbersAdapter = NumbersAdapter(this)

  private lateinit var turboView: TurboView

  override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
    return inflater.inflate(R.layout.fragment_numbers, container, false)
  }

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)

    val id = dev.hotwire.turbo.R.id.turbo_view

    turboView = view.findViewById(id)

    val foo = this.activity?.supportFragmentManager?.findFragmentById(R.id.fragment_web)

    initView(view)
  }

  private fun initView(view: View) {

    val button1 = view.findViewById<MaterialButton>(R.id.button1)
    button1?.setOnClickListener {
      val url = "http://10.0.2.2:3000/customers"
//      navigateBack()


      val visitOptions = TurboVisitOptions(action = TurboVisitAction.REPLACE)
//      turboView.visit(url, visitOptions)



//      navigate(url, TurboVisitOptions(action = TurboVisitAction.REPLACE))

//      val webFragment = Fragment.newInstance(url)
//      this.activity?.supportFragmentManager?.commit {
//        replace(R.id.main_nav_host, webFragment)
//      }
//      navigate("http://10.0.2.2:3000/customers")
    }

//    view.findViewById<RecyclerView>(R.id.recycler_view).apply {
//      layoutManager = LinearLayoutManager(view.context)
//      adapter = numbersAdapter.apply {
//        setData((1..100).toList())
//      }
//    }
  }

  override fun onItemClicked(number: Int) {
    navigate("$NUMBERS_URL/$number")
  }
}
