package com.example.schoolapp.Fragment

import android.content.ContentValues.TAG
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.schoolapp.Activity.ActivityMain
import com.example.schoolapp.Adapter.ChatAdapter
import com.example.schoolapp.Item.ItemsChat
import com.example.schoolapp.Item.ItemsUserData
import com.example.schoolapp.R
import kotlinx.android.synthetic.main.fragment_chat.*


class ChatFragment : Fragment() {
    var dummyUserData = createDummyUserData()
    var dummyChatData = createDummyChatData()
    var chatAdapter : ChatAdapter? = null
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        var view = inflater.inflate(R.layout.fragment_chat, container, false)
        Log.d(TAG,"Chat is create")
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        chatAdapter = ChatAdapter(dummyChatData, dummyUserData)
            rcc_chat.apply {
                layoutManager = LinearLayoutManager(activity)
                adapter = chatAdapter
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
        return chatList
    }

    fun getIndexById(ChatList: ArrayList<ItemsChat>, Id: Int): Int {

        var index = 0
        for (item: ItemsChat in ChatList) {
            if (item.userId == Id) {
                return index
            } else {
                index++
            }
        }
        return -1
    }

    fun reorderById(Id: Int) {
        var tempIndex = getIndexById(dummyChatData, Id)

        if (tempIndex == -1) {
            dummyChatData.add(0,ItemsChat(Id, null, null, null))
        } else {
            var tempItemsChat = dummyChatData.get(tempIndex)
            dummyChatData.removeAt(getIndexById(dummyChatData, Id))
            dummyChatData.add(0, tempItemsChat)
        }
    }
    fun changeOrderList(){
        if(activity is ActivityMain){
            var activity = activity as ActivityMain
            var tempUserId = activity.currentId
            reorderById(tempUserId)
            chatAdapter?.notifyDataSetChanged()
        }
    }
}
