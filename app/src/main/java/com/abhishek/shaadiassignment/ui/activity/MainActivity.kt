package com.abhishek.shaadiassignment.ui.activity

import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.GridLayoutManager
import android.view.View
import android.widget.Toast
import com.abhishek.shaadiassignment.ui.adapter.MovieAdapter
import com.abhishek.shaadiassignment.viewmodel.MainActivityViewModel
import com.abhishek.shaadiassignment.R
import com.abhishek.shaadiassignment.localdb.AppDb
import com.abhishek.shaadiassignment.model.DataListItem
import com.abhishek.shaadiassignment.model.DataListItemtoDB
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    var dblist : ArrayList<DataListItemtoDB> = ArrayList()
    private lateinit var mainActivityViewModel: MainActivityViewModel
    lateinit var movieAdapter: MovieAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val mLayoutManager =
            GridLayoutManager(this@MainActivity, 1)

        moviesRecyclerView.layoutManager = mLayoutManager
        moviesRecyclerView.itemAnimator =
            DefaultItemAnimator()
        moviesRecyclerView.isNestedScrollingEnabled = false
        mainActivityViewModel = ViewModelProviders.of(this).get(MainActivityViewModel::class.java!!)

        if (savedInstanceState == null) run {
            getMoviesData()
        }


    }


//    setupRecyclerView(results)
    private fun getMoviesData() {
        progressBar.visibility= View.VISIBLE
        mainActivityViewModel.mLiveData()?.observe(this,
            Observer<List<DataListItem>> { results -> savedatatoLocalDB(results!!)})
    }

    fun savedatatoLocalDB(results: List<DataListItem>?) {
        dblist.clear()
        for ((index, item) in results!!.withIndex()) {
            val preparedb:DataListItemtoDB=DataListItemtoDB(index,item.gender,0,item.name,item.location,item.email,item.dob,item.phone,item.cell,item.objid,item.picture,item.nat)
            dblist.add(preparedb)
        }
        GlobalScope.launch {
            AppDb.getInstance(this@MainActivity).saveDao().saveAllData(dblist!!)
            dblist.clear()
            dblist = AppDb.getInstance(this@MainActivity).saveDao().getAllData() as ArrayList<DataListItemtoDB>
            setupRecyclerView(dblist)

        }

    }
    fun setupRecyclerView(results: List<DataListItemtoDB>) = CoroutineScope(Dispatchers.Main).launch {
        if (results.size>0) {
            progressBar.visibility= View.GONE
            movieAdapter = MovieAdapter(results, this@MainActivity)
            moviesRecyclerView.adapter = movieAdapter
            movieAdapter?.notifyDataSetChanged()
        } else {
            Toast.makeText(this@MainActivity, "List Null", Toast.LENGTH_SHORT).show()
        }
    }

    fun updateActionstatus(mData: DataListItemtoDB) {
        GlobalScope.launch {
            AppDb.getInstance(this@MainActivity).saveDao().update(mData!!)


        }
    }

}

