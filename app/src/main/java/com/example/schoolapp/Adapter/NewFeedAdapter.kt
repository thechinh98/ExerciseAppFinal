package com.example.schoolapp.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.schoolapp.Activity.ActivityMain
import com.example.schoolapp.Fragment.NewFeedFragment
import com.example.schoolapp.Item.ItemsNewFeed
import com.example.schoolapp.Item.ItemsUserData
import com.example.schoolapp.R
import kotlinx.android.synthetic.main.item_new_feed.view.*

class NewFeedAdapter (private val myFeedDataset : ArrayList<ItemsNewFeed>, private val myUserDataset: ArrayList<ItemsUserData>) :
RecyclerView.Adapter<NewFeedAdapter.MyViewHolder>() {
    var callBack: NewFeedFragment.ItemClickHandler? = null

    class MyViewHolder(val view: View) : RecyclerView.ViewHolder(view) {
        fun initView(
            itemsNewFeed: ItemsNewFeed,
            itemsUserData: ItemsUserData,
            callBack: NewFeedFragment.ItemClickHandler?
        ) {
            var tempUserId = itemsNewFeed.userId
            view.img_profile.setImageResource(itemsUserData.imageProfileResource!!)
            view.txt_username.text = itemsUserData.username
            view.txt_info.text = itemsNewFeed.postTime
            view.txt_status.text = itemsNewFeed.content
            view.img_status.setImageResource(itemsNewFeed.imageContentResource!!)
            view.txt_price.text = itemsNewFeed.price
            view.checkBox.setChecked(itemsNewFeed.checkHeart!!)
            view.setOnClickListener {
                callBack?.onItemClicked(tempUserId)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_new_feed, parent, false)
        return MyViewHolder(view)
    }

    override fun getItemCount(): Int {
        return myFeedDataset.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        var tempUserId = myFeedDataset[position].userId
        holder.initView(myFeedDataset[position], myUserDataset[tempUserId], callBack)

    }
   
}
