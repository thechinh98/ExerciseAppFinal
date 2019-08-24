package com.example.schoolapp.Adapter

import android.annotation.TargetApi
import android.icu.util.ValueIterator
import android.os.Build
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.RecyclerView
import com.example.schoolapp.Item.ItemsChat
import com.example.schoolapp.Item.ItemsNewFeed
import com.example.schoolapp.Item.ItemsUserData
import com.example.schoolapp.R
import kotlinx.android.synthetic.main.item_chat.view.*

class ChatAdapter (private val myChatDataset : ArrayList<ItemsChat>, private val myUserDataset: ArrayList<ItemsUserData>) :
    RecyclerView.Adapter<ChatAdapter.MyViewHolder>() {
    class MyViewHolder(val view : View) : RecyclerView.ViewHolder(view){


        @TargetApi(Build.VERSION_CODES.M)
        @RequiresApi(Build.VERSION_CODES.M)
        fun initView(itemsChat: ItemsChat, itemsUserData: ItemsUserData){
            var tempUserId : Int = itemsChat.userId
            view.img_profile.setImageResource(itemsUserData.imageProfileResource!!)
            view.txt_username.text = itemsUserData.username
            view.txt_mes.text = itemsChat.tempMes
            view.txt_unread_mes.text = itemsChat.unReadMes
            view.txt_last_mes.text = itemsChat.lastMesTime
            if(itemsChat.unReadMes == null){
                view.txt_username.setTextAppearance(R.style.fontNoNewMes)
                view.txt_unread_mes.setBackgroundResource(R.drawable.oval_no_unread_mes )
            } else {
                view.txt_username.setTextAppearance(R.style.fontNewMes)
            }
        }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChatAdapter.MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_chat, parent, false)
        return MyViewHolder(view)
    }

    override fun getItemCount(): Int {
        return myChatDataset.size
    }


    override fun onBindViewHolder(holder: ChatAdapter.MyViewHolder, position: Int) {
        var tempUserId = myChatDataset[position].userId
        holder.initView(myChatDataset[position], myUserDataset[tempUserId])
    }

}