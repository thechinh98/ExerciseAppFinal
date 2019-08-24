package com.example.schoolapp.Fragment

import android.content.Intent
import android.graphics.Rect
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.schoolapp.Activity.ActivityMain
import com.example.schoolapp.Adapter.NewFeedAdapter
import com.example.schoolapp.Communicator.Communicator
import com.example.schoolapp.Item.ItemsChat
import com.example.schoolapp.Item.ItemsNewFeed
import com.example.schoolapp.Item.ItemsUserData

import com.example.schoolapp.R
import kotlinx.android.synthetic.main.fragment_new_feed2.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
class NewFeedFragment : Fragment() {
    // TODO: Rename and change parameterstypes of
    var newFeedList : ArrayList<ItemsNewFeed> = creatDummyFeedData()
    var userList : ArrayList<ItemsUserData> = createDummyUserData()
    lateinit var viewAdapter: NewFeedAdapter
    lateinit var viewManager: RecyclerView.LayoutManager
    var model: Communicator? = null
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_new_feed2, container, false)

    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        var spacing = SpaceItemDecoration(14)
        model= ViewModelProviders.of(activity!!).get(Communicator::class.java)
        super.onViewCreated(view, savedInstanceState)
        viewAdapter = NewFeedAdapter(newFeedList,userList)
        rcc_new_feed.apply {
            layoutManager = LinearLayoutManager(activity)
            adapter = viewAdapter
        }
        rcc_new_feed.addItemDecoration(spacing)
        viewAdapter.callBack = object :ItemClickHandler {
            override fun onItemClicked(tempUserId: Int) {
                if(activity is ActivityMain){
                    var activity = activity as ActivityMain
                    activity.currentId = tempUserId
                    activity.chatViewPageChange()
                }
            }

        }
    }

    fun createDummyUserData(): ArrayList<ItemsUserData> {
        var userList = ArrayList<ItemsUserData>()
        userList.add(ItemsUserData(0, R.drawable.profile, "Alex Pro"))
        userList.add(ItemsUserData(1, R.drawable.profile, "Cris Devil"))
        userList.add(ItemsUserData(2, R.drawable.profile, "Pew pew"))
        userList.add(ItemsUserData(3, R.drawable.profile, "Mixi Gaming"))
        userList.add(ItemsUserData(4, R.drawable.profile, "Xemesis"))
        userList.add(ItemsUserData(5, R.drawable.profile, "Viruss"))
        userList.add(ItemsUserData(6, R.drawable.profile, "Misthy"))
        return userList
    }
    fun createDummyChatData(): ArrayList<ItemsChat> {
        var chatList = ArrayList<ItemsChat>()
        chatList.add(ItemsChat(0, "Shall we meet today?", "1", "5 : 45 PM"))
        chatList.add(ItemsChat(1, "Hahahaha… \uD83D\uDE02", "2", "11 : 12 AM"))
        chatList.add(ItemsChat(2, "Sounds perfect to me. 😎", null, "10 : 45 AM"))
        chatList.add(ItemsChat(3, "Sounds perfect to me. 😎", null, "10 : 45 AM"))
        chatList.add(ItemsChat(4, "Sounds perfect to me. 😎", null, "10 : 45 AM"))
        chatList.add(ItemsChat(5, "Sounds perfect to me. 😎", null, "10 : 45 AM"))
        return chatList
    }
    fun creatDummyFeedData(): ArrayList<ItemsNewFeed>{
        var feedList = ArrayList<ItemsNewFeed>()
        feedList.add(ItemsNewFeed(0,"Today, 03:24 PM","What is the loop of Creation? How is there something from nothing? In spite of the fact that it is impossible to prove that anythin….",R.drawable.rectangle_copy,"$340.00",false))
        feedList.add(ItemsNewFeed(1, "Yesterday","I am looking for a chilled out roommate for a house on 17th floor of a XYZ appartment.", 0,"$290.00", true))
        feedList.add(ItemsNewFeed(2, "Yesterday","I am looking for a chilled out roommate for a house on 17th floor of a XYZ appartment.", 0,"$290.00", true))
        feedList.add(ItemsNewFeed(3, "Yesterday","I am looking for a chilled out roommate for a house on 17th floor of a XYZ appartment.", 0,"$290.00", true))
        feedList.add(ItemsNewFeed(4, "Yesterday","I am looking for a chilled out roommate for a house on 17th floor of a XYZ appartment.", 0,"$290.00", true))
        feedList.add(ItemsNewFeed(5, "Yesterday","I am looking for a chilled out roommate for a house on 17th floor of a XYZ appartment.", 0,"$290.00", true))
        return feedList
    }
    fun getIndexById(tempId : Int, myChatDataset: ArrayList<ItemsChat>): Int{
        var index : Int = 0
        for(item : ItemsChat in myChatDataset){
            if(item.userId == tempId){
                return index
            } else {
                index++
            }
        }
        return 0
    }
    class SpaceItemDecoration : RecyclerView.ItemDecoration{
        var spaceVertical: Int
        constructor(spaceVer: Int){
            this.spaceVertical = spaceVer
        }

        override fun getItemOffsets(outRect: Rect, view: View, parent: RecyclerView, state: RecyclerView.State) {
            outRect.bottom = spaceVertical
            if(parent.getChildLayoutPosition(view) == 0){
                outRect.top = spaceVertical
            } else {
                outRect.top == 0
            }
        }
    }
    interface ItemClickHandler {
        fun onItemClicked(tempUserId: Int)
    }


}
