package com.example.schoolapp.Adapter

import android.R
import android.content.Context
import android.content.Context.LAYOUT_INFLATER_SERVICE
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentPagerAdapter
import androidx.viewpager.widget.ViewPager
import com.example.schoolapp.Fragment.BlankFragment
import com.example.schoolapp.Fragment.ChatFragment
import com.example.schoolapp.Fragment.NewFeedFragment
import android.view.MotionEvent
import android.view.GestureDetector




class ViewPagerAdapter( fragmentManager: androidx.fragment.app.FragmentManager,var newFeedFragment: NewFeedFragment,var chatFragment: ChatFragment) : FragmentPagerAdapter(fragmentManager),NewFeedFragment.ItemClickHandler {
    override fun onItemClicked(tempUserId: Int) {

    }

    override fun getItem(position: Int): Fragment {
        when (position) {
            0 -> {
                return newFeedFragment
            }
            1 -> {
                return chatFragment
            }
        }
        return BlankFragment()
    }

    override fun getCount(): Int {
        return 4
    }

    }