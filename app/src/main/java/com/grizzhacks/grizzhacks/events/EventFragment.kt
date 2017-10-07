package com.grizzhacks.grizzhacks.events

import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import com.grizzhacks.grizzhacks.R
import com.grizzhacks.grizzhacks.hide
import com.grizzhacks.grizzhacks.show

/**
 * Fragment displays a list of accounts.
 */
class EventFragment: Fragment(), EventController {
    private lateinit var root: View
    private lateinit var recyclerView: RecyclerView
    private lateinit var progressBar: ProgressBar

    private val adapter = EventAdapter()
    private val presenter: EventPresenter by lazy { EventPresenterImpl(this, EventInteractorImpl(context)) }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater?.inflate(R.layout.fragment_event, container, false)

        root = view!!
        recyclerView = view.findViewById<RecyclerView>(R.id.event_list)
        progressBar = view.findViewById<ProgressBar>(R.id.progress)

        val linearLayoutManager = LinearLayoutManager(context)
        recyclerView.layoutManager = linearLayoutManager
        recyclerView.adapter = adapter

        presenter.fetch()

        return view
    }

    override fun onFetched(events: List<Event>) {
        adapter.items = events
    }

    override fun onError(e: Throwable) {
        Snackbar.make(root, e.message.orEmpty(), Snackbar.LENGTH_SHORT).show()
    }

    override fun showProgress() {
        recyclerView.hide()
        progressBar.show()
    }

    override fun hideProgress() {
        progressBar.hide()
        recyclerView.show()
    }

    companion object {
        val FRAGMENT_NAME: String = EventFragment::class.java.simpleName

        fun newInstance(): EventFragment {
            val fragment = EventFragment()
            fragment.arguments = Bundle()

            return fragment
        }
    }
}