package com.grizzhacks.grizzhacks.announcements

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
import com.grizzhacks.grizzhacks.core.EntityController
import com.grizzhacks.grizzhacks.core.EntityPresenter
import com.grizzhacks.grizzhacks.core.EntityPresenterImpl
import com.grizzhacks.grizzhacks.hide
import com.grizzhacks.grizzhacks.show

/**
 * Fragment displays a list of accounts.
 */
class AnnouncementFragment: Fragment(), EntityController<Announcement> {
    private lateinit var root: View
    private lateinit var recyclerView: RecyclerView
    private lateinit var progressBar: ProgressBar

    private val adapter = AnnouncementAdapter()
    private val presenter: EntityPresenter by lazy { EntityPresenterImpl(this, AnnouncementInteractor(context)) }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater?.inflate(R.layout.fragment_announcement, container, false)

        root = view!!
        recyclerView = view.findViewById<RecyclerView>(R.id.announcement_list)
        progressBar = view.findViewById<ProgressBar>(R.id.progress)

        val linearLayoutManager = LinearLayoutManager(context)
        recyclerView.layoutManager = linearLayoutManager
        recyclerView.adapter = adapter

        presenter.fetch()

        return view
    }

    override fun onFetched(entities: List<Announcement>) {
        adapter.items = entities
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
        val FRAGMENT_NAME: String = AnnouncementFragment::class.java.simpleName

        fun newInstance(): AnnouncementFragment {
            val fragment = AnnouncementFragment()
            fragment.arguments = Bundle()

            return fragment
        }
    }
}