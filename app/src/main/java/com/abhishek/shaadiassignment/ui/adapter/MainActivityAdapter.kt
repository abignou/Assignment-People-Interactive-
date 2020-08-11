package com.abhishek.shaadiassignment.ui.adapter

import android.content.Context
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import com.bumptech.glide.Glide
import com.abhishek.shaadiassignment.R
import com.abhishek.shaadiassignment.model.DataListItemtoDB
import com.abhishek.shaadiassignment.ui.activity.MainActivity

class MovieAdapter(private val moviesResult: List<DataListItemtoDB>, private val context: Context) : RecyclerView.Adapter<MovieViewHolder>(){

    private var movieSearchList: List<DataListItemtoDB>? = null

    init {
        this.movieSearchList = moviesResult
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.movie_item_layout, parent, false)
        return MovieViewHolder(view)
    }


    override fun getItemCount(): Int = movieSearchList!!.size


    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        var mData = movieSearchList!![position]
        holder.updateView(mData, context)
        holder.btnaccept.setOnClickListener(View.OnClickListener {
            mData.actionStatus=1;
            (context as MainActivity).updateActionstatus(mData);
            notifyDataSetChanged()
        })
        holder.btndecline.setOnClickListener(View.OnClickListener {

            mData.actionStatus=2;
            (context as MainActivity).updateActionstatus(mData);
            notifyDataSetChanged()
        })

    }

}

class MovieViewHolder(itemVIew: View) : RecyclerView.ViewHolder(itemVIew) {

    private var ivImage = itemVIew.findViewById<ImageView>(R.id.ivImage)
    private var tvname = itemVIew.findViewById<TextView>(R.id.tvname)
    private var tvage = itemVIew.findViewById<TextView>(R.id.tvage)
    private var tvlocation = itemVIew.findViewById<TextView>(R.id.tvlocation)
    var tvactionmsg = itemVIew.findViewById<TextView>(R.id.tvactionmsg)
    var btnaccept = itemVIew.findViewById<Button>(R.id.btnaccept)
    var ll_button=itemVIew.findViewById<LinearLayout>(R.id.ll_button)
    var btndecline = itemVIew.findViewById<Button>(R.id.btndecline)
    fun updateView(mdata: DataListItemtoDB, context: Context) {
        tvname.text = mdata.name?.title+" "+mdata.name?.first+" "+mdata.name?.last
        tvage.text=mdata.dob.age+" yrs "
        tvlocation.text=mdata.location.city+", "+mdata.location.state
        if(!mdata.picture.large.isNullOrEmpty()) {
            Glide.with(context)
                .load(mdata.picture.large)
                .into(ivImage)
        }
        if(mdata.actionStatus==1){
            tvactionmsg.visibility=View.VISIBLE
            tvactionmsg.text=context.getText(R.string.msg_accepted)
            ll_button.visibility=View.GONE
        }else if(mdata.actionStatus==2){
            tvactionmsg.visibility=View.VISIBLE
            tvactionmsg.text=context.getText(R.string.msg_decline)
            ll_button.visibility=View.GONE
        }else{
                tvactionmsg.visibility=View.GONE
            ll_button.visibility=View.VISIBLE
        }

    }

}